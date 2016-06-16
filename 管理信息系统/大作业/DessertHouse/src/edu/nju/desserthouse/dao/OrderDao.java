package edu.nju.desserthouse.dao;

import java.util.HashMap;
import java.util.List;

import edu.nju.desserthouse.model.stavo.AutoGeneratingPlanItem;
import edu.nju.desserthouse.model.stavo.CategoryOnlyStaVO;
import edu.nju.desserthouse.model.stavo.CateoryProductStaVO;
import edu.nju.desserthouse.model.stavo.DisProductStaVO;
import edu.nju.desserthouse.model.stavo.DistrictYearRankVO;
import edu.nju.desserthouse.model.stavo.InValidAnalysis;
import edu.nju.desserthouse.model.stavo.ProductSalesStaVO;
import edu.nju.desserthouse.model.stavo.ProductTrendItemVO;
import edu.nju.desserthouse.model.stavo.ShopProductStaVO;
import edu.nju.desserthouse.model.stavo.ShopStaItemVO;
import edu.nju.desserthouse.model.stavo.ShopYearRankItemVO;

public interface OrderDao {
	// 大坑 所有关于销售的查询和记录都在这里吧
	public List<ProductSalesStaVO> getProductSalesStaVOList();

	// 所有地区总计
	public List<DisProductStaVO> getTotalDisProductStaVOList();

	// 每个地区总计
	public HashMap<String, List<DisProductStaVO>> getDisProSta();

	// 每个店铺总计
	public List<ShopProductStaVO> getShopProductStaVOList();

	// 关于商品分类统计的那些方法
	public List<CategoryOnlyStaVO> getCategoryOnlyStaVOList();

	public List<CateoryProductStaVO> getCateoryProductStaVOList();

	public List<CategoryOnlyStaVO> getCategoryOnlyStaVOList(int disid);

	public List<CateoryProductStaVO> getCateoryProductStaVOList(int disid);

	public List<CategoryOnlyStaVO> getCategoryOnlyStaVOList(int disid, int sid);

	public List<CateoryProductStaVO> getCateoryProductStaVOList(int disid, int sid);

	// 关于店铺统计的方法
	// 天统计
	public List<ShopStaItemVO> getDayShopStaItemVOList();// 所有地区 天统计

	public List<ShopStaItemVO> getDayShopStaItemVOList(int disid);// 具体某地区 天统计

	public List<ShopStaItemVO> getDayShopStaItemVOList(int disid, int sid);// 具体某店铺
																			// 天统计
	// 月统计

	public List<ShopStaItemVO> getMonthShopStaItemVOList();// 所有地区 月统计

	public List<ShopStaItemVO> getMonthShopStaItemVOList(int disid);// 具体某地区 月统计

	public List<ShopStaItemVO> getMonthShopStaItemVOList(int disid, int sid);// 具体某店铺
																				// 月统计
	// 流失订单分析

	public InValidAnalysis getInvalidOrderAnalysis();// 所有地区

	public InValidAnalysis getInvalidOrderAnalysis(int disid);// 具体某地区

	public InValidAnalysis getInvalidOrderAnalysis(int disid, int sid);// 具体某店铺
	// 关于某商品的统计信息

	public List<ProductTrendItemVO> getProductTrendItemVOList(int did);// 所有地区
																		// 天统计

	public List<ProductTrendItemVO> getProductTrendItemVOList(int did, int disid);// 某地区
																					// 天统计

	public List<ProductTrendItemVO> getProductTrendItemVOList(int did, int disid, int sid);// 某店铺
																							// 天统计
	// 区域店铺排行
	// 店铺 今年 排行

	public List<ShopYearRankItemVO> getShopYearRank();

	// 地区今年排行
	public List<DistrictYearRankVO> getDistrictYearRank();

	// 自动生成计划
	// 近一月。乐观和悲观就是排序一个desc 一个asc 传入当前月份
	public List<List<AutoGeneratingPlanItem>> getMonthExtreamAutoGeneratingPlan(int sid, int month, String orderType);

	// 近一月，保守
	public List<List<AutoGeneratingPlanItem>> getMonthExtreamAutoGeneratingPlan(int sid, int month);

	// 近一年。乐观和悲观就是排序一个desc 一个asc 
	public List<List<AutoGeneratingPlanItem>> getYearExtreamAutoGeneratingPlan(int sid, String orderType);

	// 近一年，保守
	public List<List<AutoGeneratingPlanItem>> getYearExtreamAutoGeneratingPlan(int sid);
}
