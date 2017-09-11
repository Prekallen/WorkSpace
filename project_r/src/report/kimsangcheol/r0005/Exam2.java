package report.kimsangcheol.r0005;

public class Exam2 {

	public static void main(String[] args){
		Cal[]c = new Cal[5];
		for(int i=0; i<c.length;i++){
			c[i] = new Cal("으억");
		}
		c[0]= new Cal("꺅");
		c[1]= new Cal("으악");
		c[2]= new Cal("살려줘");
		c[3]= new Cal("제발");
		c[4]= new Cal("............");
		
		for(int i=0; i<c.length;i++){
			System.out.println(c[i].cl);
		}
		for(int i=0; i<c.length;i++){
			c[i] = new Cal(i+1);
		}
			
		for(int i=0; i<c.length;i++){
			System.out.println(c[i].a);
		}
	}
}
