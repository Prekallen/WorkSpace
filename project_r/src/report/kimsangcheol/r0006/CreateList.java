package report.kimsangcheol.r0006;

import java.util.ArrayList;

public class CreateList {


	public static void main(String[] args){
		String [] a= new String[3];
		a[0] = "WoW";
		a[1] = "Incredable";
		a[2] = "Awesome";
		ArrayList<String> appe = new ArrayList<String>();
		for(int i=0;i<a.length;i++){
			appe.add(a[i]);
		}
		for(int i=0;i<appe.size();i++){
			System.out.println(appe.get(i));
		}
	}
}
