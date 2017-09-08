package com.iot1.sql.vendor.service;

import java.util.List;

import com.iot1.sql.vendor.dto.VendorInfo;

public interface VendorService {
	
	public List<VendorInfo>getVendorInfoCombo();
	
	public VendorInfo getVendorInfo(VendorInfo gi);
	
	public List<VendorInfo> getVendorInfoList(VendorInfo gi);
	
	public int insertVendor(VendorInfo[] vi);
	
	
}
