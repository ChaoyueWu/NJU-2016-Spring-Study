package edu.nju.desserthouse.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.nju.desserthouse.dao.BaseDao;
import edu.nju.desserthouse.dao.ShopDao;
import edu.nju.desserthouse.model.Shop;

@Repository
public class ShopDaoImpl implements ShopDao{

	@Autowired
	private BaseDao baseDao;
	
	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
	@Override
	public void save(Shop shop) {
		try {
			baseDao.save(shop);
		}catch (Exception e) {			
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		baseDao.delete(Shop.class, id);
	}

	@Override
	public Shop find(int id) {
		Shop shop = (Shop)baseDao.load(Shop.class, id);
		return shop;
	}

	@Override
	public void updateByShopid(Shop shop) {
		baseDao.update(shop);
	}

	@Override
	public List<Shop> getAllShopList() {
		@SuppressWarnings("unchecked")
		List<Shop> list = baseDao.getAllList(Shop.class);
		return list;
	}


}
