package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.service.UserDelete;
import com.test.service.UserSelect;
import com.test.service.UserService;
import com.test.service.UserUpdate;

public class UserServlet extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resq) throws IOException, ServletException{
		UserServlet u = new UserServlet();
		UserService us = new UserService();
		UserDelete ud = new UserDelete();
		UserUpdate uu = new UserUpdate();
		UserSelect usl = new UserSelect();
		req.setCharacterEncoding("UTF-8");
		String command = req.getParameter("command");
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		String class_num = req.getParameter("class_num");
		String age = req.getParameter("age");
		String num =req.getParameter("user_num");
		int num1 =Integer.parseInt(req.getParameter("num1"));
		int num2 =Integer.parseInt(req.getParameter("num2"));
		
		String op = req.getParameter("op");
		HashMap hm = new HashMap();
		
		if(command.equals("INPUT")){
			System.out.println("input html에서 넘긴 값은 >> name : " + name + "\n\t password : " + pwd);
		}
		if(command.equals("USERINFO")){
			
		}
		if(command.equals("CALC")){
			if(op.equals("+")){
				System.out.println(num1 + " + " + num2 + " = " + (num1+num2));
			}else if(op.equals("-")){
				System.out.println(num1 + " - " + num2 + " = " + (num1-num2));
			}else if(op.equals("*")){
				System.out.println(num1 + " * " + num2 + " = " + (num1*num2));
			}else if(op.equals("/")){
				System.out.println(num1 + " / " + num2 + " = " + (num1/num2));
			}
			
		}
		if(command.equals("SIGNIN")){
		
		hm.put("id", id);
		hm.put("pwd", pwd);
		hm.put("name", name);
		hm.put("class_num", class_num);
		hm.put("age", age);
		
		if(us.insertUser(hm)){
			System.out.println("입력이 잘 되었음");
			doProcess(resq, "입력이 잘 되었음");
		}else{
			System.out.println("입력이 오류");
			doProcess(resq, "입력이 오류");
		}
		}else if(command.equals("DELETE")){
			String user_num = req.getParameter("user_num");
			System.out.println("삭제할 번호 : " + user_num);
			if(ud.deleteUser(user_num)){
				System.out.println("삭제 되었음");
				doProcess(resq, "삭제 되었음");
			}else{
				System.out.println("삭제 오류");
				doProcess(resq, "삭제 오류");
			}
		}
		else if(command.equals("UPDATE")){
			
			hm.put("name", name);
			hm.put("class_num", class_num);
			hm.put("age", age);
			hm.put("num", num);
			
			if(uu.updateUser(hm)){
				System.out.println("수정이 잘 되었음");
				doProcess(resq, "수정이 잘 되었음");
			}else{
				System.out.println("수정이 오류");
				doProcess(resq, "수정이 오류");
			}
		}
		else if(command.equals("SELECT")){
			System.out.println("이름 : " + name);
			hm = new HashMap();
			if(name!=null&&!name.equals("")){
				hm.put("name","%" + name + "%");
			}
			List<Map> list= usl.selectUser(hm);
			String result = "";
			for(Map m : list){
				result += m.toString();
			}
			doProcess(resq, result);
		}
	}
	public void dePost(HttpServletRequest req, HttpServletResponse reqs) throws IOException{
		
	}

	
	public void doProcess(HttpServletResponse resq, String writeStr) throws IOException {
		resq.setContentType("text/html; charset = UTF-8");
		PrintWriter out = resq.getWriter();
		out.print(writeStr);
		
	}
}