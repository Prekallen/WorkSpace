package report.kimsangcheol.r0007;

import java.util.Scanner;

public class Exam11 {
	int a;
	int b;
	int result;
	Scanner scan = new Scanner(System.in);
	public Exam11(){
		System.out.println("연산할 수를 입력해주세요.>");
		a= Integer.parseInt(scan.nextLine());
		System.out.println("연산할 수를 입력해주세요.>");
		b= Integer.parseInt(scan.nextLine());
	}
	protected int calcPlus(){
		result = a+b;
		return result;
	}
	protected int calcMinus(){
		result = a-b;
		return result;
	}
	protected int calcMultiple(){
		result = a*b;
		return result;
	}
	protected int calcDivision(){
		result = a/b;
		return result;
	}
	protected void printResult(){
		
		this.calcPlus();
		System.out.println("더하기 연산 결과는 :" + result);
		this.calcMinus();
		System.out.println("빼기 연산 결과는 :" + result);
		this.calcMultiple();
		System.out.println("곱하기 연산 결과는 :" + result);
		this.calcDivision();
		System.out.println("나누기 연산 결과는 :" + result);
	}
}
