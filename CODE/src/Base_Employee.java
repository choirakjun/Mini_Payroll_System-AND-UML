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

		// �ش� ������ SSN���� ���ؼ� ������ TOTAL_TAX�� �����س��´�.
		Tax_Controller controller_ = forTaxController();
		controller_.save_total_tax_DB(this);

		// �̹� ���ִ� ���� �� ������ ���ִ� DB�� �о ���Ͽ� ���ִ� ���� ������ �Է��Ѵ�.
		Manager controller = forTax();
		controller.setTax(this);
		// System.out.println("base����"+this.total_Tax);
	}

	// ���� ����� �ϰ�, ������ ����ؼ� TOTAL_TAX�� �����ϰ� �� ������ ���� ����ؼ� ���� ������ UPDATE

	// �� ������ ����Ѵ�.
	public double total_payroll() {
		return this.base_salary;
	}

	/*
	 * //FACTORY�κ��� MANAGER(PURED FABRICATION�� ȣ��). �׸��� MANAGER�� �̿��� ���� ������ �Է��Ѵ�.
	 * public Manager forTax() {
	 * 
	 * Controller_Factory factory = new Controller_Factory(); Manager controller =
	 * factory.create_Manager(); return controller; } //FACTORY�κ��� TAX_CONTROLLER��
	 * RETURN�޾� ������ ������ ����� TOTAL_TAXDB�� �����Ѵ� public Tax_Controller
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
	 * "C:\\Users\\good\\Desktop\\��Ŭ����\\OOAD\\src\\HumanResourcesDB.txt"; try {
	 * 
	 * // ���� ��ü ���� File file = new File(fileName);
	 * 
	 * // true ������ ������ ���� ���뿡 �̾ �ۼ� FileWriter fw = new FileWriter(file, true);
	 * 
	 * fw.write(this.SSN);
	 * 
	 * // Factory�� ȣ���Ͽ� tax�޴����� �����ϰ� ���� ���� ������ attribute�� �����Ѵ�. Manager controller =
	 * forTax(); controller.setTax(this); fw.write("" + this.total_Tax);
	 * 
	 * fw.write("" + this.total_payroll); fw.write(this.getAccount().getNumber());
	 * fw.write("" + this.getAccount().getBalance()); fw.flush();
	 * 
	 * // ��ü �ݱ� fw.close();
	 * 
	 * } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * }
	 */
}
