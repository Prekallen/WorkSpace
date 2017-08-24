package report.kimsangcheol.r0003;

public class ArrayExam5 {


	public static void main(String[] args){
		int[]a= new int[6];

		/*		for(int i=0;i<10;i++){
			a[i]=10-i;
			System.out.print(a[i]);
		}
		System.out.println();*/
		for(int i=0;i<6;i++){

			int rand = (int)(Math.random()*45)+1;
			a[i]=rand;
			for(int j=i;j>=0;j--){
				if(a[j]==a[i]&&i!=j){
					j=0;
					j--;
				}
			}
			//			for(int j=0;j<i;j++){
			//				if(a[j]==a[i]){
			//					
			//					j--;
			//				}
			//			}
		}
		for(int i=0;i<6;i++){
			System.out.println(a[i]);
		}
	}
}

