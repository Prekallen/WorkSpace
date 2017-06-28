package report.kimsangcheol.r0012;

import java.util.HashMap;

public class FunctionExam3 {	
	
	public void setHashMap(HashMap hm){
		hm.put("number",4);
	}
	
	public HashMap getHashMap(){
		HashMap hm = new HashMap();
		hm.put("number", 4);
		return hm;
	}
	public static void main(String[]args){
		FunctionExam3 fe3 = new FunctionExam3();
		
		HashMap hm = new HashMap();
		hm.put("number", 1);
		System.out.println(hm);
		
		fe3.setHashMap(hm);
		System.out.println(hm);
		
		hm = fe3.getHashMap();
		System.out.println(hm);
	}
}
