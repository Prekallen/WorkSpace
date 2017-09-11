package report.kimsangcheol.PE;

public class StringBuilderExam {
	public static void main(String[]args){
		String info = "";

		info += "My name is Bob.";
		info += " ";
		info += "I am a builder.";

		System.out.println(info);

		StringBuilder sb = new StringBuilder();
		sb.append("My name is John.");
		sb.append(" ");
		sb.append("I am one of Builders.");
		
		System.out.println(sb.toString());

		StringBuilder s = new StringBuilder();
		s.append("My name is Tom")
		.append(" ")
		.append("I am a good Builder.");
		
		System.out.println(s.toString());
		
		System.out.print("Here is some text.\tThat was a tab.\nThat was a newline.");
        System.out.println(" More text.");

        System.out.printf("Total cost %-7d: quantity is %d\n", 5, 120);							//-i = 다음 문자열과의 간격
        
        for(int i=0; i<20; i++) {
            System.out.printf("%-2d: %s\n", i, "here is some text");
        }
        System.out.printf("Total value: %.3f\n", 5.6874);

        System.out.printf("Total value: %-6.2f\n", 343.23423);									//.xxx<< 소수점 x갯수 자리 까지 출력.

        String formatted = String.format("This is a floating-point value: %.3f", 5.12345);		//format 숫자를 문자로 저장.
        System.out.println(formatted);
        
        System.out.printf("Giving it %d%% is physically impossible.", 100);						//% 표현은 %%
	}
}