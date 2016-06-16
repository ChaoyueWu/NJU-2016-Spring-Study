package edu.nju.desserthouse.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.nju.desserthouse.dao.BaseDao;
import edu.nju.desserthouse.dao.DessertDao;
import edu.nju.desserthouse.model.Dessert;

@Repository
public class DessertDaoImpl implements DessertDao{
	
	@Autowired
	private BaseDao baseDao;
	
	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	@Override
	public void save(Dessert dessert) {
		try {
			baseDao.save(dessert);
		}catch (Exception e) {			
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		baseDao.delete(Dessert.class, id);
	}

	@Override
	public Dessert find(int id) {
		Dessert dessert = (Dessert)baseDao.load(Dessert.class, id);
		return dessert;
	}

	@Override
	public void updateByDessertId(Dessert dessert) {
		baseDao.update(dessert);
	}

	@Override
	public List<Dessert> getAllDessertList() {
		@SuppressWarnings("unchecked")
		List<Dessert> list = baseDao.getAllList(Dessert.class);
		return list;
	}

}
