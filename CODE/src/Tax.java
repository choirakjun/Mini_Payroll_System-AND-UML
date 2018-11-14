
//TAXDOCUMNET에 새로운 세율을 저장한다. 

import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Tax {

	int ver = 0;// Document의 버전.
	int tax_id;// 세금의 종류
	double tax_rate;// id별 세금의 종류
	

	public void updateTaxDoc() {
		int whether=0;
		boolean flag = true;

		int sel = 0;
		System.out.println("\n\n");
		System.out.println("현재 " + ver + " 버젼 TAX_DOCUMENT입니다.");
		System.out.println("세율을 수정하시려면 1번. 수정 사항이 없으면 2번을 누르세요 ");
		Scanner input = new Scanner(System.in);
		sel = input.nextInt();

		if (sel == 1) {
			++ver;
			System.out.println("기존 세금 문서에 "+ver+" version 정보를 가지고 추가 됩니다.");
			File file = new File("src"+File.separator+"Tax_Document.txt");
			FileWriter writer = null;
			BufferedWriter bwriter = null;
			
			
			
			while (flag) {

				System.out.println("Tax_ID입력하세요");
				tax_id = input.nextInt();
				System.out.println("해당 세율을 입력하세요");
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
				System.out.println("그만 작성하려면 9999누르세요");
				whether = input.nextInt();
				if (whether == 9999) {
					flag = false;
				}
			} // Update

		} else {
			System.out.println("다음에 뵙시다!");
			return;
		}
		input.close();
		System.out.println("다음에 뵙시다!");
		return;
	}

	//
}
