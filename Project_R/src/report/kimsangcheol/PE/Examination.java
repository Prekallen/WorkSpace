package report.kimsangcheol.PE;

import java.util.Scanner;

public class Examination {
	
		int [] score = new int[5];
		Scanner scan = new Scanner(System.in);
		int temp=0;
		int sum=0;
		void sortPrint(){
			for(int i=0 ; i<score.length;i++){
				for(int j=i+1;j<score.length;j++){
					if(score[i]>score[j]){
						temp=score[i];
						score[i]=score[j];
						score[j]=temp;
					}
				}
			}
			for(int i=0 ; i<score.length;i++){
				sum += score[i];
				System.out.println(score[i]);
				
			}
		}
		
		public static void main(String[]args){
			Examination ex= new Examination();
			for(int i=0;i<ex.score.length;i++){
				
				System.out.println((i+1) + "번째 학생의 점수를 입력하세요.>");
				ex.score[i]=Integer.parseInt(ex.scan.nextLine());
			
			}
			ex.sortPrint();
			System.out.println("총점 : " + ex.sum);
			System.out.println("평균 : " + (ex.sum/ex.score.length));
		}
}
