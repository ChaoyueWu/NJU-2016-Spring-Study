package edu.nju.desserthouse.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.nju.desserthouse.dao.BaseDao;
import edu.nju.desserthouse.dao.DessertAvaliableDao;
import edu.nju.desserthouse.model.DessertAvaliable;

@Repository
public class DessertAvaliableDaoImpl implements DessertAvaliableDao{

	@Autowired
	private BaseDao baseDao;
	
	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
	@Override
	public void save(DessertAvaliable dessertAvaliable) {
		try {
			baseDao.save(dessertAvaliable);

		}catch (Exception e) {			
			e.printStackTrace();
		}
	}

	@Override
	public DessertAvaliable find(int id) {
		DessertAvaliable da = (DessertAvaliable)baseDao.load(DessertAvaliable.class, id);
		return da;
	}

	@Override
	public void delete(int id) {
		baseDao.delete(DessertAvaliable.class, id);
	}

	@Override
	public void updateByDessertAvaliableId(DessertAvaliable dessertAvaliable) {
		baseDao.update(dessertAvaliable);
	}

	@Override
	public List<DessertAvaliable> getAllDessertAvaliableList() {
		@SuppressWarnings("unchecked")
		List<DessertAvaliable> list = baseDao.getAllList(DessertAvaliable.class);
		return list;
	}

}
