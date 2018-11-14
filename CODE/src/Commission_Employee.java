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

		// 해당 직원의 SSN보고 비교해서 세액을 TOTAL_TAX에 저장해놓는다.
		Tax_Controller controller_ = forTaxController();
		controller_.save_total_tax_DB(this);

		// 이미 써있는 직원 별 세금이 써있는 DB를 읽어서 파일에 써있는 세금 정보를 입력한다.
		Manager controller = forTax();
		controller.setTax(this);

	}
/*
	public String toString() {
		return "SSN: " + this.getSSN() + " TOTAL_PAYTOLL: " + this.getTotal_payroll() + " TOTAL_TAX: " + this.getTotal_Tax();
	}
	*/
/*
	// 해당 직원의 SSN보고 비교해서 세액을 TOTAL_TAX에 저장해놓는다.
	public Tax_Controller forTaxController() {

		Controller_Factory factory = new Controller_Factory();
		Tax_Controller controller = factory.create_Tax_Controller();
		return controller;
	}
	// 이미 써있는 직원 별 세금이 써있는 DB를 읽어서 파일에 써있는 세금 정보를 입력한다.
	public Manager forTax() {

		Controller_Factory factory = new Controller_Factory();
		Manager controller = factory.create_Manager();
		return controller;
	}
*/
//	public void savehumanresources() {

	//}
	/*
	 * //Sales클래스에서 SALESDB에 저장된 내용에서 에서 CommissionEmployee의 판매 액수를 받아온다 public
	 * double compute_commission_Salary() {
	 * 
	 * commission_salary=Sales.getEmployee_Salary(this); return commission_salary; }
	 * 
	 * public double total_payroll() { this.compute_commission_Salary(); return
	 * base_salary+(commission_rate*commission_salary); }
	 */
//총 월급을 계산한다.특히 이때 SALES객체를 이용해 최종 COMMISSION FEE를 계산할 수 있다.
	public double total_payroll() {

		//System.out.println("PAYROLL계산");

		Salary_Strategy compute = new Commission_Salary_Strategy();

		this.total_payroll = compute.compute_total_payroll(this);
		//System.out.println(this.total_payroll);
		return total_payroll;

	}

}
