package common;

public class Exam {
	
	public static void main(String[]args){
		DBConn dbc = new DBConn();
		dbc.a =3;
		System.out.println(dbc.a);
		System.out.println(DBConn.a);
		DBConn.a = 4;
		System.out.println(DBConn.a);
		dbc = new DBConn();
		System.out.println(dbc.a);
		int a= DBConn.getInt();
	}
}
