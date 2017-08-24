package report.kimsangcheol.r0005;

public class Exam3 {
	public static void main(String[] args){
		//a갑을병정무기경신임계
		Cal c1 = new Cal(1,2,"+");
		c1.printCal();
		Cal c2= new Cal();
		c2.printCal();
		
		Cal[] arrC = new Cal[2];
		arrC[0] = c1;
		arrC[1] = c2;
		
	}
}