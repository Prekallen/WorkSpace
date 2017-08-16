package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.dto.Vendor;
import com.test.service.GoodsService;
import com.test.service.VendorService;

public class VendorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private VendorService vs = new VendorService();
	

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setCharacterEncoding("UTF-8");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");
		String command = request.getParameter("command");
		String resultStr="";
		if(command.equals("list")){
			String viName = request.getParameter("viName");
			List<Vendor> vendorList = vs.selectVendorList(viName);
	    	for(Vendor v : vendorList){
	    		resultStr += "<tr>";
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
			
		}else if(command.equals("delete")){
	    	
		}else if(command.equals("update")){
			
		}else if(command.equals("insert")){
			
		}	
		doProcess(response, resultStr);
	}

	public void doProcess(HttpServletResponse response, String writeStr) throws IOException {
		response.setContentType("text/html; charset = UTF-8");
		PrintWriter out = response.getWriter();
		out.print(writeStr);

	}
}