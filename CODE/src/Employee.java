import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public abstract class Employee {

	int  SSN;
	double total_Tax;
	double total_payroll;
	private Account account;
	String working_title;
	
	public Employee(int SSN, double total_Tax, double total_payroll,int num, double balance, String working_title) {
	
		this.SSN=SSN;
		this.total_Tax=total_Tax;
		this.total_payroll=total_payroll;
		this.account=new Account(num, balance);
		this.working_title=working_title;
	
	
	}
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

	public int getSSN() {
		return SSN;
	}
	public double getTotal_payroll() {
		return total_payroll;
	}

	public void setTotal_payroll(double total_payroll) {
		this.total_payroll = total_payroll;
	}

	public String getWorking_title() {
		return working_title;
	}

	public void setWorking_title(String working_title) {
		this.working_title = working_title;
	}

	public void setSSN(int sSN) {
		SSN = sSN;
	}

	public void setTotal_Tax(double total_Tax) {
		this.total_Tax = total_Tax;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	public double getTotal_Tax() {
		return total_Tax;
	}
	public Account getAccount() {
		return account;
	}

	
	//���� ���� ���� ��,HUMANRESOURCESDB�� �����ϴ� �޼���.
	//public abstract void savehumanresources();
	
	//���������� �о ������ �����Ѵ�. 
	public void set_tax() {
		Manager man= new Manager();
		man.setTax(this);
	}

	public abstract double total_payroll();

	public String toString() {
		return "SSN: " + this.getSSN() + " TOTAL_PAYTOLL: " + this.getTotal_payroll() + " TOTAL_TAX: " + this.getTotal_Tax()+" ACCOUNT NUM: "+this.getAccount().getNumber()+" ACOUNT BALANCE "+this.getAccount().getBalance();
	}
}
