package edu.nju.desserthouse.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.dao.UserDao;
import edu.nju.desserthouse.model.User;
import edu.nju.desserthouse.service.UserService;

public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void registerUser(User user) {
		userDao.save(user);
	}

	@Override
	public User findUserById(int id) {
		return userDao.find(id);
	}

	@Override
	public void updateUser(User user) {
		userDao.updateByUserid(user);
	}

	@Override
	public List<User> getAllUerList() {
		return userDao.getAllUerList();
	}

	@Override
	public void deleteUser(int id) {
		userDao.delete(id);
	}

}
