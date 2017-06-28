package report.kimsangcheol.r0006;

import java.util.ArrayList;															//ArrayList클래스를 사용하기 위해 가져옴.
import java.util.Scanner;															//Scanner클래스를 사용하기 위해 가져옴.

public class CalExam {
	int getNum(int a){																
		
		for(int i=0; i<10;i++){
			if(i==a)																//조건에 맞으면 실행
			
			return i+1;																//i의 값을 리턴
		}
		return -1;																	//i의 값이 잘못 들어 왔을때 default
	}

	public static void main(String[] args){
		CalExam cE = new CalExam();
		int []a = new int[10];
		int num;
		int sum =0;
		int temp;
		int []b= new int[10];
		Scanner scan = new Scanner(System.in);										
		for(int i=0; i<a.length;i++){												//배열 변수의 길이 만큼 반복
			System.out.println((i+1)+"번째 학생의 점수를 입력하시오.>");				
			a[i]=Integer.parseInt(scan.nextLine());									//입력받은 값을 반복문이 돌때마다 배열변수에 대입
			b[i]=(i+1);																		
			sum += a[i];															//입력받은 값을 자기자신과 더해 총합을 구함
		}
		
		System.out.println("학생들의 총점 = "+sum);									//출력
		System.out.println("학생들의 평균 = "+sum/a.length);
		
	
		for(int i=0;i<a.length;i++){												//점수에 따른 내림차순
			for(int j=i+1; j<a.length;j++){
				if(a[i]<a[j]){
					temp=a[j];
					a[j]=a[i];
					a[i]=temp;
					temp=b[j];
					b[j]=b[i];
					b[i]=temp;
					
				}
			}
		}
		for(int i=0;i<a.length;i++){
			System.out.println(b[i] + "번째 학생의 점수 : "+a[i]);
		}
		ArrayList<Integer> list = new ArrayList<Integer>();							//ArrayList를 Integer타입으로 변수명 list에 초기화
		for(int i=0;i<a.length;i++){												
			list.add(a[i]);															//배열변수 a[]의 모든 값들을 list에 대입
		}
		

		for(int i=0;i<list.size();i++){												//list변수의 길이만큼 반복
			System.out.println(list.get(i));										//list에 들어있는 값들을 순차적으로 출력
		}
		
		System.out.println("점수를 보고싶은 학생의 번호를 입력하세요.>");
		num=Integer.parseInt(scan.nextLine());
		cE.getNum(num);																//입력한 번째 학생을 부르는 함수
		System.out.println(b[num]+"번 학생의 점수 : "+a[num]);
	}
}
