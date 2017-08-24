package report.kimsangcheol.r0012;

import java.util.ArrayList;
import java.util.HashMap;

public class DataTypeExam4 {

	public static void main(String[]args){
		HashMap hm = new HashMap();
		ArrayList <HashMap>listHm = new ArrayList<HashMap>();
		HashMap lists = new HashMap();
		hm.put("Ŭ����", "A");
		hm.put("�̸�","ȫ�浿");
		hm.put("����", "20");
		hm.put("����","����");
		listHm.add(hm);

		HashMap hm2 = new HashMap();
		hm2.put("Ŭ����", "B");
		hm2.put("�̸�","������");
		hm2.put("����", "25");
		hm2.put("����","����");
		listHm.add(hm2);

		HashMap hm3 = new HashMap();
		hm3.put("Ŭ����", "C");
		hm3.put("�̸�","������");
		hm3.put("����", "22");
		hm3.put("����","����");
		listHm.add(hm3);

		HashMap hm4 = new HashMap();
		hm4.put("Ŭ����", "D");
		hm4.put("�̸�","������");
		hm4.put("����", "5");
		hm4.put("����","����");
		listHm.add(hm4);

		for(HashMap lists1 : listHm){
			System.out.print(lists1.get("Ŭ����") + "\t");
			System.out.print(lists1.get("�̸�") + "\t");
			System.out.print(lists1.get("����") + "\t");
			System.out.println(lists1.get("����"));
			
		}
	}
}
