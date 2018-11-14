
//TAXDOCUMNET�� ���ο� ������ �����Ѵ�. 

import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Tax {

	int ver = 0;// Document�� ����.
	int tax_id;// ������ ����
	double tax_rate;// id�� ������ ����
	

	public void updateTaxDoc() {
		int whether=0;
		boolean flag = true;

		int sel = 0;
		System.out.println("\n\n");
		System.out.println("���� " + ver + " ���� TAX_DOCUMENT�Դϴ�.");
		System.out.println("������ �����Ͻ÷��� 1��. ���� ������ ������ 2���� �������� ");
		Scanner input = new Scanner(System.in);
		sel = input.nextInt();

		if (sel == 1) {
			++ver;
			System.out.println("���� ���� ������ "+ver+" version ������ ������ �߰� �˴ϴ�.");
			File file = new File("src"+File.separator+"Tax_Document.txt");
			FileWriter writer = null;
			BufferedWriter bwriter = null;
			
			
			
			while (flag) {

				System.out.println("Tax_ID�Է��ϼ���");
				tax_id = input.nextInt();
				System.out.println("�ش� ������ �Է��ϼ���");
				tax_rate = input.nextDouble();
				
				// String s = "" + tax_rate;

				try {

					writer = new FileWriter(file, true);
					bwriter = new BufferedWriter(writer);
					bwriter.write("" + tax_id + "\n");
					bwriter.flush();
					bwriter.write("" + tax_rate + "\n");
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
				System.out.println("�׸� �ۼ��Ϸ��� 9999��������");
				whether = input.nextInt();
				if (whether == 9999) {
					flag = false;
				}
			} // Update

		} else {
			System.out.println("������ �˽ô�!");
			return;
		}
		input.close();
		System.out.println("������ �˽ô�!");
		return;
	}

	//
}
