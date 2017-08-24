package report.kimsangcheol.r0002;

import java.util.Scanner;

public class Test {

	public void printMultipleTable(int initNum, int maxNum){
		int a, b;

		for(a=initNum;a<=maxNum;a++){
			for(b=initNum;b<maxNum;b++){

				System.out.print(a + " X " + b + " = " + (a*b) + ",");

			}
			System.out.println(a + " X " + b + " = " + (a*b));

		}

	}
	public static void main(String[] args){
		//		int a = 1;
		//		int b = 1;
		int c=0;
		int d=0;
		int tmp=0;
		Scanner num = new Scanner(System.in);			//시작 값과 종료 값을 받아서 배열을 실행
		System.out.println("시작 값을 입력하세요.>");
		c= Integer.parseInt(num.nextLine());
		System.out.println("종료 값을 입력하세요.>");
		d= Integer.parseInt(num.nextLine());
		if(c>d){					//시작값이 종료 값보다 클때 두 변수의 값을 대치
			tmp=c;
			c=d;
			d=tmp;

		}else{
			
		}
		Test z = new Test();
		z.printMultipleTable(c, d);

		/*		
		for(a=1;a<=9;a++){
			for(b=1;b<9;b++){

					System.out.print(a + " X " + b + " = " + (a*b) + ",");

			}
			System.out.println(a + " X " + b + " = " + (a*b));
		}
		 */		

	}
}
