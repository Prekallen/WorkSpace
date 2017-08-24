package report.kimsangcheol.r0006;

public class Father {
	private String address = "서울시 어딘가";		//private <<상속이 되지 않게 함. class Father만 사용 가능
	private int age = 101;
	private String name = "홍길동";
	
	int getAge(){
		return age;
	}
	String getAddress(){
		return address;
	}
	String getName(){
		return name;
	}
	int setAge(int a){
		age=a;
		return age;
	}
	
	
}
