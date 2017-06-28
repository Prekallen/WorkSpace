package report.kimsangcheol.r0012;

import java.util.ArrayList;
import java.util.HashMap;

public class DataTypeExam6 extends DataTypeExam5{

	public HashMap getHashMap(){
		HashMap hm = new HashMap();
		System.out.println("Ŭ���� ������ �Է��ϼ���.");
		hm.put("Ŭ����", scan.nextLine());
		return hm;
	}


	public static void main(String[]args){
		ArrayList<HashMap> aL = new ArrayList<HashMap>();
		DataTypeExam6 dte6 = new DataTypeExam6();
		for(int i=0;i<2;i++){

			aL.add(dte6.getHashMap());
		}

		for(HashMap lists1 : aL){
			System.out.print(lists1.get("Ŭ����") + "\t");
			System.out.print(lists1.get("�̸�") + "\t");
			System.out.print(lists1.get("����") + "\t");
			System.out.println(lists1.get("����") + "\t");
		}	
	}
}
