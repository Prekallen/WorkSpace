package report.kimsangcheol.r0005;

import java.util.ArrayList;

public class ExamList {

	public static void main(String[] args){
		ArrayList<Cal> list = new ArrayList<Cal>();				//Cal의 변수 타입만 사용 한다면 <Cal>로 같이 선언하면 None Warn

		for(int i=0; i<3;i++){
			Cal c= new Cal(i);
			list.add(c);
		}
		
		for(int i=0; i<3;i++){
		Cal c2= list.get(i);
		System.out.println(c2.a);
		}

	}
}