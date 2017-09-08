package com.iot1.sql.vendor.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@RequestMapping(value="/vendor/combo",method=RequestMethod.GET)
	public String getVendorInfoCombo(Model model){
        List<VendorInfo> viList = vs.getVendorInfoCombo();
        
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>(); 
        
        for (VendorInfo vi : viList) {
        	Map<String, Object> hm = new HashMap<String, Object>();
        	hm.put("value", vi.getViNum());
        	hm.put("text", vi.getViName());
            result.add(hm);
        }
        
        model.addAttribute("vendors", result);
        return "goods/goods_list";
	}
	
	@RequestMapping(value="/vendor/list", method=RequestMethod.POST)
	public @ResponseBody List<VendorInfo> getVendorInfoList(VendorInfo vendor){
	return vs.getVendorInfoList(vendor);	
	}
	
	@RequestMapping(value="/vendor/create", method=RequestMethod.POST)
	public @ResponseBody List<VendorInfo> saveVendorInfoList(@RequestBody VendorInfo[] vendorList, VendorInfo vi){
			vs.insertVendor(vendorList);
		return vs.getVendorInfoList(vi);	
	}
	
	
}

