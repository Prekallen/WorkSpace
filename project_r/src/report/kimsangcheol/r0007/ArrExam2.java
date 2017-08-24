package report.kimsangcheol.r0007;

import java.util.Scanner;

public class ArrExam2 {
	int[] arrCount(int initNum, int maxNum){
		int []a = new int[maxNum-initNum+1];
		Scanner index = new Scanner(System.in);
		for(int i=initNum; i<=maxNum;i++){
			System.out.println((i-initNum)+"번째 인덱스 값을 입력하시오.>");
			
			a[i-initNum]=Integer.parseInt(index.nextLine());
		}
		return a;
	}
	void printArr(int a[]){
		for(int i=0;i<a.length;i++){
		System.out.println(i + "번째 인덱스 값은 : " + a[i]);
	}
	}
	public static void main(String[]args){
		Scanner scan = new Scanner(System.in);
		ArrExam2 ae2 = new ArrExam2();
		System.out.println("초기값을 입력해 주세요.>");
		int initNum = Integer.parseInt(scan.nextLine());
		System.out.println("종료값을 입력해 주세요.>");
		int maxNum= Integer.parseInt(scan.nextLine());
		
		ae2.printArr(ae2.arrCount(initNum, maxNum));
	
	
	
	}
	
}
