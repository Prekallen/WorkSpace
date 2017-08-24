package report.kimsangcheol.r0007;

import report.kimsangcheol.r0006.RExam2;

public class Exam6 extends RExam2{		//protected는 다른 패키지에서 접근이 직접적으로 안되지만 상속을 받으면 직접 사용 가능.
	
	public static void main(String[]args){
		Exam6 e6 = new Exam6();
		e6.a = 3;
		System.out.println(e6.a);
	}

}
