package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.test.dto.Goods;
import com.test.dto.Page;
import com.test.dto.Vendor;
import com.test.service.GoodsService;

public class GoodsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private GoodsService gs = new GoodsService();
	

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setCharacterEncoding("UTF-8");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");
		Gson g = new Gson();
//		Test hm =  g.fromJson(request.getReader(), Test.class);
//		String resultStr=g.toJson(hm);
//		System.out.println(resultStr);
//		doProcess(response, resultStr);
		
		Goods goods = g.fromJson(request.getReader(), Goods.class);	
		String command = goods.getCommand();
		Page page = goods.getPage();
		if(command.equals("list")){
			int totalCnt = gs.getTotalCount(goods);
			page.setTotalCnt(totalCnt);	
			List<Goods> list = gs.selectGoodsList(goods);
			List<Vendor> bList = gs.barList();
			HashMap lists = new HashMap();
			lists.put("page", page);
			lists.put("list", list);
			lists.put("bList", bList);
			lists.put("search", goods);
			
			String jsonStr = g.toJson(lists);
			doProcess(response,jsonStr);
		}else if (command.equals("view")){
			Goods resultGoods = gs.selectGoods(goods);
			HashMap resultList = new HashMap();
			resultList.put("page", page);
			resultList.put("goods", resultGoods);
			resultList.put("url", "/goods/goods_view.jsp");
			String jsonStr = g.toJson(resultList);
			doProcess(response,jsonStr);
		}else if(command.equals("delete")){
	    	int result = gs.deleteGoods(goods);
	    	HashMap resultList = new HashMap();
	    	resultList.put("page", page);
	    	resultList.put("msg", "삭제가 완료 되었습니다.");
	    	resultList.put("url", "/goods/goods_list.jsp");
	    	if(result!=1){
	    		resultList.put("msg", "삭제가 실패하였습니다.");
	    		resultList.put("url", "");
	    	}
	    	String jsonStr = g.toJson(resultList);
			doProcess(response,jsonStr);
		}else if(command.equals("update")){
			int result = gs.updateGoods(goods);
			List<Vendor> bList = gs.barList();
			HashMap resultList = new HashMap();
			resultList.put("page", page);
			resultList.put("bList",bList);
			resultList.put("search", goods);
			resultList.put("msg", "수정이 완료 되었습니다.");
			resultList.put("url", "/goods/goods_list.jsp");
			if(result!=1){
				resultList.put("msg", "수정이 실패하였습니다.");
	    		resultList.put("url", "");
			}
			String jsonStr = g.toJson(resultList);
			doProcess(response,jsonStr);
			
		}else if(command.equals("barList")){
			List<Vendor> bList = gs.barList();
			HashMap resultList = new HashMap();
			resultList.put("bList",bList);
			String jsonStr = g.toJson(resultList);
			doProcess(response,jsonStr);
		}
	}

	public void doProcess(HttpServletResponse response, String writeStr) throws IOException {
		response.setContentType("text/html; charset = UTF-8");
		PrintWriter out = response.getWriter();
		out.print(writeStr);

	}
}