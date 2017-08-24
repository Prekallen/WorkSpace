package report.kimsangcheol.r0006;

import java.util.ArrayList;

public class Son extends Father{			//Father 를 상속 받음. <다중 상속 불가능>
	int a;
	
											//상속 받은 함수들은 재정의를 할 수 있음. Overriding[함수의 재정의]
	public static void main(String[] args){
		Son s = new Son();
		s.a = 3;
		System.out.println(s.getAddress());
		System.out.println(s.getAge());
		System.out.println(s.getName());
		s.setAge(20);
		System.out.println(s.getAge());
	
		Father f = new Father();
		System.out.println(f.getAddress());
		ArrayList<String> manKind = new ArrayList<String>();
		manKind.add(s.getAddress());
		manKind.add(s.getName());
		for(int i=0;i<manKind.size();i++){
		System.out.println(manKind.get(i));
		}
	}
}