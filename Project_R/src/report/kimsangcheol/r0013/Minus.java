package report.kimsangcheol.r0013;

public class Minus implements InterfaceExam{

	
	public String getString() {
		return "Exam의 getStirng()함수 호출!!";
	}



	public void setString(String str) {
		System.out.println("Exam의 SetString()함수 호출!!"+str);
		
	}

	public int cal(int a, int b){
		return a-b;
	}
}
