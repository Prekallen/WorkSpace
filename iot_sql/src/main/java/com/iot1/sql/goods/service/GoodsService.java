package com.iot1.sql.goods.service;

import java.util.List;

import org.springframework.ui.ModelMap;

import com.iot1.sql.goods.dto.GoodsInfo;

public interface GoodsService {
	
	public List<GoodsInfo> getGoodsInfoList(GoodsInfo gi);

	public int insertGoodsList(GoodsInfo[] gi);
	
	public int updateGoodsInfo(GoodsInfo[] gi);
	
	public int deleteGoodsInfo(GoodsInfo[] gi);
}
