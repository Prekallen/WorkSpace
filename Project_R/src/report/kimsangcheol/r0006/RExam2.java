package report.kimsangcheol.r0006;

public class RExam2 {
	protected int a=1;							//같은 패키지면 사용 가능 패키지가 다르면 간접적으로 접근해야 함.
	protected int b=2;
	
	public void setA(int a){
		this.a = a;
	}
	
	public void setB(int b){
		this.b = b;
	}
	public int getA(){
		return a;
	}
	
	public int getB(){
		return b;
	}
	
}
