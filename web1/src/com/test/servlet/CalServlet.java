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
		int result=0;
		try{
		int num1= Integer.parseInt(req.getParameter("num1"));
		int num2= Integer.parseInt(req.getParameter("num2"));
		String op= req.getParameter("op");

		if(op.equals("+")){
			result = num1+num2;
			op="더하기";
		}else if(op.equals("-")){
			result = num1-num2;
			op="빼기";
		}else if(op.equals("*")){
			result = num1*num2;
			op="곱하기";
		}else if(op.equals("/")){
			result = num1/num2;
			op="나누기";
		}
		String tableSet="<script>";
		tableSet +="function backCal(){";
		tableSet +="location.href='/cal/cal.html';}";
		tableSet +="</script>";
		tableSet +="<form action='/web1/.cal'>";
		tableSet +="<table border='1'>";
		tableSet +="<tr>";
		tableSet +="<td colspan='2'>" +	 num1 +" "+ op +" "+ num2 + "</td>" ;
		tableSet +="</tr>";
		tableSet +="<tr>";
		tableSet +="<td>결과값</td>";
		tableSet  +="<td>" + result + "</td>";
		tableSet +="</tr>";
		tableSet +="</table><br/>";
		tableSet +="<input type=button value='돌아가기'onclick='backCal()'/>";
		tableSet +="</form>";
		
		
		doProcess(resq, tableSet);
		}catch(Exception e){
			e.printStackTrace();
			doProcess(resq, "숫자를 넣으시라고요");
		}
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