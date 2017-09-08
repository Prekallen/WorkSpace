package com.iot1.sql.vendor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot1.sql.user.dao.dto.UserInfo;
import com.iot1.sql.vendor.dao.VendorDao;
import com.iot1.sql.vendor.dto.VendorInfo;

@Service
public class VendorServiceImpl implements VendorService{
	
	@Autowired
	VendorDao vd;
	
	@Override
	public List<VendorInfo> getVendorInfoCombo() {
		return vd.selectVendorInfoCombo();
	}
	
	@Override
	public VendorInfo getVendorInfo(VendorInfo vi) {
		return vd.selectVendor(vi);
	}

	@Override
	public List<VendorInfo> getVendorInfoList(VendorInfo vi) {
		return vd.selectVendorList(vi);
	}

	@Override
	public int insertVendor(VendorInfo[] vi) {
		int rCnt = 0;
		for(VendorInfo vendor : vi){
			rCnt += vd.insertVendor(vendor);
		}
		return rCnt;
	}

}
