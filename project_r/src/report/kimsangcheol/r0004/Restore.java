package report.kimsangcheol.r0004;

import java.util.Scanner;

public class Restore {

	public void downArr(int[]a){
		int tmp=0;
		for(int i=0; i<a.length;i++){
			for (int j = i+1 ; j <a.length; j++){			//내림차순 정렬 시작													
				if(a[i] < a[j]){
					tmp =a [i];
					a[i] = a [j];
					a [j] = tmp;
				}
			}
		}
	}
	public void upArr(int[]a){
		int tmp=0;
		for(int i=0; i<a.length;i++){
			for (int j = i+1 ; j <a.length; j++){			//오름차순 정렬 시작													
				if(a[i] > a[j]){
					tmp =a [i];
					a[i] = a [j];
					a [j] = tmp;
				}
			}
		}
	}
	public void arrayPrint(int []a){
		for(int f=0;f<a.length;f++){
			System.out.println((f+1) + "의 점수 : " + a[f]);

		}
	}

	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		Restore rS = new Restore();
		int[]a = new int[5];
		int sum=0;	
		for(int i=0; i<a.length;i++){
			System.out.println((i+1)+"번째 점수를 입력하시오.>");
			String num = scr.nextLine();
			a[i] = Integer.parseInt(num);
			sum += a[i];								//합계
		}
		rS.downArr(a);
		rS.arrayPrint(a);
		rS.upArr(a);
		rS.arrayPrint(a);
		System.out.println("모든 점수의 합 : " + sum);
	}

}
