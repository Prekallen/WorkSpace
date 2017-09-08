package com.iot1.sql.goods.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iot1.sql.goods.dto.GoodsInfo;
import com.iot1.sql.goods.service.GoodsService;

@Controller
public class GoodsController {
	@Autowired
	GoodsService gs;
	
	@RequestMapping(value="/goods/list", method=RequestMethod.POST)
	public @ResponseBody List<GoodsInfo> getGoodsInfoList(GoodsInfo gi){
		return gs.getGoodsInfoList(gi);	
	}
	
	@RequestMapping(value="/goods/create", method=RequestMethod.POST)
	public @ResponseBody List<GoodsInfo> saveGoodsInfoList(@RequestBody GoodsInfo[] goodsList, GoodsInfo gi){
			gs.insertGoodsList(goodsList);
		return gs.getGoodsInfoList(gi);
	}
	@RequestMapping(value="/goods/update", method=RequestMethod.POST)
	public @ResponseBody List<GoodsInfo> updateGoodsInfoList(@RequestBody GoodsInfo[] goodsList, GoodsInfo gi){
			gs.updateGoodsInfo(goodsList);
		return gs.getGoodsInfoList(gi);
	}
	@RequestMapping(value="/goods/delete", method=RequestMethod.POST)
	public @ResponseBody List<GoodsInfo> deleteGoodsInfoList(@RequestBody GoodsInfo[] goodsList, GoodsInfo gi){
			gs.deleteGoodsInfo(goodsList);
		return gs.getGoodsInfoList(gi);
	}
	@RequestMapping(value="/goods/vlist", method=RequestMethod.POST)
	public @ResponseBody List<GoodsInfo> getvGoodsInfoList(GoodsInfo gi){
		return gs.getGoodsInfoList(gi);
	}
	
}
