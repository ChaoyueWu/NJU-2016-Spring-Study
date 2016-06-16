package edu.nju.desserthouse.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.dao.ShopClerkDao;
import edu.nju.desserthouse.dao.UserDao;
import edu.nju.desserthouse.model.ShopClerk;
import edu.nju.desserthouse.model.User;
import edu.nju.desserthouse.service.ShopClerkService;

public class ShopClerkServiceImpl implements ShopClerkService{

	@Autowired
	private ShopClerkDao shopClerkDao;
	private UserDao userDao;
	
	public ShopClerkDao getShopClerkDao() {
		return shopClerkDao;
	}

	public void setShopClerkDao(ShopClerkDao shopClerkDao) {
		this.shopClerkDao = shopClerkDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void addShopClerk(ShopClerk shopClerk, User user) {
		shopClerkDao.save(shopClerk);
		userDao.save(user);
	}

	@Override
	public void deleteShopClerk(int scid, int uid) {
		shopClerkDao.delete(scid);
		userDao.delete(uid);
	}

	@Override
	public ShopClerk findShopClerk(int id) {
		return shopClerkDao.find(id);
	}

	@Override
	public List<ShopClerk> getAllShopClerkList() {
		return shopClerkDao.getAllShopClerkList();
	}

	@Override
	public void updateByShopClerkId(ShopClerk shopClerk) {
		shopClerkDao.updateByShopClerkId(shopClerk);
	}

}
