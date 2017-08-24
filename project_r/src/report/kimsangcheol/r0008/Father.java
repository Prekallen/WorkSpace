package report.kimsangcheol.r0008;

import java.util.Scanner;

public class Father {
	int[] score= new int[10];
	int[] stud = new int[10];
	Scanner scan;
	String str1, str2;
	int initNum, maxNum, temp;
	Father(){
		scan = new Scanner(System.in);
		System.out.println("기본 아빠 생성자 호출!!!");
		inputFromScanner1();
		inputFromScanner2();
		castToInt();
		System.out.println("학생의 인원수를 입력해주세요.");
		int studCnt = Integer.parseInt(scan.nextLine());
		stud = new int[studCnt];
		score = new int[studCnt];
		System.out.println(studCnt + "명 학생의 점수를 입력해주세요.");
		scoreArr();
	}
	void castToInt(){
		initNum = Integer.parseInt(str1);
		maxNum = Integer.parseInt(str2);
	}

	void inputFromScanner1(){
		str1=scan.nextLine();
	}
	void inputFromScanner2(){
		str2=scan.nextLine();
	}
	void printInput(){
		if (initNum>maxNum){
			temp=initNum;
			initNum=maxNum;
			maxNum=temp;
		}else{
		}
		for(int i=initNum;i<=maxNum;i++){
			System.out.println(i);
		}
	}
	void scoreArr(){
		for(int i=0;i<score.length;i++){
			System.out.println((i+1) + "번째 학생의 점수를 입력해 주세요.>");
			score[i]=Integer.parseInt(scan.nextLine());
			stud[i]=i+1;
		}
		for(int i=0;i<score.length;i++){
			for(int j=i+1;j<score.length;j++){
				if(score[i]<score[j]){
					temp=score[i];
					score[i]=score[j];
					score[j]=temp;
					temp=stud[j];
					stud[j]=stud[i];
					stud[i]=temp;
				}
			}
		}
	}
	void printScore(){
		for(int i=0;i<score.length;i++){
			System.out.println(stud[i] + "번째 학생의 점수는 : " + score[i]);
		}
	}
}