package com.iot1.sql.vendor.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.iot1.sql.vendor.dto.VendorInfo;
@Repository
public class VendorDaoImpl extends SqlSessionDaoSupport implements VendorDao{

	@Override
	public VendorInfo selectVendor(VendorInfo vendor) {
		return this.getSqlSession().selectOne("vendor.SELECT_VENDOR",vendor);
	}

	@Override
	public List<VendorInfo> selectVendorList(VendorInfo vendor) {
		return this.getSqlSession().selectList("vendor.SELECT_VENDOR",vendor);
	}
	

}
