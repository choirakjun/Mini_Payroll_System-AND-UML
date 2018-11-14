import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Base_Employee extends Employee {
	//String Name;
	//double total_Tax;
	//double total_payroll;
	//Account account;
	//String working_title;

	double base_salary;

	public Base_Employee(int SSN, double total_Tax, double total_payroll, int num, double balance, String working_title,
			double base_salary) {

		super(SSN, total_Tax, total_payroll, num, balance, working_title);

		this.base_salary = base_salary;
		this.total_payroll = base_salary;
		// this.savehumanresources();

		// 해당 직원의 SSN보고 비교해서 세액을 TOTAL_TAX에 저장해놓는다.
		Tax_Controller controller_ = forTaxController();
		controller_.save_total_tax_DB(this);

		// 이미 써있는 직원 별 세금이 써있는 DB를 읽어서 파일에 써있는 세금 정보를 입력한다.
		Manager controller = forTax();
		controller.setTax(this);
		// System.out.println("base생성"+this.total_Tax);
	}

	// 세금 계산을 하고, 세금을 계산해서 TOTAL_TAX에 저장하고 그 정보를 토대로 계산해서 직원 정보에 UPDATE

	// 총 월급을 계산한다.
	public double total_payroll() {
		return this.base_salary;
	}

	/*
	 * //FACTORY로부터 MANAGER(PURED FABRICATION을 호출). 그리고 MANAGER를 이용해 세금 정보를 입력한다.
	 * public Manager forTax() {
	 * 
	 * Controller_Factory factory = new Controller_Factory(); Manager controller =
	 * factory.create_Manager(); return controller; } //FACTORY로부터 TAX_CONTROLLER를
	 * RETURN받아 위에서 세액을 계산해 TOTAL_TAXDB에 저장한다 public Tax_Controller
	 * forTaxController() {
	 * 
	 * Controller_Factory factory = new Controller_Factory(); Tax_Controller
	 * controller = factory.create_Tax_Controller(); return controller; }
	 */
/*
	public String toString() {
		return "SSN: " + this.getSSN() + " TOTAL_PAYTOLL: " + this.getTotal_payroll() + " TOTAL_TAX: "
				+ this.getTotal_Tax();
	}
*/
	/*
	 * public void savehumanresources() {
	 * 
	 * String fileName =
	 * "C:\\Users\\good\\Desktop\\이클립스\\OOAD\\src\\HumanResourcesDB.txt"; try {
	 * 
	 * // 파일 객체 생성 File file = new File(fileName);
	 * 
	 * // true 지정시 파일의 기존 내용에 이어서 작성 FileWriter fw = new FileWriter(file, true);
	 * 
	 * fw.write(this.SSN);
	 * 
	 * // Factory를 호출하여 tax메니저를 생성하고 직원 관련 세금을 attribute에 저장한다. Manager controller =
	 * forTax(); controller.setTax(this); fw.write("" + this.total_Tax);
	 * 
	 * fw.write("" + this.total_payroll); fw.write(this.getAccount().getNumber());
	 * fw.write("" + this.getAccount().getBalance()); fw.flush();
	 * 
	 * // 객체 닫기 fw.close();
	 * 
	 * } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * }
	 */
}
