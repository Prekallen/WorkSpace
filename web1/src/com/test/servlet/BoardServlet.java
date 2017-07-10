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

public class BoardServlet extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resq, Object reg_date) throws IOException, ServletException{
		String lists = req.getParameter("list");
		req.setCharacterEncoding("UTF-8");
		BoardService bSv = new BoardService();
		BoardDelete bD = new BoardDelete();
		BoardUpdate bU = new BoardUpdate();
		BoardSelect bSl = new BoardSelect();
		String command = req.getParameter("command");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");
		String num = req.getParameter("num");

		
		HashMap hm = new HashMap();
		
		if(command.equals("INSERT")){
			
			hm.put("title",title);
			hm.put("content", content);
			hm.put("writer", writer);
			
			if(bSv.BoardInsert(hm)){
				System.out.println("입력이 잘 되었음");
				doProcess(resq, "입력이 잘 되	었음");
			}else{
				System.out.println("입력이 오류");
				doProcess(resq, "입력이 오류");
			}
			
		}
		else if(command.equals("DELETE")){
			System.out.println("삭제할 번호 : " + num);
			if(bD.boardDelete(num)){
				System.out.println("삭제 되었음");
				doProcess(resq, "삭제 되었음");
			}else{
				System.out.println("삭제 오류");
				doProcess(resq, "삭제 오류");
			}
		}
		else if(command.equals("UPDATE")){
			hm.put("num", num);
			hm.put("title", title);
			hm.put("content", content);
			hm.put("writer", writer);
			
			if(bU.boardUpdate(hm)){
				System.out.println("수정이 잘 되었음");
				doProcess(resq, "수정이 잘 되었음");
			}else{
				System.out.println("수정이 오류");
				doProcess(resq, "수정이 오류");
			}	
		}
		else if(command.equals("SELECT")){
			if(lists.equals("목록")){
			List<Map>list = bSl.boardSelect(hm);
			String result = "";
			for(Map m : list){
				result += m.toString();
				doProcess(resq, result);
			}
			}
		}
	}
	public void doPost(HttpServletRequest req, HttpServletResponse reqs) throws IOException{
		reqs.setContentType("text/html; charset = UTF-8");
		
	}

	
	public void doProcess(HttpServletResponse resq, String writeStr) throws IOException {
		resq.setContentType("text/html; charset = UTF-8");
		
		PrintWriter out = resq.getWriter();
		out.print(writeStr);
	
	}
}