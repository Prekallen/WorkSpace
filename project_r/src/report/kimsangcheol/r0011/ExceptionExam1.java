package report.kimsangcheol.r0011;

import java.util.Scanner;

public class ExceptionExam1 {
	final int NUM=1;		//final 선언은 상수값 >> 풀네임 대문자 절대 변하지 않는 값(값을 처음 초기화 안하면 무조건 에러)
	int num1;
	int num2;
	int result;

	int calPlus(){
		result =num1+num2;
		return result;
	}
	
	int calMinus(){
		result =num1-num2;
		return result;
	}
	
	int calMultiple(){
		result =num1*num2;
		return result;
	
	}
	int calDivision(){
		result =num1/num2;
		return result;
	
	}
	public static void main(String[]args){
		ExceptionExam1 ee1 = new ExceptionExam1();
		Scanner scan = new Scanner(System.in);
		try{
			System.out.println("연산할 수를 입력하세요.>");
			ee1.num1 = Integer.parseInt(scan.nextLine());
			System.out.println("연산할 수를 입력하세요.>");
			ee1.num2 = Integer.parseInt(scan.nextLine());
			ee1.calPlus();
			System.out.println("더한 값은? : "+ee1.result);
			ee1.calMinus();
			System.out.println("뺀 값은? : "+ee1.result);
			ee1.calMultiple();
			System.out.println("곱한 값은? : "+ee1.result);
			ee1.calDivision();
			System.out.println("나눈 값은? : "+ee1.result);

		}catch(Exception e){
			System.out.println("정수를 입력해야겠죠??????!!");		//try,catch문의 결과와 상관없이 finally를 무조건 실행
		}finally{
			System.out.println("에러 나든 안나든 난 무조건~");
		}
	}
}
