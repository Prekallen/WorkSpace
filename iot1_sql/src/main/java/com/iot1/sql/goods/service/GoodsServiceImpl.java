package com.iot1.sql.goods.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.iot1.sql.goods.dao.GoodsDao;
import com.iot1.sql.goods.dto.GoodsInfo;
@Service
public class GoodsServiceImpl implements GoodsService{
	
	@Autowired
	GoodsDao gd;
	
	@Override
	public GoodsInfo getGoodsInfo(GoodsInfo gi) {
		return gd.selectGoodsInfo(gi);
	}

	@Override
	public List<GoodsInfo> getGoodsInfoList(GoodsInfo gi) {
		return gd.selectGoodsInfoList(gi);
	}

	@Override
	public int insertGoods(GoodsInfo[] gi) {
		int rCnt= 0;
		for(GoodsInfo goods : gi){
			rCnt=gd.insertGoods(goods);
		}
		return rCnt;
	}

	@Override
	public List<GoodsInfo> insertGoodsList(GoodsInfo[] gi) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateGoods(GoodsInfo[] gi) {
		int rCnt= 0;
		for(GoodsInfo goods : gi){
			rCnt=gd.updateGoods(goods);
		}
		return rCnt;
	}

	@Override
	public int deleteGoods(GoodsInfo gi) {
		return gd.deleteGoods(gi);
	}

}
