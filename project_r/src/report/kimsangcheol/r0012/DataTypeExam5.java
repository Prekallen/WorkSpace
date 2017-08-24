package report.kimsangcheol.r0012;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DataTypeExam5 {
	Scanner scan = new Scanner(System.in);

	public HashMap getHashMap(){

		HashMap hm = new HashMap();
		System.out.println("Ŭ������ �Է��ϼ���.>");
		hm.put("Ŭ����",scan.nextLine());
		System.out.println("�̸��� �Է��ϼ���.>");
		hm.put("�̸�",scan.nextLine());
		System.out.println("���̸� �Է��ϼ���.>");
		hm.put("����",scan.nextLine());
		System.out.println("������ �Է��ϼ���.>");
		hm.put("����",scan.nextLine());
		return hm;
	}

	public static void main(String[]args){
		DataTypeExam5 dte = new DataTypeExam5();
		ArrayList <HashMap> aL = new ArrayList<HashMap>();
		for(int i=0;i<5;i++){

			aL.add(dte.getHashMap());
		}

		for(HashMap lists1 : aL){
			System.out.print(lists1.get("Ŭ����") + "\t");
			System.out.print(lists1.get("�̸�") + "\t");
			System.out.print(lists1.get("����") + "\t");
			System.out.println(lists1.get("����") + "\t");
		}		
	}
}
