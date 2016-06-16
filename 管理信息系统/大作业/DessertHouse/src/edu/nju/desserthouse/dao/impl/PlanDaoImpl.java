package edu.nju.desserthouse.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.nju.desserthouse.dao.BaseDao;
import edu.nju.desserthouse.dao.PlanDao;
import edu.nju.desserthouse.model.Plan;
import edu.nju.desserthouse.model.User;

@Repository
public class PlanDaoImpl implements PlanDao{
	@Autowired
	private BaseDao baseDao;
	
	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
	@Override
	public void save(Plan plan) {
		try {
			baseDao.save(plan);

		}catch (Exception e) {			
			e.printStackTrace();
		}
	}

	@Override
	public Plan find(int id) {
		Plan plan = (Plan)baseDao.load(Plan.class, id);
		return plan;
	}

	@Override
	public void updateByPlanId(Plan plan) {
		baseDao.update(plan);
	}

	@Override
	public List<Plan> getAllPlanList() {
		@SuppressWarnings("unchecked")
		List<Plan> list = baseDao.getAllList(Plan.class);
		return list;
	}

}
