package report.kimsangcheol.PE;

class Thing {
    public final static int LUCKY_NUMBER = 7;
     
    public String name;
    public static String description;
     
    public static int count = 0;
     
    public int id;
     
    public Thing() {
         
        id = count;
         
        count++;
    }
     
    public void showName() {
        System.out.println("Object id: " + id + ", " + description + ": " + name);
    }
     
    public static void showInfo() {
        System.out.println(description);
        // Won't work: System.out.println(name);
    }
}

public class App {
	public static void main(String[]args){
		Thing.description = "This is a thing!";		//description에 값을 입력
		
		Thing.showInfo();						//description 값을 출력

		System.out.println("생성 전, count is: " + Thing.count);
		Thing thing1 = new Thing();
		Thing thing2 = new Thing();
		System.out.println("생성 후, count is: "+ Thing.count);
		
		thing1.name = "닭";
        thing2.name = "오리";
         
        thing1.showName();								//입력한 이름과 Description과 ID의 값을 출력
        thing2.showName();
        
        System.out.println(Math.PI);					//PI 값을 출력
         
        System.out.println(Thing.LUCKY_NUMBER);			//Lucky_Number의 값을 출력
		
		
		
	}
}
