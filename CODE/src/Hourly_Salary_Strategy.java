
public class Hourly_Salary_Strategy implements Salary_Strategy {

	public double compute_total_payroll(Employee emp) {
		if (emp instanceof Hourly_Employee) {
			Hourly_Employee tmp = (Hourly_Employee) emp;
			tmp.total_payroll = tmp.hourly_wage * tmp.worked_hour;
			emp.total_payroll=tmp.total_payroll;
			return tmp.total_payroll;
		} else {
			return 0;
		}

	}

	/*
	 * public double getTotalPayroll(Commission_Employee emp) {
	 * 
	 * return 0; } ?/
	 * 
	 * 
	 * 
	 * /* public double getTotalPayroll(Hourly_Employee emp) { tmp=emp.hourly_wage *
	 * emp.worked_hour; return emp.hourly_wage * emp.worked_hour; }
	 * 
	 * public double getTotalPayroll(Commission_Employee emp) {
	 * 
	 * return 0; }
	 * 
	 * public double compute_total_payroll() {
	 * 
	 * get
	 * 
	 * return tmp; }
	 * 
	 */
}
