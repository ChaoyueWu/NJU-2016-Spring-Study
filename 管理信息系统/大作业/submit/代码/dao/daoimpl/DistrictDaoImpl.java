package edu.nju.desserthouse.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.nju.desserthouse.dao.BaseDao;
import edu.nju.desserthouse.dao.DistrictDao;
import edu.nju.desserthouse.model.District;

@Repository
public class DistrictDaoImpl implements DistrictDao{
	@Autowired
	private BaseDao baseDao;
	
	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public List<District> getAllDistrictList() {
		@SuppressWarnings("unchecked")
		List<District> list = baseDao.getAllList(District.class);
		return list;
	}
}
