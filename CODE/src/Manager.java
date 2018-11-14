import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Manager {
	//�������� �о EMPLOYEE�� TAX ATTRIBUTE����
	public void setTax(Employee emp) {

		try {
			File file = new File("src" + File.separator + "total_tax_DB.txt");
			//File file = new File("total_tax_DB.txt");

			FileReader filereader = new FileReader(file);

			BufferedReader br = new BufferedReader(filereader);

			String line = "";
			
			//System.out.println("Total_Tax_DB��¹�");
			
			while ((line = br.readLine()) != null) {
				//double result = Double.parseDouble(line);
				//System.out.println(line);
				int ssn = Integer.parseInt(line);
				if (ssn == emp.getSSN()) {
			//		System.out.println("SSN����");
					line = br.readLine();
			//		System.out.println("���� ���� ����");
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
	
	
	
	//���� ���� ��������, �ش� �ݾ׿��� TAX DB���� ����� ����ŭ�� ������ ACCOUNT�� �����ش�. 
	public void saveAccount(Employee emp) {
		
		double for_account = emp.getTotal_payroll()-emp.getTotal_Tax();
		emp.getAccount().setBalance(for_account);
	}
	
	//TAXDB�� �����Ѵ�.
	public void changeTaxDB() {
		Tax tax = new Tax();
		tax.updateTaxDoc();
	}
	
}
