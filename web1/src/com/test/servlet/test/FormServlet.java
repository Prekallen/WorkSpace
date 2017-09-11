package com.test.servlet.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormServlet extends CommonServlet{
	String id="";
	String pwd="";
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setCharacterEncoding("UTF-8");
		id = request.getParameter("id");
		pwd = request.getParameter("pwd");
		String result = "이것은 Get 방식으로 받아온 ID :" + id + "PWD : " + pwd + " 입니다.";
		doProcess(response,result);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");
		HashMap hm = g.fromJson(request.getReader(), HashMap.class);
		List al = new ArrayList();
		al.add(hm.get("id"));
		al.add(hm.get("pwd"));
		String result = g.toJson(al);
		doProcess(response, result);
	}
}
