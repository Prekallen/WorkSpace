<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.google.gson.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.test.common.DBConn" %>
<%@ page import="java.sql.*" %>
<%
	Gson g = new Gson();
	HashMap<String, String> hm = g.fromJson(request.getReader(), HashMap.class);
	PreparedStatement ps = null;
	Connection con = null;
	List<HashMap> tableList = new ArrayList<HashMap>();
	List<HashMap> goodsList = new ArrayList<HashMap>();
	try{
		con=DBConn.getCon();
		String sql = "select vinum,viname";
				sql+=	" from vendor_info;";
	
		ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			HashMap<String,String> tableM = new HashMap<String,String>();
			tableM.put("vinum", rs.getString("vinum"));
			tableM.put("viname", rs.getString("viname"));
			
			tableList.add(tableM);
		}
		sql="select vi.vinum,viname,videsc,viaddress,viphone,vicredat,vicretim";
		sql+= ",ginum,giname,gidesc,gi.vinum,gicredat,gicretim ";
		sql+=	"from vendor_info as vi, goods_info as gi where vi.vinum=gi.vinum;";
		ps = con.prepareStatement(sql);
		rs=ps.executeQuery();
		while(rs.next()){
			HashMap<String,String> tableM = new HashMap<String,String>();
			tableM.put("vinum", rs.getString("vi.vinum"));
			tableM.put("viname", rs.getString("viname"));
			tableM.put("videsc", rs.getString("videsc"));
			tableM.put("viaddress", rs.getString("viaddress"));
			tableM.put("viphone", rs.getString("viphone"));
			tableM.put("vicredat", rs.getString("vicredat"));
			tableM.put("vicretim", rs.getString("vicretim"));
			tableM.put("ginum", rs.getString("ginum"));
			tableM.put("giname", rs.getString("giname"));
			tableM.put("gidesc", rs.getString("gidesc"));
			tableM.put("gicredat", rs.getString("gicredat"));
			tableM.put("gicretim", rs.getString("gicretim"));
			goodsList.add(tableM);
		}
	}catch (Exception e){
		out.print(e);
	}finally{
		ps.close();
		DBConn.closeCon();
	}
	HashMap lists = new HashMap();
	lists.put("goodsList",goodsList);
	lists.put("tableList",tableList);
	String json = g.toJson(lists);
	
	out.print(json);
%>