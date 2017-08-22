package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.dto.Vendor;
import com.test.service.ServiceFactory;
import com.test.service.VendorService;

public class VendorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private VendorService vs; 	

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setCharacterEncoding("UTF-8");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");
		vs = ServiceFactory.getVendorService();
		String command = request.getParameter("command");
		String viName= request.getParameter("viName");
		String viDesc= request.getParameter("viDesc");
		String viAddress= request.getParameter("viAddress");
		String viPhone= request.getParameter("viPhone");
		String resultStr="";
		
		if(command.equals("list")){
			resultStr="";
			List<Vendor> vendorList = vs.selectVendorList(viName);
	    	for(Vendor v : vendorList){
	    		resultStr += "<tr id='" + v.getViNum() + "' style='cursor:pointer'>";
	    		resultStr += "<td>" + v.getViNum() + "</td>";
	    		resultStr += "<td>" + v.getViName() + "</td>";
	    		resultStr += "<td>" + v.getViDesc() + "</td>";
	    		resultStr += "<td>" + v.getViAddress() + "</td>";
	    		resultStr += "<td>" + v.getViPhone() + "</td>";
	    		resultStr += "<td>" + v.getViCreDat() + "</td>";
	    		resultStr += "<td>" + v.getViCreTim() + "</td>";
	    		resultStr += "</tr>";
	    	}
		
		}else if (command.equals("view")){
			resultStr="";
			int viNum = Integer.parseInt(request.getParameter("viNum"));
			Vendor vendor = vs.selectVendor(viNum);
			resultStr += "?viNum=" + vendor.getViNum();
    		resultStr += "&viName=" + vendor.getViName();
    		resultStr += "&viDesc=" + vendor.getViDesc();
    		resultStr += "&viAddress=" + vendor.getViAddress();
    		resultStr += "&viPhone=" + vendor.getViPhone();
    		resultStr += "&viCreDat=" + vendor.getViCreDat();
    		resultStr += "&viCreTim=" + vendor.getViCreTim();
    		
		}else if(command.equals("delete")){
			resultStr="";
			int viNum = Integer.parseInt(request.getParameter("viNum"));
			Vendor vendor =new Vendor();
			vendor.setViNum(viNum);
			int result = vs.deleteVendor(vendor);
			if(result!=1){
				resultStr="삭제를 실패하였습니다.";
			}else{
				resultStr="삭제 되었습니다.";
			}
		}else if(command.equals("update")){
			resultStr="";
			int viNum = Integer.parseInt(request.getParameter("viNum"));
			Vendor vendor =new Vendor();
			vendor.setViNum(viNum);
			vendor.setViName(viName);
			vendor.setViDesc(viDesc);
			vendor.setViAddress(viAddress);
			vendor.setViPhone(viPhone);
			resultStr += "?viNum=" + vendor.getViNum();
    		int result= vs.updateVendor(vendor);
			if(result!=1){
				resultStr="수정을 실패하였습니다.";
			}else{
				resultStr="수정 되었습니다.";
			}
		}else if(command.equals("insert")){
			resultStr="";
			Vendor vendor =new Vendor();
			vendor.setViName(viName);
			vendor.setViDesc(viDesc);
			vendor.setViAddress(viAddress);
			vendor.setViPhone(viPhone);
			int result = vs.insertVendor(vendor);
			if(result!=1){
				resultStr="등록을 실패하였습니다.";
			}else{
				resultStr="등록 되었습니다.";
			}
		}	
		doProcess(response, resultStr);
	}

	public void doProcess(HttpServletResponse response, String writeStr) throws IOException {
		response.setContentType("text/html; charset = UTF-8");
		PrintWriter out = response.getWriter();
		out.print(writeStr);

	}
}