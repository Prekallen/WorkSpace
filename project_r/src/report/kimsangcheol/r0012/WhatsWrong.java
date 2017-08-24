package report.kimsangcheol.r0012;

import java.util.ArrayList;
import java.util.Scanner;

public class WhatsWrong {
	ArrayList list;
	WhatsWrong(){
		list = new ArrayList();
	}
	
	public static void main(String[]args){
		ArrayList list;
		Scanner scan = new Scanner(System.in);
		WhatsWrong ww = new WhatsWrong();
		for(int i =0;i<10;i++){
			ww.list.add(i+1);
		}
		System.out.println(ww.list);
	}
}
