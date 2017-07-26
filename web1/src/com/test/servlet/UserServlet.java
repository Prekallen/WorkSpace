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

import com.test.dto.UserInfo;
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
		String userId = req.getParameter("userid");
		String userPwd = req.getParameter("userpwd");
		String userName = req.getParameter("username");
		String address = req.getParameter("address");
		String userNum =req.getParameter("usernum");
		String age  = req.getParameter("age");
		String hp1 = req.getParameter("hp1");
		String hp2 = req.getParameter("hp2");
		String hp3 = req.getParameter("hp3");
		String op = req.getParameter("op");
		UserInfo ui = new UserInfo();
		

		if(command.equals("INPUT")){
			System.out.println("input html에서 넘긴 값은 >> name : " + userName + "\n\t password : " + userPwd);
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
			
			ui.setUserId(userId);
			ui.setUserPwd(userPwd);
			ui.setUserName(userName);
			ui.setAge(Integer.parseInt(age));
			ui.setAddress(address);
			ui.setHp1(hp1);
			ui.setHp2(hp2);
			ui.setHp3(hp3);
			
			if(us.insertUser(ui)){
				doProcess(resq, "입력이 잘 되었음");
			}else{
				doProcess(resq, "입력이 오류");
			}
		}else if(command.equals("LOGIN")){
			
			ui.setUserId(userId);
			ui.setUserPwd(userPwd);
			String result = ul.loginUser(ui);
			doProcess(resq,result);
			
					
		}else if(command.equals("DELETE")){
			System.out.println("삭제할 번호 : " + userNum);
			if(ud.deleteUser(userNum)){
				System.out.println("삭제 되었음");
				doProcess(resq, "삭제 되었음");
			}else{
				System.out.println("삭제 오류");
				doProcess(resq, "삭제 오류");
			}
		}
		else if (command.equals("UPDATE")) {
			ui.setUserId(userId);
			ui.setUserName(userName);
			ui.setUserNum(Integer.parseInt(userNum));
			ui.setAge(Integer.parseInt(age));
			ui.setAddress(address);
			boolean isUpdate = uu.updateUser(ui);
			String result = "";
			if(isUpdate){
				result = "수정 됨";
			}else{
				result = "수정 안됨";
			}
			doProcess(resq, result);
		}
		else if(command.equals("SELECT")){
			
			if(userName!=null&& !userName.equals("")){
				ui.setUserName("%" + userName + "%");
			}
			List<UserInfo> list= usl.selectUser(ui);
			String result = "번호)-:이름)-:아이디)-:나이)-:주소(-:";
			result+="dis)-:en)-:en)-:en)-:en(-:";
			for(UserInfo usi : list){
				result += usi.getUserNum() + ")-:" + usi.getUserName() + ")-:" + usi.getUserId() + ")-:" + usi.getAge() +")-:" + usi.getAddress() + "(-:";
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