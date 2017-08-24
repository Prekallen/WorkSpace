package report.kimsangcheol.r0012;

import java.util.ArrayList;
import java.util.HashMap;

public class DataTypeExam3 {

	public static void main(String[]args){
		ArrayList<HashMap> numList = new ArrayList<HashMap>();
		HashMap hm = new HashMap();
		hm.put("��ȣ","1");
		hm.put("����","�Խù�1");
		hm.put("�ۼ���","ȫ�浿");
		numList.add(hm);
		
		HashMap hm1 = new HashMap();
		hm1.put("��ȣ","2");
		hm1.put("����","�Խù�2");
		hm1.put("�ۼ���","������");
		numList.add(hm1);
		
		HashMap hm2 = new HashMap();
		hm2.put("��ȣ","3");
		hm2.put("����","�Խù�3");
		hm2.put("�ۼ���","������");
		numList.add(hm2);
		
		for(int i = 0; i < numList.size();i++){
			HashMap resultHm = numList.get(i);
			System.out.print(resultHm.get("��ȣ") + ",");
			System.out.print(resultHm.get("����") + ",");
			System.out.println(resultHm.get("�ۼ���"));
		}
		
		//Create Read Update Delete
	}
}
