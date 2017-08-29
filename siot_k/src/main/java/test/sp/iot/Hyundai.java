package test.sp.iot;

public class Hyundai {

		public Hyundai(){
			
		}
		
		public Car sellCar(Money money){
			Car car = new Car("EQUUS");
			System.out.println(money.getWon() + "을 받고 EQUUS를 팔았습니다.");
			return car;
		}
	}


