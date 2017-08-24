package report.kimsangcheol.r0010;

import java.util.HashMap;
import java.util.Iterator;

public class MapExam extends HashMap{
	MapExam(){
		
		
	}
	
	public String toString(){
		String result = "";
		Iterator it = keySet().iterator();
		while(it.hasNext()){
			String key = (String)it.next();
			Object value = (Object)get(key);
			result += "[" + key + "," + value + "]\n";
		}
		if(result.equals("")){
			result = "암것도 없음.";
		}
		return result;
	}
	public static void main(String[]args){
		MapExam me = new MapExam();
		me.put("A군", 50);
		me.put("B군", 60);
		me.put("C군", 70);
		me.put("D군", 80);
		me.put("E군", 90);
		//sdjfksl
		System.out.println(me);
		
	}
}
