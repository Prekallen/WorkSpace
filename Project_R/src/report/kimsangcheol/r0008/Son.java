package report.kimsangcheol.r0008;

public class Son extends Father{
	
	Son(){
		System.out.println("기본 아들 생성자 호출!!!");
		
	}
	Son(int a){
		System.out.println("오버로딩으로 추가한 아들 생성자 호출!!!");		//Son생성자 호출 하기 전에 Father생성자를 먼저 호출
	}
	public static void main(String[]args){
		Son s = new Son();
		s.printInput();
		s.printScore();
	}

}				//너무 더워............더워.....하지.....일년중 낮의 길이가 최대.....