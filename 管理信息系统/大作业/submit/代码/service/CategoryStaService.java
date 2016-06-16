package edu.nju.desserthouse.service;

import edu.nju.desserthouse.model.stavo.CategoryStaVO;

public interface CategoryStaService {
//传入地区 和店铺id，返回对应的商品分类统计和按商品分类分组的商品统计，当然还要加上店铺和地区列表
	public CategoryStaVO getCategorySta(int sid,int disid);
}
