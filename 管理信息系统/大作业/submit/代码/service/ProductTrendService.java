package edu.nju.desserthouse.service;

import edu.nju.desserthouse.model.stavo.ProductTrendVO;

public interface ProductTrendService {
	//传入地区 、店铺、商品id，返回对应的商品统计，当然还要加上店铺、地区、商品列表
	public ProductTrendVO getProductTrend(int sid,int disid,int did);
}
