package report.kimsangcheol.r0002;

import java.util.Scanner;

public class ArrayExam3 {

	public int[] getArrayVar(int initNum, int maxNum){
		int[] a = new int[maxNum-initNum+1];
		for(int i=initNum-initNum;i<=maxNum-initNum;i++){
			a[i] = i+initNum;
		}
		return a;
	}
	
	public void printArrayVar(int[]a){
		for(int i=a.length-1;i>=0;i--){
			System.out.println(a[i]);	
		}
	}

	public static void main(String[] args){
		ArrayExam3 ae3 = new ArrayExam3();
		Scanner num = new Scanner(System.in);	
		System.out.println("시작 값을 입력하세요.>");
		int b= Integer.parseInt(num.nextLine());
		System.out.println("종료 값을 입력하세요.>");
		int c= Integer.parseInt(num.nextLine());
		int tmp=0;
		if(b>c){					
			tmp=b;
			b=c;
			c=tmp;

		}else{
			
		}
		int[]a = ae3.getArrayVar(b,c);
		ae3.printArrayVar(a);

	}
}
