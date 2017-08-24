package report.kimsangcheol.r0010;

import java.util.ArrayList;

public class ListExam<T> extends ArrayList{
	
	public static void main(String[]args){
		ListExam<MapExam> le = new ListExam<MapExam>();
		MapExam me = new MapExam();
		le.add(me);
		me.put("test", "test");
		System.out.println(me);
		
	}
}
