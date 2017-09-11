package test.sp.iot.anno2;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(1)
public class Developer implements Worker{
	
	public void work(){
		System.out.println("개발자가 놀고있음.");
	}
	public void goToWork(){
		System.out.println("개발자가 출근...급 우울..");
	}
	public void getOffWork(){
		System.out.println("개발자가 퇴근~ 신나게 또 놀아!..근데 새벽이라니..");
	}
}
