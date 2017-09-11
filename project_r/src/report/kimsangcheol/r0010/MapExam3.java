package report.kimsangcheol.r0010;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MapExam3 extends HashMap<String,Integer>{
	HashMap<String,Integer> hm = new HashMap<String,Integer>();
	
	public String toString(){
		String result = "";
		List<String> keys = new ArrayList<>(keySet());
		int sum=0;;
		for(int i=0;i<keys.size();i++){
			String key = keys.get(i);
			sum += get(key);
		}
		result +=sum;
		return result;
	};

	public static void main(String[]args){
		MapExam3 me = new MapExam3();
		me.put("A", 1);
		me.put("B", 2);
		me.put("C", 3);
		me.put("D", 4);
		me.put("E", 5);
		me.put("F", 6);
		me.put("G", 7);
		me.put("H", 8);
		me.put("I", 9);
		me.put("J", 10);
		
		System.out.println(me);
	}
}
