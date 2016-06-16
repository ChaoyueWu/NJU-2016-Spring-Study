package edu.nju.desserthouse.dao;

import java.util.List;
import edu.nju.desserthouse.model.Plan;

public interface PlanDao {
	/*
	 * 像数据库中插入一条Plan记录
	 */ 
	public void save(Plan plan);
	
	
	/*
	 * 根据id查找Plan对象,如果找到则返回这个对象,否则返回null
	 */
	public Plan find(int id);
	
	/*
	 * 根据id更新Plan表的一条记录
	 */
	public void updateByPlanId(Plan plan);
	/*
	 * 获得所有元组
	 */
	public List<Plan> getAllPlanList();
}
