package report.kimsangcheol.r0006;

import java.util.Scanner;

public class CalExam2 {
int getNum(int []a,int b){																
		
		for(int i=0; i<10;i++){
			if(a[i]==b)																
			
			return i+1;																
		}
		return -1;																	
	}

	public static void main(String[] args){
		CalExam2 cE2 = new CalExam2();
		int []a = new int[10];
		int num;
		int sum =0;
		int temp;
		int []b= new int[10];
		Scanner scan = new Scanner(System.in);										
		for(int i=0; i<a.length;i++){												
			System.out.println((i+1)+"번째 학생의 점수를 입력하시오.>");				
			num=Integer.parseInt(scan.nextLine());
			a[i]=num;									
			b[i]=num;																	
			sum += a[i];															
		}
		
		System.out.println("학생들의 총점 = "+sum);									
		System.out.println("학생들의 평균 = "+sum/a.length);
		
	
		for(int i=0;i<a.length;i++){												
			for(int j=i+1; j<a.length;j++){
				if(a[i]<a[j]){
					temp=a[j];
					a[j]=a[i];
					a[i]=temp;
					
				}
			}
		}
		System.out.println("몇 점 학생 면담인가요?[10단위].>");
		num=Integer.parseInt(scan.nextLine());
																		
		System.out.println("면담확정자는 "+cE2.getNum(b,num)+"번째 학생.");
	}
}


