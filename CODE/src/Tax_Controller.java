
//������ SSN�� ������ �δ��ؾ� �� ���� ������ TOTAL_TAX_DB�� �����Ѵ�.
import java.lang.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Tax_Controller {

	// TaxDocument�� ��������,������ �δ��ؾ� �� ������ �� ���� RETURN�Ѵ�.
	public static double getAlltaxrate() {
		// String path = Sales.class.getResource("").getPath();

		double sum_taxRate = 0;
		try {
			File file = new File("src" + File.separator + "Tax_Document.txt");
		

			FileReader filereader = new FileReader(file);

			BufferedReader br = new BufferedReader(filereader);

			String line = "";

			while ((line = br.readLine()) != null) {
				line = br.readLine();
				double result = Double.parseDouble(line);
				sum_taxRate += result;

				/*
				 * double result = double.parsedouble(line);
				 * 
				 * if (result == ssn) { line = br.readLine(); br.close(); double resul =
				 * double.parsedouble(line); return resul; }
				 */
			}

			br.close();

		} catch (FileNotFoundException e) {

		} catch (IOException e) {
			System.out.println(e);
		}
		return sum_taxRate;
	}

	// ���� ������ �������� ������ ���������� �δ��ؾ� �ϴ� ������ RETURN�Ѵ�.
	public double compute_TAX(Employee emp) {

		return (emp.getTotal_payroll() * getAlltaxrate());
	}

	// ������ SSN�� ������ �δ��ؾ� �� ���� ������ TOTAL_TAX_DB�� �����Ѵ�.
	public void save_total_tax_DB(Employee emp) {

		// System.out.println("���� SSN �� �ش� ���� �߻� ������ TOTAL_TAX_DB�� �����Ѵ�.");

		String path = Tax_Controller.class.getResource("").getPath();
		// System.out.println(path);
		// compute_TAX(emp);

		File file = new File("src" + File.separator + "total_tax_DB.txt");
		FileWriter writer = null;
		BufferedWriter bwriter = null;

		try {

			writer = new FileWriter(file, true);
			bwriter = new BufferedWriter(writer);
			bwriter.write("" + emp.getSSN() + "\n");
			// System.out.println(emp.getSSN());

			bwriter.flush();
			bwriter.write("" + compute_TAX(emp) + "\n");// Emp�� ���������Ѵ�.
			// System.out.println(compute_TAX(emp));
			bwriter.flush();

			bwriter.close();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bwriter != null)
					bwriter.close();
				if (writer != null)
					writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	} // Update

}
