import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 10명 중에 앞에
		// 0~4는 COMMISSION
		// 5~7는 HOURLY
		// 8~9는 BASE

		/*
		 * TAX_CONTROLLER에서 직원의 월급을 계산 후 해당 월급과 세액을 비교해서 TOTAL_TAX에 저장한다. 그리고 TAX를
		 * SET한다.
		 */
		// 객체 생성하면서 세금계산, 월급계산을 한다.

		Employee employee[] = new Employee[10];

		employee[0] = new Commission_Employee(0, 0.0, 0.0, 100, 0, "Commission-0", 0.1, 0.0, 1000000.0);
		employee[1] = new Commission_Employee(1, 0, 0, 200, 0, "Commission-1", 0.1, 0, 1000000);
		employee[2] = new Commission_Employee(2, 0, 0, 300, 0, "Commission-2", 0.1, 0, 1000000);
		employee[3] = new Commission_Employee(3, 0, 0, 400, 0, "Commission-3", 0.1, 0, 1000000);
		employee[4] = new Commission_Employee(4, 0, 0, 500, 0, "Commission-4", 0.1, 0, 1000000);

		employee[5] = new Hourly_Employee(5, 0, 0, 600, 0, "HOURLY-1", 20, 20000);
		employee[6] = new Hourly_Employee(6, 0, 0, 700, 0, "HOURLY-2", 30, 30000);
		employee[7] = new Hourly_Employee(7, 0, 0, 800, 0, "HOURLY-3", 40, 40000);

		employee[8] = new Base_Employee(8, 0, 5000000, 900, 0, "BASE-1", 5000000);
		employee[9] = new Base_Employee(9, 0, 6000000, 1000, 0, "BASE-2", 6000000);
		
		for(int i=0;i<employee.length;i++) {
			System.out.println(employee[i]);
		}
		
		System.out.println("\n\n");
		System.out.println("계좌 입금 후");
		
		//직원 별 세금 ATTRIBUTE에 입금
		Controller_Factory Factory_For_Manager = new Controller_Factory();
		Manager TaxUpdate = Factory_For_Manager.create_Manager();
		
		for(int i=0;i<employee.length;i++) {
		TaxUpdate.saveAccount(employee[i]);
		System.out.println(employee[i]);
		}
		
	
		//세율 TAX_DOCUMENT UPDATE
		TaxUpdate.changeTaxDB();
		
		
		
		
		

	}

}