import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Commission_Employee extends Employee {
	//String Name;
	//double total_Tax;
	//double total_payroll;
	//Account account;
	//String working_title;

	double commission_rate;
	double commission_salary;
	double base_salary;

	public Commission_Employee(int SSN, double total_Tax, double total_payroll, int num, double balance,
			String working_title, double rate, double commision_salary, double base_salary) {

		super(SSN, total_Tax, total_payroll, num, balance, working_title);

		this.commission_rate = rate;
		this.base_salary = base_salary;

		this.total_payroll = total_payroll();

		// �ش� ������ SSN���� ���ؼ� ������ TOTAL_TAX�� �����س��´�.
		Tax_Controller controller_ = forTaxController();
		controller_.save_total_tax_DB(this);

		// �̹� ���ִ� ���� �� ������ ���ִ� DB�� �о ���Ͽ� ���ִ� ���� ������ �Է��Ѵ�.
		Manager controller = forTax();
		controller.setTax(this);

	}
/*
	public String toString() {
		return "SSN: " + this.getSSN() + " TOTAL_PAYTOLL: " + this.getTotal_payroll() + " TOTAL_TAX: " + this.getTotal_Tax();
	}
	*/
/*
	// �ش� ������ SSN���� ���ؼ� ������ TOTAL_TAX�� �����س��´�.
	public Tax_Controller forTaxController() {

		Controller_Factory factory = new Controller_Factory();
		Tax_Controller controller = factory.create_Tax_Controller();
		return controller;
	}
	// �̹� ���ִ� ���� �� ������ ���ִ� DB�� �о ���Ͽ� ���ִ� ���� ������ �Է��Ѵ�.
	public Manager forTax() {

		Controller_Factory factory = new Controller_Factory();
		Manager controller = factory.create_Manager();
		return controller;
	}
*/
//	public void savehumanresources() {

	//}
	/*
	 * //SalesŬ�������� SALESDB�� ����� ���뿡�� ���� CommissionEmployee�� �Ǹ� �׼��� �޾ƿ´� public
	 * double compute_commission_Salary() {
	 * 
	 * commission_salary=Sales.getEmployee_Salary(this); return commission_salary; }
	 * 
	 * public double total_payroll() { this.compute_commission_Salary(); return
	 * base_salary+(commission_rate*commission_salary); }
	 */
//�� ������ ����Ѵ�.Ư�� �̶� SALES��ü�� �̿��� ���� COMMISSION FEE�� ����� �� �ִ�.
	public double total_payroll() {

		//System.out.println("PAYROLL���");

		Salary_Strategy compute = new Commission_Salary_Strategy();

		this.total_payroll = compute.compute_total_payroll(this);
		//System.out.println(this.total_payroll);
		return total_payroll;

	}

}
