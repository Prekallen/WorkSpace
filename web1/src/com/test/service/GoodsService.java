package com.test.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.test.common.DBConn;
import com.test.dto.Goods;
import com.test.dto.Page;
import com.test.dto.Vendor;

public class GoodsService {

	public List<Goods> selectGoodsList(Goods pGoods){
		Connection con = null;
		PreparedStatement ps =null;		
		try{
			con = DBConn.getCon();
			String sql = "select gi.ginum, gi.giname, gi.gidesc, vi.vinum, vi.viname"
				+" from goods_info as gi, vendor_info as vi"
				+" where gi.vinum=vi.vinum";
			
			if(pGoods.getViNum()!=0){
				sql += " and vi.vinum =?";
			}		
			if(pGoods.getGiName()!=null && !pGoods.getGiName().equals("")){
				sql += " and gi.giname like ?";
			}
			sql+=" order by gi.ginum"
			+" limit ?,?";
			Page page = pGoods.getPage();
			ps=con.prepareStatement(sql);
			
			if(pGoods.getViNum()!=0 && (pGoods.getGiName()!=null&&!pGoods.getGiName().equals(""))){
				ps.setInt(1,pGoods.getViNum());
				ps.setString(2,"%" + pGoods.getGiName() + "%");
				ps.setInt(3,page.getStartRow());
				ps.setInt(4,page.getRowCnt());
			}else if(pGoods.getGiName()!=null && !pGoods.getGiName().equals("")){
				ps.setString(1,"%" + pGoods.getGiName() + "%");
				ps.setInt(2,page.getStartRow());
				ps.setInt(3,page.getRowCnt());
			}else if(pGoods.getViNum()!=0){
				ps.setInt(1,pGoods.getViNum());
				ps.setInt(2,page.getStartRow());
				ps.setInt(3,page.getRowCnt());
			}else{
				ps.setInt(1,page.getStartRow());
				ps.setInt(2,page.getRowCnt());
			}
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
	
	public Goods selectGoods(Goods pGoods){
		Connection con = null;
		PreparedStatement ps =null;		
		try{
			con = DBConn.getCon();
			String sql = "select gi.ginum, gi.giname, gi.gidesc, vi.vinum, vi.viname"
				+" from goods_info as gi, vendor_info as vi"
				+" where gi.vinum=vi.vinum";
			sql += " and gi.ginum =?";
					
			Page page = pGoods.getPage();
			ps=con.prepareStatement(sql);
			
			if(pGoods.getGiNum()!=0){
				ps.setInt(1,pGoods.getGiNum());
			}
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Goods goods = new Goods();
				goods.setGiNum(rs.getInt("gi.ginum"));
				goods.setGiName(rs.getString("gi.giname"));
				goods.setGiDesc(rs.getString("gi.gidesc"));
				goods.setViNum(rs.getInt("vi.vinum"));
				goods.setViName(rs.getString("vi.viname"));
				return goods;
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
		return null;
		
	}
	
	public List<Vendor> barList(){
		Connection con = null;
		PreparedStatement ps =null;		
		try{
			con = DBConn.getCon();				
			String sql = "select vinum, viname"
				+" from vendor_info";
			ps=con.prepareStatement(sql);		
			ResultSet rs = ps.executeQuery();
			List<Vendor> bList = new ArrayList<Vendor>();
			while(rs.next()){
				Vendor vendor = new Vendor();
				vendor.setViNum(rs.getInt("vinum"));
				vendor.setViName(rs.getString("viname"));
				bList.add(vendor);
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
			String sql= "select count(1) from goods_info as gi, vendor_info as vi where gi.vinum=vi.vinum";
			if(pGoods.getViNum()!=0){
				sql += " and gi.vinum =?";
			}		
			if(pGoods.getGiName()!=null && !pGoods.getGiName().equals("")){
				sql += " and gi.giname like ?";
			}
			
			ps = con.prepareStatement(sql);
			if(pGoods.getViNum()!=0 && pGoods.getGiName()!=null&&!pGoods.getGiName().equals("")){
				ps.setInt(1,pGoods.getViNum());
				ps.setString(2,"%" + pGoods.getGiName() + "%");
			}else if(pGoods.getGiName()!=null && !pGoods.getGiName().equals("")&&pGoods.getViNum()==0){
				ps.setString(1,"%" + pGoods.getGiName() + "%");
			}else if(pGoods.getViNum()!=0&&(pGoods.getGiName()==null || pGoods.getGiName().equals(""))){
				ps.setInt(1,pGoods.getViNum());
			}
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

	public int deleteGoods(Goods pGoods){
		Connection con = null;
		PreparedStatement ps =null;		
		try{
			con = DBConn.getCon();
			String sql = "delete from goods_info where ginum =?";
			
			ps=con.prepareStatement(sql);
			
			if(pGoods.getGiNum()!=0){
				ps.setInt(1,pGoods.getGiNum());
			}
			int result = ps.executeUpdate();
			con.commit();
			return result;
			
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
	public int updateGoods(Goods pGoods){
		Connection con = null;
		PreparedStatement ps =null;		
		try{
			con = DBConn.getCon();
			String sql = "update goods_info set giname =? , gidesc= ? , vinum =?, gicredat= date_format(now(),'%Y%m%d'), gicretim=date_format(now(),'%H%i%s') ";
				sql+=" where ginum = ?";
			
			ps=con.prepareStatement(sql);
			
			if(pGoods.getGiNum()!=0&&pGoods.getViNum()!=0&&pGoods.getGiName().equals("")&&pGoods.getGiDesc().equals("")){
				ps.setString(1, pGoods.getGiName());
				ps.setString(2, pGoods.getGiDesc());
				ps.setInt(3,pGoods.getViNum());
				ps.setInt(4,pGoods.getGiNum());
			}
			int result = ps.executeUpdate();
			con.commit();
			return result;
			
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
	public int insertGoods(Goods pGoods){
		Connection con = null;
		PreparedStatement ps =null;		
		try{
			con = DBConn.getCon();
			String sql = "insert into goods_info (giname, gidesc, vinum, gicredat, gicretim)";
				sql+= " value(?, ?, ?, date_format(now(),'%Y%m%d'), date_format(now(),'%H%i%s')";
				
			ps=con.prepareStatement(sql);
			
			if(pGoods.getGiNum()!=0&&pGoods.getViNum()!=0&&pGoods.getGiName().equals("")&&pGoods.getGiDesc().equals("")){
				ps.setString(1, pGoods.getGiName());
				ps.setString(2, pGoods.getGiDesc());
				ps.setInt(3,pGoods.getViNum());
			}
			int result = ps.executeUpdate();
			con.commit();
			return result;
			
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
