
//COMMISSION EMPLOYEE에게 제공할 목적
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public  class Sales {

	static int ssn=0;

	//입력으로 COMMISION EMPLOYEE를 받고, 해당 직원의 SSN을 받아, DB에서 탐색 한 후, 해당 SALES를 RETURN한다. 
	public static void set_SSN(Commission_Employee emp ) {
		ssn=emp.getSSN();
	}
	
	
	public static double getEmployee_Salary(Commission_Employee emp){
		set_SSN(emp);
		return employee_total_sales(ssn);
	}
	
	
	// SALES DB에서 SSN에 맞는 직원의 SALES를 읽고 RETURN한다.
	//SSN
	//해당 직원의 판매량  형식으로 저장되어 있다.
	public static double employee_total_sales(int ssn) {
		// String path = Sales.class.getResource("").getPath();

		try {
			File file = new File("src"+File.separator+"SalesDB.txt");
		
			FileReader filereader = new FileReader(file);

			BufferedReader br = new BufferedReader(filereader);

			String line = "";

			while ((line = br.readLine()) != null) {
				
				double result = Double.parseDouble(line);

				if (result == ssn) {
					line = br.readLine();
					br.close();
					double resul = Double.parseDouble(line);
					return resul;
				}
			}

			br.close();

		} catch (FileNotFoundException e) {

		} catch (IOException e) {
			System.out.println(e);
		}
		return 0;
	}

}
