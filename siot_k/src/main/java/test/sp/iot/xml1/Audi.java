package test.sp.iot.xml1;

public class Audi {
public Audi(){
		
	}
	
	public Car sellCar(Money money){
		
		Car car = new Car("A5");
		System.out.println(money.getWon() + "을 받고 A5를 팔았습니다.");
		return car;
	}
}

