package report.kimsangcheol.r0005;

public class Cal2 {
	int num1;
	int num2;
	String operator;
	Cal2(int num1, int num2, String operator){
		this.num1=num1;
		this.num2=num2;
		this.operator=operator;
	}
	void printPlus(){
		if(operator.equals("+")){
			System.out.println(num1+num2);
		}
	}
	void printMinus(){
		if(operator.equals("-")){
			System.out.println(num1-num2);
		}
	}
	void printMultiple(){
		if(operator.equals("*")){
			System.out.println(num1*num2);
		}
	}
	void printDivision(){
		if(operator.equals("/")){
			System.out.println(num1/num2);
		}
	}
	public static void main(String[] args){
		Cal2 c2 = new Cal2(2,3,"*");
		c2.printPlus();
		c2.printMinus();
		c2.printMultiple();
		c2.printDivision();
	}

}