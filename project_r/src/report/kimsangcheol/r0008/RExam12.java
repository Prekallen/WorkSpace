package report.kimsangcheol.r0008;

import report.kimsangcheol.r0007.RExam11;

public class RExam12 extends RExam11{
	RExam12(int a, int b){
		super(a,b);
		this.a=a;
		this.b=b;
	}
	public static void main(String[]args){
		RExam12 rE12 = new RExam12(1,3);
		rE12.calcPlus();
		rE12.printCal();
		
		rE12.calcMinus();
		rE12.printCal();
		
		rE12.calcMultiple();
		rE12.printCal();
		
		rE12.calcDivision();
		rE12.printCal();
		
	}
}
