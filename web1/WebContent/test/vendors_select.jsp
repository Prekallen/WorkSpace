<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.google.gson.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.test.common.DBConn" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>

<%
	int rowCnt = 10;
	int nowPage=1;
	int blockCnt = 10;
	int totalPageCnt = 0;
	int totalBlockCnt =0;
	int totalCnt = 0;
	Gson g = new Gson();
	HashMap<String, String> hm = g.fromJson(request.getReader(), HashMap.class);
	if(hm!=null && hm.get("nowPage")!=null){
		nowPage = Integer.parseInt(hm.get("nowPage"));
	}
	
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
		
		sql= "select count(1) from goods_info as gi, vendor_info as vi where gi.vinum=vi.vinum;";
		ps = con.prepareStatement(sql);
		rs=ps.executeQuery();
		
		while(rs.next()){
			totalCnt = rs.getInt(1);
		}
		if(totalCnt!=0){
			int mod = totalCnt%rowCnt;
			totalPageCnt = totalCnt/rowCnt;
			if(mod!=0){
				totalPageCnt +=1;
			}
		}
		
		if(totalPageCnt!=0){
			int mod = totalPageCnt%blockCnt;
			totalBlockCnt =totalPageCnt/blockCnt;
			if(mod!=0){
				totalBlockCnt +=1;
			}
		}
	
		sql="select gi.ginum, gi.giname, gi.gidesc, vi.vinum, vi.viname from goods_info as gi";
		sql+= ", vendor_info as vi where vi.vinum = gi.vinum";
		sql+= " order by gi.ginum";
		sql+= " limit ?,?";
		ps = con.prepareStatement(sql);
		ps.setInt(1,(nowPage-1)*rowCnt);
		ps.setInt(2,rowCnt);
		rs=ps.executeQuery();
		while(rs.next()){
			HashMap<String,String> tableM = new HashMap<String,String>();
			tableM.put("vinum", rs.getString("vi.vinum"));
			tableM.put("viname", rs.getString("vi.viname"));
			tableM.put("ginum", rs.getString("gi.ginum"));
			tableM.put("giname", rs.getString("gi.giname"));
			tableM.put("gidesc", rs.getString("gi.gidesc"));
			goodsList.add(tableM);
		}
		
	}catch (Exception e){
		out.print(e);
	}finally{
		ps.close();
		DBConn.closeCon();
	}
	HashMap <String, Integer> pageHm = new HashMap<String, Integer>();
	pageHm.put("nowPage",nowPage);
	pageHm.put("totalPageCnt",totalPageCnt);
	pageHm.put("totalBlockCnt",totalBlockCnt);
	pageHm.put("totalCnt",totalCnt);
	pageHm.put("blockCnt",blockCnt);
	
	HashMap lists = new HashMap();
	lists.put("goodsList",goodsList);
	lists.put("tableList",tableList);
	lists.put("pageInfo",pageHm);
	String json = g.toJson(lists);
	
	out.print(json);
%>