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

import com.test.dto.BoardInfo;
import com.test.dto.UserInfo;
import com.test.service.BoardDelete;
import com.test.service.BoardSelect;
import com.test.service.BoardService;
import com.test.service.BoardUpdate;

public class BoardServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resq)
			throws IOException, ServletException {

		req.setCharacterEncoding("UTF-8");
		BoardService bSv = new BoardService();
		BoardDelete bD = new BoardDelete();
		BoardUpdate bU = new BoardUpdate();
		BoardSelect bSl = new BoardSelect();
		BoardInfo bI = new BoardInfo();
		String command = req.getParameter("command");
		String bITitle = req.getParameter("bITitle");
		String bIContent = req.getParameter("bIContent");
		String bIPwd = req.getParameter("bIPwd");
		String creUsr = req.getParameter("creUsr");
		String bINum = req.getParameter("bINum");
		String lists = req.getParameter("list");

		HashMap hm = new HashMap();

		if (command.equals("INSERT")) {

			bI.setBITitle(bITitle);
			bI.setBIContent(bIContent);
			bI.setBIPwd(bIPwd);
			bI.setCreUsr(creUsr);
			
			if (bSv.BoardInsert(bI)) {
				System.out.println("입력이 잘 되었음");
				doProcess(resq, "입력이 잘 되	었음");
			} else {
				System.out.println("입력이 오류");
				doProcess(resq, "입력이 오류");
			}

		} else if (command.equals("DELETE")) {
			System.out.println("삭제할 번호 : " + bINum);
			if (bD.boardDelete(bINum)) {
				System.out.println("삭제 되었음");
				doProcess(resq, "삭제 되었음");
			} else {
				System.out.println("삭제 오류");
				doProcess(resq, "삭제 오류");
			}
		} else if (command.equals("UPDATE")) {
			bI.setBINum(Integer.parseInt(bINum));
			bI.setBITitle(bITitle);
			bI.setBIContent(bIContent);
			bI.setCreUsr(creUsr);
			bI.setBIPwd(bIPwd);

			if (bU.boardUpdate(bI)) {
				System.out.println("수정이 잘 되었음");
				doProcess(resq, "수정이 잘 되었음");
			} else {
				System.out.println("수정이 오류");
				doProcess(resq, "수정이 오류");
			}
		} else if (command.equals("SELECT")) {
			if (lists.equals("목록")) {
				List<BoardInfo> list = bSl.boardSelect(bI);
				String result = "번호)-:제목)-:내용)-:비밀번호)-:사용자)-:날짜(-:";
				result+="dis)-:en)-:en)-:en)-:en)-:en(-:";
				for(BoardInfo bIS : list){
					result += bIS.getBINum() + ")-:" + bIS.getBITitle() + ")-:" + bIS.getBIContent() + ")-:" + bIS.getBIPwd() + ")-:" + bIS.getCreUsr() + ")-:" + bIS.getCreDat() + "(-:";
				}
				result = result.substring(0, result.length()-3);
				doProcess(resq, result);
			}
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