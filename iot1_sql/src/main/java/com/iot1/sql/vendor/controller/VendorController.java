package com.iot1.sql.vendor.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iot1.sql.vendor.dto.VendorInfo;
import com.iot1.sql.vendor.service.VendorService;

@Controller
public class VendorController {
	@Autowired
	VendorService vs;
	
	@RequestMapping(value="/vendor/list", method=RequestMethod.POST)
	public @ResponseBody List<VendorInfo> getVendorInfoList(VendorInfo vendor){
	return vs.getVendorInfoList(vendor);	
	}
	
	@RequestMapping(value="/vendor/create", method=RequestMethod.POST)
	public @ResponseBody List<VendorInfo> saveVendorInfoList(HttpSession hs,@RequestBody VendorInfo[] vendorList){
		int rCnt = vs.insertVendor(vendorList);
		return vs.getVendorInfoList(null);	
	}
}

