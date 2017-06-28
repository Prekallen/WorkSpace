package report.kimsangcheol.r0004;

public class Exam3 {
	int a= 0;
	int b= 0;
	int result = 0;

	public Exam3(){						//Exam3 <= 생성자 클래스와 이름이 같아야 하고 변수타입이 없다.
		//return 타입이 없기 때문에 void도 쓸 필요가 없다.
	}
	public Exam3(int a,int b){			//같은 명의 파라메터가 다르면 다른 함수이다.=>overloading
		this.a = a;						//this는 Class에 선언된 변수
		this.b = b;					
		this.result = this.a+this.b ;						
	}

	public void printA(char a, int b){	//변수 개수가 같아도 타입이 다르면 생성 가능

	}
	public void printA(int a, char b){ 	//같은 타입에 파라메터로는 선언 할 수 없다.

	}

	public static void main(String[] args){
		Exam3 e = new Exam3(1,2);
		e.b = 4;
		System.out.println(e.result);

		Exam3 e2 = new Exam3(2,2);
		System.out.println(e2.result);
	}
}
