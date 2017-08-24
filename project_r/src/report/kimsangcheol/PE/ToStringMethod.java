package report.kimsangcheol.PE;


class Things{
	private int id;
	private String name;
	Things(int id, String name){
		this.id = id;
		this.name = name;
	}
	public String toString(){
		return String.format("%-3d : %s", id, name);					//스트링 형태로 format
	}
}
public class ToStringMethod {
	public static void main(String[]args){
	Things thing1 = new Things(9,"Bob");
	Things thing2 = new Things(45, "John");
	System.out.println(thing1);
	System.out.println(thing2);
	}
}
