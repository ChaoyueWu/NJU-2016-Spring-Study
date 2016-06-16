package edu.nju.desserthouse.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.nju.desserthouse.dao.BaseDao;
import edu.nju.desserthouse.dao.ShopClerkDao;
import edu.nju.desserthouse.model.Shop;
import edu.nju.desserthouse.model.ShopClerk;

@Repository
public class ShopClerkDaoImpl implements ShopClerkDao{

	@Autowired
	private BaseDao baseDao;
	
	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
	@Override
	public void save(ShopClerk shopClerk) {
		try {
			baseDao.save(shopClerk);
		}catch (Exception e) {			
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		baseDao.delete(ShopClerk.class, id);
	}

	@Override
	public ShopClerk find(int id) {
		ShopClerk shopClerk = (ShopClerk)baseDao.load(ShopClerk.class, id);
		return shopClerk;
	}

	@Override
	public void updateByShopClerkId(ShopClerk shopClerk) {
		baseDao.update(shopClerk);
	}

	@Override
	public List<ShopClerk> getAllShopClerkList() {
		@SuppressWarnings("unchecked")
		List<ShopClerk> list = baseDao.getAllList(ShopClerk.class);
		return list;
	}

}
