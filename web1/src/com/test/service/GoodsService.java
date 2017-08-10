package com.test.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.test.common.DBConn;
import com.test.dto.Goods;
import com.test.dto.Page;

public class GoodsService {

	public List<Goods> selectGoodsList(Goods pGoods){
		Connection con = null;
		PreparedStatement ps =null;		
		try{
			con = DBConn.getCon();
			String sql = "select gi.ginum, gi.giname, gi.gidesc, vi.vinum, vi.viname"
				+" from goods_info as gi, vendor_info as vi"
				+" where gi.vinum=vi.vinum"
				+" order by gi.ginum"
				+" limit ?,?";
			Page page = pGoods.getPage();
			ps=con.prepareStatement(sql);
			ps.setInt(1,page.getStartRow());
			ps.setInt(2,page.getRowCnt());
			ResultSet rs = ps.executeQuery();
			List<Goods> gList = new ArrayList<Goods>();
			while(rs.next()){
				Goods goods = new Goods();
				goods.setGiNum(rs.getInt("gi.ginum"));
				goods.setGiName(rs.getString("gi.giname"));
				goods.setGiDesc(rs.getString("gi.gidesc"));
				goods.setViNum(rs.getInt("vi.vinum"));
				goods.setViName(rs.getString("vi.viname"));
				gList.add(goods);
			}
			System.out.println(page);
			return gList;
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				DBConn.closeCon();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return null;
		
	}
	public List<Goods> barList(Goods pGoods){
		Connection con = null;
		PreparedStatement ps =null;		
		try{
			con = DBConn.getCon();				
			String sql = "select vinum, viname"
				+" from vendor_info";
			ps=con.prepareStatement(sql);		
			ResultSet rs = ps.executeQuery();
			List<Goods> bList = new ArrayList<Goods>();
			while(rs.next()){
				Goods goods = new Goods();
				goods.setViNum(rs.getInt("vinum"));
				goods.setViName(rs.getString("viname"));
				bList.add(goods);
			}
			return bList;
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				DBConn.closeCon();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return null;
	}
	public int getTotalCount(Goods pGoods){
		Connection con = null;
		PreparedStatement ps =null;
		try{
			con = DBConn.getCon();	
			String sql= "select count(1) from goods_info as gi, vendor_info as vi where gi.vinum=vi.vinum;";
			ps = con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				return rs.getInt(1);
			}
				
				
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				DBConn.closeCon();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return 0;
	}
}
