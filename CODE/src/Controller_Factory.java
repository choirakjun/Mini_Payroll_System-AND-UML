//Controller를 return하는 Factory Pattern. MAIN에서 STRING입력받아서 호출한다. 


public class Controller_Factory {
	/*	
	public synchronized static Hourly_Salary_Strategy create_Houlry_PayrollController() {
		Hourly_Salary_Strategy controller=new Hourly_Salary_Strategy();
		return controller;
	}
	public synchronized static Commission_Salary_Strategy create_Commission_PayrollController() {
		Commission_Salary_Strategy controller=new Commission_Salary_Strategy();
		return controller;
	}
	
	public synchronized static Tax_Controller create_Tax_Controller() {
		Tax_Controller controller=new Tax_Controller();
		return controller;
	}
	public synchronized static Manager  create_Manager() {
		Manager Manager=new Manager();
		return Manager;
	}
*/
	
	public Hourly_Salary_Strategy create_Houlry_PayrollController() {
		Hourly_Salary_Strategy controller=new Hourly_Salary_Strategy();
		return controller;
	}
	public Commission_Salary_Strategy create_Commission_PayrollController() {
		Commission_Salary_Strategy controller=new Commission_Salary_Strategy();
		return controller;
	}
	
	public Tax_Controller create_Tax_Controller() {
		Tax_Controller controller=new Tax_Controller();
		return controller;
	}
	public Manager  create_Manager() {
		Manager Manager=new Manager();
		return Manager;
	}


}
