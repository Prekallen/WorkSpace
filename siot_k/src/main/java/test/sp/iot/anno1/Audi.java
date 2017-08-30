package test.sp.iot.anno1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("au")
public class Audi implements Maker{
	@Autowired
	private Car car;
	public Audi(){}
	
	public Car sellCar(Money money){
		System.out.println("아우디회사에서" + money.getWon() + "원에 차 매매");
		car.setName("A5");
		return car;
	}
}
