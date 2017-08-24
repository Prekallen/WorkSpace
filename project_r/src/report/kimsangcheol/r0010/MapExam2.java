package report.kimsangcheol.r0010;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MapExam2 extends HashMap{
	MapExam2(){
		
		
	}
	public String put(String key){
		if(!containsKey(key)){
			put(key,"test");
			return "잘 들어갔어요";
		}
		return "이미 있음";
	}
	public String toString(){
		String result = "";
		List<String> keys = new ArrayList<>(keySet());
		for(int i=0;i<keys.size();i++){
			String key = keys.get(i);
			Object value = (Object)get(key);
			result += "[" + key + "," + value + "]\n";
		}
		if(result.equals("")){
			result = "암것도 없음.";
		}
		return result;
	}
	public static void main(String[]args){
		MapExam2 me = new MapExam2();
		
		me.put("asdf");
		
		System.out.println(me);
		
	}
}

