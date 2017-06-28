package report.kimsangcheol.r0011;

import java.util.Scanner;

public class ExceptionExam2 {
	final int []ARRNUM = new int[10];
	Scanner scan;
	ExceptionExam2(){
		scan = new Scanner(System.in);

		for(int i=0; i<ARRNUM.length;i++){
			try{
				System.out.println("값을 입력해 주세요.>");
				ARRNUM[i]= Integer.parseInt(scan.nextLine());

			}catch(Exception e){
				System.out.println("숫자 말고 다른 값이 들어왔군요!!!!!!!");
				i--;
			}
		}
	}

	void printArr(){
		for(int i=0;i<ARRNUM.length;i++){
			System.out.println(i + "번째 주소의 값 : " + ARRNUM[i]);
		}
	}

	public static void main(String[] args){
		ExceptionExam2 ee2 = new ExceptionExam2();
		ee2.printArr();
	}
}