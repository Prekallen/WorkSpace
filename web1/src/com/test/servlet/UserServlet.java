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
			String age  = req.getParameter("age");
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
			doProcess(resq,ul.LoginUser(hm));
			if(ul.LoginUser(hm).equals("로그인")){
				doProcess(resq, "location.href=/user/select_user.html");
			}
					
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
			String age  = req.getParameter("age");
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
			System.out.println("이름 : " + username);
			hm = new HashMap();
			if(username!=null&& !username.equals("")){
				hm.put("name","%" + username + "%");
			}
			List<Map> list= usl.selectUser(hm);
			String result = "<script>";
			result +="function deleteUser(userNum){";
			result +="location.href='delete.user?command=DELETE&num=' + userNum;";
			result +="}";
			result +="function updateUser(){";
			result	+="location.href='/update.user?command=UPDATE';}";
			result +="</script>";
			result += "<form action='/test_web/sign.user'>";
			result += "이름 : <input type='text' name='username' id='username'/><input type='submit' value='검색'/>";
			result += "<input type='hidden' name='command' id='command' value='SELECT'/>";
			result += "<table border='1'>";
			result += "<tr>";
			result += "<td>번호</td>";
			result += "<td>ID</td>";
			result += "<td>이름</td>";
			result += "<td>나이</td>";
			result += "<td>클래스</td>";
			result += "<td>삭제버튼</td>";
			result +="</tr>";
			for(Map m : list){
				result += "<tr align='center'>";
				result += "<td>"+m.get("usernum")+"</td>";
				result += "<td>"+m.get("userid")+"</td>";
				result += "<td>"+m.get("username")+"</td>";
				result += "<td>"+m.get("age")+"</td>";
				result += "<td>"+m.get("address")+"</td>";
				result += "<td><input type='button' value='삭제' onclick='deleteUser("+m.get("usernum")+")'/></td>";
				result +="</tr>";
			}
			result +="</table></br>";
			result +="테이블 값 업데이트<br/>";
			result += "<table border='1'>";
			result += "<tr>";
			result += "<td>변경할 번호</td>";
			result += "<td>ID</td>";
			result += "<td>이름</td>";
			result += "<td>나이</td>";
			result += "<td>클래스</td>";
			result +="</tr>";
			result += "<tr>";
			result += "<td><input type='text' name='usernum' id='usernum'/></td>";
			result += "<td><input type='text' name='userid' id='userid'/></td>";
			result += "<td><input type='text' name='username' id='username'/></td>";
			result += "<td><input type='text' name='age' id='age'/></td>";
			result += "<td><input type='text' name='address' id='address'/></td>";
			result +="</tr>";
			result +="</table>";
			result +="<input type='reset' name='r_btn' value='리셋'/>";
			result +="<input type='button' name='s_btn' value='업데이트'onclick='updateUser()'/>";
			result += "</form>";
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