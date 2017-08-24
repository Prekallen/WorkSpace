package report.kimsangcheol.PE;

public class Exam {
	
	 public static void main(String[] args) {
         
	        int value = 0;
	     
	        while(value < 10)								//밸류변수가 10미만일때 까지만 동작
	        {
	            System.out.println("Hello " + value);
	             
	            value = value + 1;
	        }
			// Using loops with "break": 
			int loop = 0;
			
			while(true) {									//무조건 실행
				System.out.println("Looping: " + loop);
				
				if(loop == 3) {
					break;									//루프변수가 3이 되는 순간 반복문을 빠져나옴
				}
				
				loop++;
			
				System.out.println("Running");
			}
	    }

}
