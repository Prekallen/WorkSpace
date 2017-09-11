package com.iot1.sql.goods.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot1.sql.goods.dao.GoodsDao;
import com.iot1.sql.goods.dto.GoodsInfo;
@Service
public class GoodsServiceImpl implements GoodsService{
	
	@Autowired
	GoodsDao gd;
	
	@Override
	public List<GoodsInfo> getGoodsInfoList(GoodsInfo gi) {
		return gd.selectGoodsInfoList(gi);
	}
	

	@Override
	public int insertGoodsList(GoodsInfo[] gi) {
		int result=0;
		for(GoodsInfo goods : gi){
			result += gd.insertGoodsInfo(goods);
		}
		return result;
	}

	@Override
	public int updateGoodsInfo(GoodsInfo[] gi) {
		int result=0;
		for(GoodsInfo goods : gi){
			result += gd.updateGoodsInfo(goods);
		}
		return result;
	}

	@Override
	public int deleteGoodsInfo(GoodsInfo[] gi) {
		int result=0;
		for(GoodsInfo goods : gi){
			result+= gd.deleteGoodsInfo(goods);
		}
		return result;
	}

}
