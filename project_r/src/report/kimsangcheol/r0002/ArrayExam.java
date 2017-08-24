package report.kimsangcheol.r0002;

public class ArrayExam {

	public void printMultipleTable(int[]a, int[]b){
		int i , j;
		for(i=0;i<a.length;i++){

			for(j=0;j<b.length;j++){
				System.out.print(a[i] + "X" + b[j] + "=" + a[i]*b[j] + ",");	
			}
			System.out.println();
		}
	}
	public static void main(String[] args){
		ArrayExam ae = new ArrayExam();
		int[] a = {1,2,3,4,5,6,7,8,9};
		int[] b = {1,2,3,4,5,6,7,8,9};
		/*
		System.out.println("a의길이 = " + a.length);
		System.out.println("b의길이 = " + b.length);
		System.out.println("b의 첫번째 방의 값 = " + b[0]);
		for(int i=0; i<b.length;i++){
			System.out.println("b의 " + (i+1) + "번째 방의 값 = " + b[i]);
		}
		 */	
		ae.printMultipleTable(a, b);

	}
}
