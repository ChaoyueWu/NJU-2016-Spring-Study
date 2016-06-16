package edu.nju.desserthouse.service;

import java.util.List;

import edu.nju.desserthouse.model.stavo.AutoGeneratingPlanItem;

public interface PlanAutoGenerateService {
	//根据店铺 返回按要求获得的计划(包含所有商品-蛋糕除外——从星期一到星期天)
	//数组中的一个list表示一天的计划，list中的一个条目表示一个商品的计划
	public List<List<AutoGeneratingPlanItem>> getAutoGeneratingPlan(int sid,int range,int type);
}
