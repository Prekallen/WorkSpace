package com.iot1.sql.vendor.dao;

import java.util.List;

import com.iot1.sql.vendor.dto.VendorInfo;

public interface VendorDao {
	
	public VendorInfo selectVendor(VendorInfo vi);
	
	public List<VendorInfo> selectVendorList(VendorInfo vi);
	
	public int insertVendor(VendorInfo vi);
}
