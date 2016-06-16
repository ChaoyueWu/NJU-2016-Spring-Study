package edu.nju.desserthouse.dao;

import java.util.List;

import edu.nju.desserthouse.model.PlanList;

public interface PlanListDao {
	/*
	 * 像数据库中插入一条PlanList记录
	 */
	public void save(PlanList planList);
	
	/*
	 * 根据id查找PlanList对象,如果找到则返回这个对象,否则返回null
	 */
	public PlanList find(int id);
	/*
	 * 删除一个PlanList元组
	 */
	public void delete(int id);
	
	/*
	 * 根据id更新PlanList表的一条记录
	 */
	public void updateByPlanListId(PlanList planList);
	/*
	 * 获得所有元组
	 */
	public List<PlanList> getAllPlanListList();
}
