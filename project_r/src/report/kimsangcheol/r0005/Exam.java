package report.kimsangcheol.r0005;

public class Exam {

	public static void main(String[] args){
		int []a = new int[10];
		int []b = new int[10];
		Robot rb = new Robot("R3",18);
		Cal c = new Cal(1,1,"+");
		rb.doKick();
		rb.doRun();
		rb.doTransform();
		for(int i=0;i<a.length;i++){
			a[i]=i+1;
			b[i]=10-i;
		}
		for(int i=0;i<10;i++){
			c= new Cal(a[i],b[i],"+");
			c.printCal();
		}
		
		//		Cal c = new Cal(10,2,"+");
		//		c.printCal();
		//		c= new Cal(10,2,"-");
		//		c.printCal();
		//		c= new Cal(10,2,"*");
		//		c.printCal();
		//		c= new Cal(10,2,"/");
		//		c.printCal();

	}
}
