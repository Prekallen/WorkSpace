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
				vendor.setViPhone(rs.getString("viphone"));
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
	
	public Vendor selectVendor(int viNum){
		Connection con = null;
		PreparedStatement ps =null;		
		try{
			con = DBConn.getCon();
			String sql = "select vinum, viname, videsc, viaddress, viphone, vicredat, vicretim"
				+" from vendor_info where vinum=?";
			ps=con.prepareStatement(sql);
			if(viNum!=0){
				ps.setInt(1, viNum);
			}
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Vendor vendor = new Vendor();
				vendor.setViNum(rs.getInt("vinum"));
				vendor.setViName(rs.getString("viname"));
				vendor.setViDesc(rs.getString("videsc"));
				vendor.setViAddress(rs.getString("viaddress"));
				vendor.setViPhone(rs.getString("viphone"));
				vendor.setViCreDat(rs.getString("vicredat"));
				vendor.setViCreTim(rs.getString("vicretim"));
				return vendor;
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

	public int deleteVendor(Vendor vendor){
		Connection con = null;
		PreparedStatement ps =null;		
		try{
			con = DBConn.getCon();
			String sql = "delete from vendor_info where vinum =?";
			
			ps=con.prepareStatement(sql);
			
			if(vendor.getViNum()!=0){
				ps.setInt(1,vendor.getViNum());
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
	public int updateVendor(Vendor vendor){
		Connection con = null;
		PreparedStatement ps =null;		
		try{
			con = DBConn.getCon();
			String sql = "update vendor_info set viname =? , videsc=? , viaddress =?, viphone=?, vicredat= date_format(now(),'%Y%m%d'), vicretim=date_format(now(),'%H%i%s')";
				sql+=" where vinum = ?;";
			
			ps=con.prepareStatement(sql);
			ps.setString(1, vendor.getViName());
			ps.setString(2, vendor.getViDesc());
			ps.setString(3,vendor.getViAddress());
			ps.setString(4,vendor.getViPhone());
			ps.setInt(5,vendor.getViNum());
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
	public int insertVendor(Vendor vendor){
		Connection con = null;
		PreparedStatement ps = null;
		try {
			String sql = "insert into vendor_info(viname, videsc, viaddress, viphone, vicredat, vicretim)";
			sql += " values(?,?,?,?,DATE_FORMAT(NOW(),'%Y%m%d'), DATE_FORMAT(NOW(),'%H%i%s'));";
			con = DBConn.getCon(); 
			ps = con.prepareStatement(sql);
			ps.setString(1, vendor.getViName());
			ps.setString(2, vendor.getViDesc());
			ps.setString(3, vendor.getViAddress());
			ps.setString(4, vendor.getViPhone());
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