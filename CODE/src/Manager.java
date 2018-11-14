import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Manager {
	//세금정보 읽어서 EMPLOYEE의 TAX ATTRIBUTE설정
	public void setTax(Employee emp) {

		try {
			File file = new File("src" + File.separator + "total_tax_DB.txt");
			//File file = new File("total_tax_DB.txt");

			FileReader filereader = new FileReader(file);

			BufferedReader br = new BufferedReader(filereader);

			String line = "";
			
			//System.out.println("Total_Tax_DB출력물");
			
			while ((line = br.readLine()) != null) {
				//double result = Double.parseDouble(line);
				//System.out.println(line);
				int ssn = Integer.parseInt(line);
				if (ssn == emp.getSSN()) {
			//		System.out.println("SSN같다");
					line = br.readLine();
			//		System.out.println("같을 떄의 세금");
			//		System.out.println(line);
					double resul = Double.parseDouble(line);
			//		System.out.println(resul);
					emp.setTotal_Tax(resul);
					br.close();
					return;
				}
				line=br.readLine();
			}

			br.close();

		} catch (FileNotFoundException e) {

		} catch (IOException e) {
			System.out.println(e);
		}

	}
	
	
	
	//최종 월급 가져오고, 해당 금액에서 TAX DB에서 저장된 값만큼의 차액을 ACCOUNT에 보내준다. 
	public void saveAccount(Employee emp) {
		
		double for_account = emp.getTotal_payroll()-emp.getTotal_Tax();
		emp.getAccount().setBalance(for_account);
	}
	
	//TAXDB를 갱신한다.
	public void changeTaxDB() {
		Tax tax = new Tax();
		tax.updateTaxDoc();
	}
	
}
