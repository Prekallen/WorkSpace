package com.test.service;

import java.util.List;

import com.test.dto.Vendor;

public interface VendorService {
	public List<Vendor> selectVendorList(String viName);
	public Vendor selectVendor(int viNum);
	public int deleteVendor(Vendor vendor);
	public int updateVendor(Vendor vendor);
	public int insertVendor(Vendor vendor);
}
