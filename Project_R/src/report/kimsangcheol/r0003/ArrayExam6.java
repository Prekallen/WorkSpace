package report.kimsangcheol.r0003;

public class ArrayExam6 {

	public void arrayPrint(int[]a){
		for(int i=0;i<=a.length-1;i++){
			if(i==a.length-1){
				System.out.println(a[i]);
			}else{
				System.out.print(a[i]+" ");
			}
		}
	}
	public int[] arrayCal(int length, int initNum,int maxNum){
		int[]a= new int[length];
		for(int i=initNum;i<=maxNum;i++){
			a[maxNum-i] = i*2;
		}
		return a;
	}
	public void arrayLotto(){
		int[]a= new int[6];
		for(int i=0;i<6;i++){

			int rand = (int)(Math.random()*45)+1;
			a[i]=rand;

			for(int j=0;j<i;j++){
				if(a[j]==a[i]){
					j--;
				}
			}
		}
		for(int i=0;i<6;i++){
			System.out.println(a[i]);
		}
	}

	public static void main(String[] args){
		ArrayExam6 ae6 = new ArrayExam6();

		ae6.arrayPrint(ae6.arrayCal(10,0,9));
		ae6.arrayLotto();
	}
}
