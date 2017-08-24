package report.kimsangcheol.r0005;

import java.util.Scanner;

public class Cal {
	Cal(){
	
	}
	int num;
	int num2;
	int a;
	String cl;
	int result;
	Cal(int a){
		System.out.println(a+" 인트 변수 파라메터를 한개를 가진 생성자를 호출!");
		this.a = a;
	}
	Cal(String b){
		System.out.println(b+" 스트링~~");
		this.cl=b;
	}
	Cal( int num,  int num2 , String a){						//생성자님
		this.num=num;
		this.num2=num2;
		this.cl=a;
		}
	void printCal(){
		if(cl==null){
			System.out.println("연산자 확인 필요");
		}else if(cl.equals("+")){
			System.out.println(num+num2); 
		}else if(cl.equals("-")){
			System.out.println(num-num2);
		}else if(cl.equals("*")){
			System.out.println(num*num2);
		}else if(cl.equals("/")){
			System.out.println(num/num2);
		}else{
			System.out.println("연산자 확인 필요");
		}
	}
	void printPlus(){
		System.out.println(result);
	}

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		Cal c = new Cal(2,3,"+");
		c.printCal();
	}
}
