package edu.nju.desserthouse.service;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

import edu.nju.desserthouse.model.Goods;
import edu.nju.desserthouse.model.Plan;
import edu.nju.desserthouse.model.PlanVO;

public interface PlanService {
//查看已通过计划 待审批计划 未通过计划 制定新计划
	//计划的map(id,plList<PlanList>)
	/*
	 * 新建一个计划
	 */
	public void createPlan(int sid,Date startDate,HashMap<Date,List<Goods>> map);
	/*
	 * 查看已通过的计划
	 */
	public List<PlanVO> getAllApprovedPlan();
	/*
	 * 查看待审批计划
	 */
	public List<PlanVO> getAllPendingPlan();
	/*
	 * 查看未通过计划
	 */
	public List<PlanVO> getAllRejectedPlan();
	/*
	 * 修改一个计划
	 */
	public void modifyPlan(int pid,HashMap<Date,List<Goods>> map);
	/*
	 * 批准一个计划
	 */
	public void permitPlan(int pid);
	/*
	 * 不批准一个计划
	 */
	public void rejectPlan(int pid);
	/*
	 * 根据Pid查找计划
	 */
	public Plan findPlanById(int pid);
}
