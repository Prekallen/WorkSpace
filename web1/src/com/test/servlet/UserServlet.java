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
import com.test.service.UserLogin;
import com.test.service.UserSelect;
import com.test.service.UserService;
import com.test.service.UserUpdate;

public class UserServlet extends HttpServlet{


	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resq) throws IOException, ServletException{
		UserServlet u = new UserServlet();
		UserLogin ul = new UserLogin();
		UserService us = new UserService();
		UserDelete ud = new UserDelete();
		UserUpdate uu = new UserUpdate();
		UserSelect usl = new UserSelect();
		req.setCharacterEncoding("UTF-8");
		String command = req.getParameter("command");
		String userid = req.getParameter("userid");
		String userpwd = req.getParameter("userpwd");
		String username = req.getParameter("username");
		String address = req.getParameter("address");
		String usernum =req.getParameter("usernum");
		String age  = req.getParameter("age");
		String op = req.getParameter("op");
		HashMap hm = new HashMap();

		if(command.equals("INPUT")){
			System.out.println("input html에서 넘긴 값은 >> name : " + username + "\n\t password : " + userpwd);
		}
		if(command.equals("USERINFO")){

		}
		if(command.equals("CALC")){
			int num1 =Integer.parseInt(req.getParameter("num1"));
			int num2 =Integer.parseInt(req.getParameter("num2"));
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
			
			String hp1 = req.getParameter("hp1");
			String hp2 = req.getParameter("hp2");
			String hp3 = req.getParameter("hp3");
			hm.put("userid", userid);
			hm.put("userpwd", userpwd);
			hm.put("username", username);
			hm.put("address", address);
			hm.put("hp1", hp1);
			hm.put("hp2", hp2);
			hm.put("hp3", hp3);
			hm.put("age", age);

			if(us.insertUser(hm)){
				doProcess(resq, "입력이 잘 되었음");
			}else{
				doProcess(resq, "입력이 오류");
			}
		}else if(command.equals("LOGIN")){
			
			hm.put("userid",userid);
			hm.put("userpwd", userpwd);
			String result = ul.loginUser(hm);
			doProcess(resq,result);
			
					
		}else if(command.equals("DELETE")){
			System.out.println("삭제할 번호 : " + usernum);
			if(ud.deleteUser(usernum)){
				System.out.println("삭제 되었음");
				doProcess(resq, "삭제 되었음");
			}else{
				System.out.println("삭제 오류");
				doProcess(resq, "삭제 오류");
			}
		}
		else if(command.equals("UPDATE")){
			
			hm.put("userid", userid);
			hm.put("username", username);
			hm.put("address", address);
			hm.put("age", age);
			hm.put("usernum", usernum);

			if(uu.updateUser(hm)){
				System.out.println("수정이 잘 되었음");
				doProcess(resq, "수정이 잘 되었음");
			}else{
				System.out.println("수정이 오류");
				doProcess(resq, "수정이 오류");
			}
		}
		else if(command.equals("SELECT")){
			hm = new HashMap();
			if(username!=null&& !username.equals("")){
				hm.put("username","%" + username + "%");
			}
			List<Map> list= usl.selectUser(hm);
			String result = "번호)-:이름)-:아이디)-:나이)-:주소(-:";
			result+="dis)-:en)-:en)-:en)-:en(-:";
			for(Map m : list){
				result += m.get("usernum") + ")-:" + m.get("username") + ")-:" + m.get("userid") + ")-:" + m.get("age") +")-:" + m.get("address") + "(-:";
			}
			result = result.substring(0, result.length()-3);
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