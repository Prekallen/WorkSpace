package com.test.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.common.DBConn;
import com.test.dto.Goods;
import com.test.dto.Page;
import com.test.dto.Vendor;

public class VendorService {
	public List<Vendor> selectVendorList(String viName){
		Connection con = null;
		PreparedStatement ps =null;		
		try{
			con = DBConn.getCon();
			String sql = "select vinum, viname, videsc, viaddress, viphone, vicredat, vicretim"
				+" from vendor_info where 1=1";
				if(viName!=null){
					sql+= " and viname like ?";
				}
				sql+= " order by vinum";
			ps=con.prepareStatement(sql);
			if(viName!=null){
				ps.setString(1, "%" + viName + "%");
			}
			ResultSet rs = ps.executeQuery();
			List<Vendor> vList = new ArrayList<Vendor>();
			while(rs.next()){
				Vendor vendor = new Vendor();
				vendor.setViNum(rs.getInt("vinum"));
				vendor.setViName(rs.getString("viname"));
				vendor.setViDesc(rs.getString("videsc"));
				vendor.setViAddress(rs.getString("viaddress"));
				vendor.setViPhone(rs.getString("viPhone"));
				vendor.setViCreDat(rs.getString("vicredat"));
				vendor.setViCreTim(rs.getString("vicretim"));
				vList.add(vendor);
			}
			
			return vList;
			
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

	public int deleteVendor(Goods pGoods){
		Connection con = null;
		PreparedStatement ps =null;		
		try{
			con = DBConn.getCon();
			String sql = "delete from vendor_info where vinum =?";
			
			ps=con.prepareStatement(sql);
			
			if(pGoods.getViNum()!=0){
				ps.setInt(1,pGoods.getViNum());
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
	public int updateVendor(Goods pGoods){
		Connection con = null;
		PreparedStatement ps =null;		
		try{
			con = DBConn.getCon();
			String sql = "update goods_info set giname =? , gidesc=? , vinum =?, gicredat= date_format(now(),'%Y%m%d'), gicretim=date_format(now(),'%H%i%s')";
				sql+=" where ginum = ?;";
			
			ps=con.prepareStatement(sql);
			ps.setString(1, pGoods.getGiName());
			ps.setString(2, pGoods.getGiDesc());
			ps.setInt(3,pGoods.getViNum());
			ps.setInt(4,pGoods.getGiNum());
			
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
	public int insertVendor(Goods pGoods){
		Connection con = null;
		PreparedStatement ps = null;
		try {
			String sql = "insert into goods_info(giname, gidesc, vinum, gicredat, gicretim)";
			sql += " values(?,?,?,DATE_FORMAT(NOW(),'%Y%m%d'), DATE_FORMAT(NOW(),'%H%i%s'));";
			con = DBConn.getCon(); 
			ps = con.prepareStatement(sql);
			ps.setString(1, pGoods.getGiName());
			ps.setString(2, pGoods.getGiDesc());
			ps.setInt(3, pGoods.getViNum());
			int result = ps.executeUpdate();
			con.commit();
			return result;
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
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