package report.kimsangcheol.PE;

import java.util.Scanner;

public class Switch {

	public static void main(String[] args) {
		String text;
		int state=0;
		Scanner input = new Scanner(System.in);
		do{
			System.out.println("명령어를 입력하시오: ");
			text = input.nextLine();

			switch (text) {
			case "시작":
				System.out.println("동작 시작!");
				state=0;
				break;

			case "종료":
				System.out.println("동작 종료.");
				state =1;
				break;

			default:

				System.out.println("정의 되지 않는 명령어입니다.");
				state =0;
			}
		}while(state!=1);


	}
}
