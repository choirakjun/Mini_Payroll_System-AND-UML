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
	// 이미 써있는 직원 별 세금이 써있는 DB를 읽어서 파일에 써있는 세금 정보를 입력한다
	public Manager forTax() {

			Controller_Factory factory = new Controller_Factory();
			Manager controller = factory.create_Manager();
			return controller;
		}
		// 해당 직원의 SSN보고 비교해서 세액을 TOTAL_TAX에 저장해놓는다.
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

	
	//직원 정보 생성 후,HUMANRESOURCESDB에 저장하는 메서드.
	//public abstract void savehumanresources();
	
	//세금정보를 읽어서 세금을 저장한다. 
	public void set_tax() {
		Manager man= new Manager();
		man.setTax(this);
	}

	public abstract double total_payroll();

	public String toString() {
		return "SSN: " + this.getSSN() + " TOTAL_PAYTOLL: " + this.getTotal_payroll() + " TOTAL_TAX: " + this.getTotal_Tax()+" ACCOUNT NUM: "+this.getAccount().getNumber()+" ACOUNT BALANCE "+this.getAccount().getBalance();
	}
}
