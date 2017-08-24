package report.kimsangcheol.PE;

import java.util.ArrayList;

public class List1 {
	public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
 
        // Adding
        numbers.add(10);
        numbers.add(100);
        numbers.add(40);
 
        // 0번 주소의 값을 불러옴
        System.out.println(numbers.get(0));
 
        System.out.println("nIteration #1: ");
        // 0번 부터 리스트 사이즈 만큼 반복하면서 출력
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }
 
        // List 하나를 없앤다
        numbers.remove(numbers.size() - 1);
 
        // List 0번을 없앤다
        numbers.remove(0);
 
        System.out.println("nIteration #2: ");
        for (Integer value : numbers) {
            System.out.println(value);
        }
 
        // List interface ...[스트링형]
        ArrayList<String> values = new ArrayList<String>();
        values.add("야");
        values.add("호");
        values.add("!");
        for( int a= 0; a< values.size();a++){
        System.out.print(values.get(a));
        }
    }
}
