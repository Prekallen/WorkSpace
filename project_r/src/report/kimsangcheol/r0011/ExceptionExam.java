package report.kimsangcheol.r0011;

import java.util.Scanner;

public class ExceptionExam {
	
	public static void main(String[]args){
		try{								//try, catch문에 Exception문을 사용해서 예외인 결과문은 에러가 아니라 필터링한다.
			Scanner scan = new Scanner(System.in);
			System.out.println("값좀....");
			String str = scan.nextLine();
			int a= Integer.parseInt(str);
			System.out.println("숫자를 넣었네 : " + a);
		}catch(NumberFormatException e){
			System.out.println("숫자를 입력 해주세요.");
		}
	}
}