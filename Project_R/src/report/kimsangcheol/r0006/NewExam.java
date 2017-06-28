package report.kimsangcheol.r0006;

public class NewExam {

	public static void main(String[] args){
//		//==은 주소값을 비교, .equals는 변수주소 안에 값을 비교.
		String str1 = "a";
		String str2 = "a";
		System.out.println(str1==str2);	
		str1 = new String("b");
		str2 = new String("b");
		System.out.println(str1==str2);
		System.out.println("adsf".equals("adsf"));
		
	}
}
