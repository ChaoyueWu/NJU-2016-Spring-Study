package edu.nju.desserthouse.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.dao.ShopDao;
import edu.nju.desserthouse.model.Shop;
import edu.nju.desserthouse.service.ShopService;

public class ShopServiceImpl implements ShopService{
	@Autowired
	private ShopDao  shopDao;
	
	public ShopDao getShopDao() {
		return shopDao;
	}

	public void setShopDao(ShopDao shopDao) {
		this.shopDao = shopDao;
	}

	@Override
	public void createShop(Shop shop) {
		shopDao.save(shop);
	}

	@Override
	public void deleteShop(int id) {
		shopDao.delete(id);
	}

	@Override
	public Shop findShop(int id) {
		return shopDao.find(id);
	}

	@Override
	public void updateByShopid(Shop shop) {
		shopDao.updateByShopid(shop);
	}

	@Override
	public List<Shop> getAllShopList() {
		return shopDao.getAllShopList();
	}

}
