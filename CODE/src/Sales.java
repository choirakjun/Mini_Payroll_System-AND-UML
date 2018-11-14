
//COMMISSION EMPLOYEE���� ������ ����
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public  class Sales {

	static int ssn=0;

	//�Է����� COMMISION EMPLOYEE�� �ް�, �ش� ������ SSN�� �޾�, DB���� Ž�� �� ��, �ش� SALES�� RETURN�Ѵ�. 
	public static void set_SSN(Commission_Employee emp ) {
		ssn=emp.getSSN();
	}
	
	
	public static double getEmployee_Salary(Commission_Employee emp){
		set_SSN(emp);
		return employee_total_sales(ssn);
	}
	
	
	// SALES DB���� SSN�� �´� ������ SALES�� �а� RETURN�Ѵ�.
	//SSN
	//�ش� ������ �Ǹŷ�  �������� ����Ǿ� �ִ�.
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
