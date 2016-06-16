package edu.nju.desserthouse.service.impl;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.dao.PlanDao;
import edu.nju.desserthouse.dao.PlanListDao;
import edu.nju.desserthouse.model.Goods;
import edu.nju.desserthouse.model.Plan;
import edu.nju.desserthouse.model.PlanList;
import edu.nju.desserthouse.model.PlanVO;
import edu.nju.desserthouse.service.PlanService;

public class PlanServiceImpl implements PlanService {

	@Autowired
	private PlanDao planDao;
	private PlanListDao planListDao;

	public PlanDao getPlanDao() {
		return planDao;
	}

	public void setPlanDao(PlanDao planDao) {
		this.planDao = planDao;
	}

	public PlanListDao getPlanListDao() {
		return planListDao;
	}

	public void setPlanListDao(PlanListDao planListDao) {
		this.planListDao = planListDao;
	}

	@Override
	public void createPlan(int sid,Date startDate,HashMap<Date,List<Goods>> map) {
		// 增加一个plan条目
		Plan plan = new Plan();
		int pid = getId();
		plan.setPid(pid);
		plan.setSid(sid);
		plan.setStartDate(startDate);
		plan.setState(0);
		planDao.save(plan);
		// 增加一个plan对应的每日计划
		Date date = getDateBefore(startDate);
		for (int i = 0; i < 7; i++) {
			date = getDateAfter(date);
			List<Goods> list = map.get(date);
			for(Goods goods:list){
				PlanList pl = new PlanList();
				pl.setPid(pid);
				pl.setDate(date);
				pl.setDid(goods.getDid());
				pl.setAmount(goods.getAmount());
				pl.setPrice(goods.getPrice());
				planListDao.save(pl);
			}
		}
	}

	/*
	 * 获得一个新计划的id
	 */
	private int getId() {
		List<Plan> list = planDao.getAllPlanList();
		int num = 0;
		int id;
		for (Plan plan : list) {
			id = plan.getPid();
			if (num < id) {
				num = id;
			}
		}
		num++;
		return num;
	}

	/*
	 * 获得当前日期的后一天
	 */
	private Date getDateAfter(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day + 1);
		String dayAfter = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
		date = Date.valueOf(dayAfter);
		return date;
	}
	/*
	 * 获得当前日期的前一天
	 */
	private Date getDateBefore(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day - 1);
		String dayAfter = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
		date = Date.valueOf(dayAfter);
		return date;
	}

	@Override
	public List<PlanVO> getAllApprovedPlan() {
		List<PlanVO> list = new ArrayList<PlanVO>();
		List<Plan> pl = planDao.getAllPlanList();
		List<PlanList> pll = planListDao.getAllPlanListList();
		for(Plan plan:pl ){
			if(plan.getState()==1){
				PlanVO pvo = new PlanVO();
				pvo.setPid(plan.getPid());
				pvo.setSid(plan.getSid());
				pvo.setStartDate(plan.getStartDate());
				HashMap<Date, List<Goods>> map = new HashMap<Date, List<Goods>>();
				
				Date date = getDateBefore(plan.getStartDate());
				for (int i = 0; i < 7; i++) {
					date = getDateAfter(date);
					List<Goods> gl = new ArrayList<Goods>();
					for(PlanList planList : pll){
						if(planList.getPid() == plan.getPid()&&planList.getDate().equals(date)){
							Goods goods = new Goods();
							goods.setDid(planList.getDid());
							goods.setPrice(planList.getPrice());
							goods.setAmount(planList.getAmount());
							gl.add(goods);
						}
					}
					map.put(date, gl);
				}
				
				pvo.setMap(map);
				list.add(pvo);
			}
		}
		
		return list;
	}

	@Override
	public List<PlanVO> getAllPendingPlan() {
		List<PlanVO> list = new ArrayList<PlanVO>();
		List<Plan> pl = planDao.getAllPlanList();
		List<PlanList> pll = planListDao.getAllPlanListList();
		for(Plan plan:pl ){
			if(plan.getState()==0){
				PlanVO pvo = new PlanVO();
				pvo.setPid(plan.getPid());
				pvo.setSid(plan.getSid());
				pvo.setStartDate(plan.getStartDate());
				HashMap<Date, List<Goods>> map = new HashMap<Date, List<Goods>>();
				
				Date date = getDateBefore(plan.getStartDate());
				for (int i = 0; i < 7; i++) {
					date = getDateAfter(date);
					List<Goods> gl = new ArrayList<Goods>();
					for(PlanList planList : pll){
						if(planList.getPid() == plan.getPid()&&planList.getDate().equals(date)){
							Goods goods = new Goods();
							goods.setDid(planList.getDid());
							goods.setPrice(planList.getPrice());
							goods.setAmount(planList.getAmount());
							gl.add(goods);
						}
					}
					map.put(date, gl);
				}
				
				pvo.setMap(map);
				list.add(pvo);
			}
		}
		
		return list;
	}

	@Override
	public List<PlanVO> getAllRejectedPlan() {
		List<PlanVO> list = new ArrayList<PlanVO>();
		List<Plan> pl = planDao.getAllPlanList();
		List<PlanList> pll = planListDao.getAllPlanListList();
		for(Plan plan:pl ){
			if(plan.getState()==2){
				PlanVO pvo = new PlanVO();
				pvo.setPid(plan.getPid());
				pvo.setSid(plan.getSid());
				pvo.setStartDate(plan.getStartDate());
				HashMap<Date, List<Goods>> map = new HashMap<Date, List<Goods>>();
				
				Date date = getDateBefore(plan.getStartDate());
				for (int i = 0; i < 7; i++) {
					date = getDateAfter(date);
					List<Goods> gl = new ArrayList<Goods>();
					for(PlanList planList : pll){
						if(planList.getPid() == plan.getPid()&&planList.getDate().equals(date)){
							Goods goods = new Goods();
							goods.setPlid(planList.getPlid());
							goods.setDid(planList.getDid());
							goods.setPrice(planList.getPrice());
							goods.setAmount(planList.getAmount());
							gl.add(goods);
						}
					}
					map.put(date, gl);
				}
				
				pvo.setMap(map);
				list.add(pvo);
			}
		}
		
		return list;
	}

	@Override
	public void modifyPlan(int pid,HashMap<Date,List<Goods>> map) {
		// 修改计划表
		Plan plan = planDao.find(pid);
		plan.setState(0);
		planDao.updateByPlanId(plan);
		System.out.println("enter update plan");
		//修改计划条目
		Date date = getDateBefore(plan.getStartDate());
		for (int i = 0; i < 7; i++) {
			date = getDateAfter(date);
			List<Goods> list = map.get(date);
			for(Goods goods:list){
				PlanList pl = planListDao.find(goods.getPlid());
				pl.setAmount(goods.getAmount());
				pl.setDate(pl.getDate());
				pl.setPrice(goods.getPrice());
				planListDao.updateByPlanListId(pl);
			}
		}
	}

	@Override
	public void permitPlan(int pid) {
		Plan plan = planDao.find(pid);
		plan.setState(1);
		planDao.updateByPlanId(plan);
	}

	@Override
	public void rejectPlan(int pid) {
		Plan plan = planDao.find(pid);
		plan.setState(2);
		planDao.updateByPlanId(plan);
	}

	@Override
	public Plan findPlanById(int pid) {
		return planDao.find(pid);
	}

}
