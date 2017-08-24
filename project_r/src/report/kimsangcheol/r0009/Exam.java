package report.kimsangcheol.r0009;

public class Exam {

	String[] str;
	Exam(){
		str[0] = "1";
	}
	
	Exam(int a){
		str = new String[3];
	}
	
	public static void main(String[] args){
		Exam e = new Exam(2);
		e = new Exam();
		System.out.println(e.str[0]);
		int a = 1;
		a = 2;
		System.out.println(a==1);
	}
}//와 나 이거