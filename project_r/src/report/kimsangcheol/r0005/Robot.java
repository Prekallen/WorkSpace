package report.kimsangcheol.r0005;

public class Robot {
	String name;
	int age;
	
	Robot(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	void doKick(){
		System.out.println(age+"살먹은 " +name +"가 후려찬다.");	
	}
	
	void doRun(){
		System.out.println(age+"살먹은 " +name +"가 도주중. <쏘지마>");
	}

	void doTransform(){
		System.out.println(age+"살먹은 " +name +"가 변신함. <때리지마>");
	}
	
	public static void main(String[] args){
		Robot rb = new Robot("R2",100);
		rb.doKick();
		rb.doRun();
		rb.doTransform();
		
	}
}
