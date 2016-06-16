package edu.nju.desserthouse.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.nju.desserthouse.dao.BaseDao;
import edu.nju.desserthouse.dao.PlanListDao;
import edu.nju.desserthouse.model.PlanList;

@Repository
public class PlanListDaoImpl implements PlanListDao{
	
	@Autowired
	private BaseDao baseDao;
	
	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
	@Override
	public void save(PlanList planList) {
		try {
			baseDao.save(planList);

		}catch (Exception e) {			
			e.printStackTrace();
		}
	}

	@Override
	public PlanList find(int id) {
		PlanList planList = (PlanList)baseDao.load(PlanList.class, id);
		return planList;
	}

	@Override
	public void delete(int id) {
		baseDao.delete(PlanList.class, id);
	}

	@Override
	public void updateByPlanListId(PlanList planList) {
		baseDao.update(planList);
	}

	@Override
	public List<PlanList> getAllPlanListList() {
		@SuppressWarnings("unchecked")
		List<PlanList> list = baseDao.getAllList(PlanList.class);
		return list;
	}

}
