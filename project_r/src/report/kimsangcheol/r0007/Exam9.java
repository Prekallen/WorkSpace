package report.kimsangcheol.r0007;

import java.util.Scanner;

public class Exam9 {
	private int a;
	private int b;
	private int result;
	Scanner scan = new Scanner(System.in);
	
	void getA(){
		System.out.println("초기값을 입력해주세요.>");
		a=Integer.parseInt(scan.nextLine());
	}
	void getB(){
		System.out.println("종료값을 입력해주세요.>");
		b=Integer.parseInt(scan.nextLine());
		
	}
	
	public int doLoop(){
		for(int i= a; i<=b; i++){
			result += i;
		}return result;
	}
}
