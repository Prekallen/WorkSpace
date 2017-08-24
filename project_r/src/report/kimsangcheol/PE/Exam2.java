package report.kimsangcheol.PE;

import java.util.Scanner;

public class Exam2 {

	public static void main(String[] args){

		Scanner scan = new Scanner(System.in);

		int value = 0;

		do {													//while 문의 조건식과 블럭{}의 순서를 바꾸어 놓음
			System.out.println("Enter a number: ");				//while 문은 조건이 안 맞으면 실행이 안되지만 do-while은 적어도 한번은 무조건 실행
			value = scan.nextInt();
		}
		while(value != 5);

		System.out.println("Got 5!");
	}
}
