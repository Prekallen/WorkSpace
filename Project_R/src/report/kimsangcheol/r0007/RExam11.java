package report.kimsangcheol.r0007;

import java.util.Scanner;

public class RExam11 {
	protected int a;
	protected int b;
	protected int result;
	Scanner scan = new Scanner(System.in);
	public RExam11(int a, int b){
		this.a = a;
		this.b = b;
	}
	protected void calcPlus(){
		result = a+b;
	}
	protected void calcMinus(){
		result = a-b;
	}
	protected void calcMultiple(){
		result = a*b;
	}
	protected void calcDivision(){
		result = a/b;
	}
	protected void printCal(){
	System.out.println(result);	
	}
}
