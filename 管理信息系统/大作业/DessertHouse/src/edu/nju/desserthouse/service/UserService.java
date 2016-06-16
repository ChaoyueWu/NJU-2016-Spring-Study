package edu.nju.desserthouse.service;

import java.util.List;

import edu.nju.desserthouse.model.User;

public interface UserService {
	/*
	 * 注册新用户，记录其id和密码
	 */
	public void registerUser(User user);
	
	/*
	 * 通过id查找用户，用于验证登录密码
	 */
	public User findUserById(int id);
	/*
	 * 更新用户密码
	 */
	public void updateUser(User user);
	/*
	 * 删除一个店员
	 */
	public void deleteUser(int id);
	/*
	 * 获得所有用户登录信息
	 */
	public List<User> getAllUerList();
}
