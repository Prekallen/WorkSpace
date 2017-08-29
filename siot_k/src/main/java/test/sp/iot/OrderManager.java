package test.sp.iot;

public class OrderManager implements OrderInterface{
	
	private Hyundai hyundai;
	
	public OrderManager(){
	}
	
	public void setHyundai(Hyundai hyundai){
		this.hyundai = hyundai;
	}
	public void order(){
		Money m = new Money(50000000);
		Car c = this.hyundai.sellCar(m);
	}
}
