public class Commission_Salary_Strategy implements Salary_Strategy {
//Commission salary의 월급 계산을 위한 전략 패턴 .SALES의 객체사용한다. 
	public double compute_total_payroll(Employee emp) {
		
		if (emp instanceof Commission_Employee) {

			Commission_Employee tmp = (Commission_Employee) emp;



			tmp.commission_salary = Sales.getEmployee_Salary(tmp);

			tmp.total_payroll=tmp.base_salary + (tmp.commission_rate * tmp.commission_salary);

			emp.total_payroll=tmp.total_payroll;
			return tmp.base_salary + (tmp.commission_rate * tmp.commission_salary);
		}

		else {

			return 0;
		}
	}
	/*
	 * public double getTotalPayroll(Commission_Employee emp) {
	 * 
	 * 
	 * 
	 * emp.commission_salary=Sales.getEmployee_Salary(emp);
	 * 
	 * tmp= emp.base_salary+(emp.commission_rate*emp.commission_salary);
	 * 
	 * return emp.base_salary+(emp.commission_rate*emp.commission_salary); }
	 * 
	 * public double getTotalPayroll(Hourly_Employee emp) { return 0; }
	 * 
	 * 
	 * 
	 */
}
