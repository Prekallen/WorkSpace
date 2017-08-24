package report.kimsangcheol.r0012;

import java.util.Scanner;

public class FunctionExam {
	int[]arrNum = new int[5];
	int a=1;
	Scanner scan = new Scanner(System.in);

	int getNumberFromString(){
		try{
			
			System.out.println(a + "��° ���� �־� �ּ���.");
			a++;
			return Integer.parseInt(scan.nextLine());
			
		}catch(Exception e){
			System.out.println("���� ���� ������...");
			a--;
			return getNumberFromString();
		}
	}

	public static void main(String[]args){
		FunctionExam ee2 = new FunctionExam();
		for(int i = 0;i<ee2.arrNum.length;i++){
			ee2.arrNum[i]= ee2.getNumberFromString();
		}

		for(int i = 0 ; i<ee2.arrNum.length;i++){
			System.out.println((i+1)+ "��° �ּ��� ���� : " + ee2.arrNum[i]);
		}
	}
}
