package com.iot1.sql.vendor.service;

import java.util.List;

import com.iot1.sql.vendor.dto.VendorInfo;

public interface VendorService {
	
	public List<VendorInfo>getVendorInfoCombo();
	
	public List<VendorInfo> getVendorInfo(VendorInfo[] vi);
	
	public List<VendorInfo> getVendorInfoList(VendorInfo vi);
	
	public int insertVendor(VendorInfo[] vi);
	
	public int updateVendor(VendorInfo[] vi);
	
	public int deleteVendor(VendorInfo[] vi);
	
}
