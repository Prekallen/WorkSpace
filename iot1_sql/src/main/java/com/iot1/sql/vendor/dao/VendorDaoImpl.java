package com.iot1.sql.vendor.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.iot1.sql.vendor.dto.VendorInfo;
@Repository
public class VendorDaoImpl extends SqlSessionDaoSupport implements VendorDao{
	
	@Override
	public List<VendorInfo> selectVendorInfoCombo() {
		return this.getSqlSession().selectList("vendor.SELECT_VENDOR_COMBO");
	}

	@Override
	public List<VendorInfo> selectVendor(VendorInfo[] vi) {
		return this.getSqlSession().selectList("vendor.SELECT_VENDOR",vi);
	}

	@Override
	public List<VendorInfo> selectVendorList(VendorInfo vi) {
		return this.getSqlSession().selectList("vendor.SELECT_VENDOR",vi);
	}

	@Override
	public int insertVendor(VendorInfo vi) {
		return this.getSqlSession().insert("vendor.INSERT_VENDOR", vi);
	}

	@Override
	public int updateVendor(VendorInfo vi) {
		return this.getSqlSession().update("vendor.UPDATE_VENDOR",vi);
		
	}

	@Override
	public int deleteVendor(VendorInfo vi) {
		return this.getSqlSession().delete("vendor.DELETE_VENDOR",vi);
	}

	

}
