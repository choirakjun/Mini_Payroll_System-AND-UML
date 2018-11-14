import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Hourly_Employee extends Employee {
	//String Name;
	//double total_Tax;
	//double total_payroll;
	//Account account;
	//String working_title;

	int worked_hour;
	double hourly_wage;

	public Hourly_Employee(int SSN, double total_Tax, double total_payroll, int num, double balance,
			String working_title, int hour, double wage) {

		super(SSN, total_Tax, total_payroll, num, balance, working_title);

		this.worked_hour = hour;
		this.hourly_wage = wage;
		this.total_payroll = total_payroll();
		// �ش� ������ SSN���� ���ؼ� ������ TOTAL_TAX�� �����س��´�.
		Tax_Controller controller_ = forTaxController();
		controller_.save_total_tax_DB(this);

		// �̹� ���ִ� ���� �� ������ ���ִ� DB�� �о ���Ͽ� ���ִ� ���� ������ �Է��Ѵ�.
		Manager controller = forTax();
		controller.setTax(this);

	}
/*
	// �̹� ���ִ� ���� �� ������ ���ִ� DB�� �о ���Ͽ� ���ִ� ���� ������ �Է��Ѵ�
	public Manager forTax() {

		Controller_Factory factory = new Controller_Factory();
		Manager controller = factory.create_Manager();
		return controller;
	}
	// �ش� ������ SSN���� ���ؼ� ������ TOTAL_TAX�� �����س��´�.
	public Tax_Controller forTaxController() {

		Controller_Factory factory = new Controller_Factory();
		Tax_Controller controller = factory.create_Tax_Controller();
		return controller;
	}

	*/
	/*
	 * public double total_payroll() { return (hourly_wage*worked_hour); }
	 */

	public double total_payroll() {

		Salary_Strategy compute = new Hourly_Salary_Strategy();

		this.total_payroll = compute.compute_total_payroll(this);
		return total_payroll;

	}



}
