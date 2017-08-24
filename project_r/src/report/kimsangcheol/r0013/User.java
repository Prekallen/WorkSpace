package report.kimsangcheol.r0013;

public class User {
	private InterfaceExam ie;
	User(String operator){
		if(operator.equals("+")){
			ie=new Plus();
		}else if(operator.equals("-")){
			ie=new Minus();
		}else if(operator.equals("*")){
			ie=new Multiple();
		}else if(operator.equals("/")){
			ie=new Division();
		}else{
			System.out.println("연산자를 잘못 입력");
		}
		
	}
	
	public InterfaceExam getInterfaceExam(){
		return ie;
	}
	
	public static void main(String[]args){
		User u = new User("+");
		InterfaceExam ie = u.getInterfaceExam();
		int result = ie.cal(2, 3);
		System.out.println(result);
		
		u=new User("-");
		ie=u.getInterfaceExam();
		result = ie.cal(2, 3);
		System.out.println(result);
		
		u = new User("*");
		ie = u.getInterfaceExam();
		result = ie.cal(2, 3);
		System.out.println(result);
		
		u=new User("/");
		ie=u.getInterfaceExam();
		result = ie.cal(2, 3);
		System.out.println(result);
	}
	
//	public static void main(String[]args){
//		InterfaceExam ie = new Exam();
//		InterfaceExam ie2 = new Test();
//		
//		
//		String str = ie.getString();
//		System.out.println(str);
//		String str2 = ie2.getString();
//		System.out.println(str2);
//		
//		
//		InterfaceExam2 ie3 = new Exam();
//		
//		int a= ie3.getInt();
//		System.out.println(a);
//		ie3.setInt(a);
//		
//	}
	
}
