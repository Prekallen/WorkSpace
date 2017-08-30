package test.sp.iot.xml2;

public class Designer implements Worker{

	public void goToWork() {
		System.out.println("디자이너가 출근.");
		
	}

	public void work() {
		System.out.println("디자이너가 놀고있네...");
		
	}

	public void getOffWork() {
		System.out.println("디자이너가 칼퇴...");
		
	}
	
}
