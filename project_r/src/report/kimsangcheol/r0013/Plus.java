package report.kimsangcheol.r0013;

public class Plus implements InterfaceExam{

	
	public String getString() {
		return "Test의 getStirng()함수 호출!!";
	}



	public void setString(String str) {
		System.out.println("Test의 SetString()함수 호출!!"+str);
		
	}

	public int cal(int a, int b){
		return a+b;
	}

}
