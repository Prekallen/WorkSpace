package com.iot1.sql.vendor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot1.sql.vendor.dao.VendorDao;
import com.iot1.sql.vendor.dto.VendorInfo;

@Service
public class VendorServiceImpl implements VendorService{
	
	@Autowired
	VendorDao vd;
	
	@Override
	public VendorInfo getVendorInfo(VendorInfo vendor) {
		return vd.selectVendor(vendor);
	}

	@Override
	public List<VendorInfo> getVendorInfoList(VendorInfo vendor) {
		return vd.selectVendorList(vendor);
	}

}
