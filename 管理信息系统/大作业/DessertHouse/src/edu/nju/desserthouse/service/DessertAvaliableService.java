package edu.nju.desserthouse.service;

import java.sql.Date;

import edu.nju.desserthouse.model.DessertAvailableBranchVO;
import edu.nju.desserthouse.model.DessertAvailableVO;

public interface DessertAvaliableService {
	/*
	 * 在计划批准之后 创建对应的某商店 每天每种商品的信息
	 */
	public void createAvaliableDeesert(int pid);
	/*
	 * 会员在线订购时 获取可卖的商品信息
	 * 可选择的店铺数组
	 * 可选择的店铺对应的可选择的日期
	 * 确定店铺和日期后对应的商品列表
	 */
	public DessertAvailableVO getMemberBuyDesserts();
	/*
	 * 在顾客购买某商品后，减少其数量
	 */
	public void sellAvaliableDessert(int daid,int amount);
	/*
	 * 根据分店服务员的id获得其所在商店的每日可销售商品
	 */
	public DessertAvailableBranchVO getBranchSaleDesserts(int scid);
	/*
	 * 在取消订单后，对应加上某店某天某商品的数量
	 */
	public void modifyDessertAvailableAfterCancel(int sid,Date date,int did,int amount);
	
	//get列表时 注意将表中的时间和当前时间进行比较，只显示比当前时间一样or晚的
	/////
	/////但是在销售的时候 销售表要get sid did takeDate amount price 会员信息 优惠信息
	//在会员在线购买商品时 显示每个店有货的每一天的商品信息列表
	
	//销售员选择售货时，向action传销售员的所在sid get这个sid每天可售的商品信息列表
	
//在买东西的时候 一次卖一种商品 对应减去商品的个数 
	//在销售的时候 直接get daid好了 这样就可直接修改amount
}
