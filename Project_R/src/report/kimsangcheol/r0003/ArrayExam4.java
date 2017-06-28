package report.kimsangcheol.r0003;

public class ArrayExam4 {

	public static void main(String[] args){
		int[]a = new int[10];
			
		for(int i=1;i<=10;i++){
			a[i-1] = i*2;
		}
		
		for(int i=0;i<10;i++){
			System.out.print(a[i]+",");
		}
		
		System.out.println();
		
		for(int i=1;i<=10;i++){
			a[10-i]=i*2;
			
		}
		for(int i=0;i<10;i++){
			System.out.print(a[i]+",");
		}
		
	}
}
