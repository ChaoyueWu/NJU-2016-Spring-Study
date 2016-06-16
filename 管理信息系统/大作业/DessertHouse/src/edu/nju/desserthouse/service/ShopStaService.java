package edu.nju.desserthouse.service;

import edu.nju.desserthouse.model.stavo.ShopStaVO;

public interface ShopStaService {
//店铺销售管理
	//传入地区 和店铺id以及查询的时间统计类型，返回对应的店铺统计，当然还要加上店铺和地区列表
	public ShopStaVO getShopSta(int sid,int disid,int choice);
}
