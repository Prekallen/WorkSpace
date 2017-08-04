<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.google.gson.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.test.common.DBConn" %>
<%@ page import="java.sql.*" %>
<%
	Gson g = new Gson();
	HashMap<String, String> hm = g.fromJson(request.getReader(), HashMap.class);
	String vinum = "";
	String viname = "";
	String giname = "";
	int s_vendor=0;
	if (hm != null) {
		vinum = hm.get("s_vendor");
		giname = hm.get("giname");
	}
	PreparedStatement ps = null;
	Connection con = null;
	List<HashMap> tableList = new ArrayList<HashMap>();
	try{
		con=DBConn.getCon();
		String sql = "select vi.vinum,viname,videsc,viaddress,viphone,vicredat,vicretim";
				sql+= ",ginum,giname,gidesc,gi.vinum,gicredat,gicretim ";
				sql+=	"from vendor_info vi, goods_info gi where vi.vinum=gi.vinum";
		if(vinum!=null && !vinum.equals("")){
			sql += " and vi.vinum =?";
		}		
		if(giname!=null && !giname.equals("")){
			sql += " and giname =?";
		}
		ps = con.prepareStatement(sql);
		if(vinum!=null&&!vinum.equals("") && giname!=null&&!giname.equals("")){
			ps.setInt(1,Integer.parseInt(vinum));
			ps.setString(2,giname);
		}else if(giname!=null && !giname.equals("")){
			ps.setString(1,giname);
		}else if(vinum!=null && !vinum.equals("")){
			ps.setInt(1,Integer.parseInt(vinum));
		}
		ResultSet rs = ps.executeQuery();
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
			tableList.add(tableM);
		}	
	}catch (Exception e){
		System.out.println(e);
	}finally{
		ps.close();
		DBConn.closeCon();
	}
	String json = g.toJson(tableList);

	out.print(json);
%>
    