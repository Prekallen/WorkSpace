package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.service.BoardDelete;
import com.test.service.BoardSelect;
import com.test.service.BoardService;
import com.test.service.BoardUpdate;

public class CalServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resq) throws IOException, ServletException {
		req.setCharacterEncoding("UTF-8");
		int num1= Integer.parseInt(req.getParameter("num1"));
		int num2= Integer.parseInt(req.getParameter("num2"));
		String op= req.getParameter("op");
		int result=0;
		if(op.equals("+")){
			result = num1+num2;
		}else if(op.equals("-")){
			result = num1-num2;
		}else if(op.equals("*")){
			result = num1*num2;
		}else if(op.equals("/")){
			result = num1/num2;
		}
		
		doProcess(resq, ""+result);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse reqs) throws IOException {
		reqs.setContentType("text/html; charset = UTF-8");

	}

	public void doProcess(HttpServletResponse resq, String writeStr) throws IOException {
		resq.setContentType("text/html; charset = UTF-8");

		PrintWriter out = resq.getWriter();
		out.print(writeStr);

	}
}