package common;

public class DBConn {
	static int a=1;
	static int getInt() {		//throws 문을 사용 하면 반드시 try&catch 문을 사용해야함
		try{
		int a = Integer.parseInt("str");
		return a;
		}catch(Exception e ){
			e.printStackTrace();
			return 0;
		}
	}
	
	public static void main(String[]args){
		DBConn dbc = new DBConn();
		
			int a = dbc.getInt();				
		
	}
}
