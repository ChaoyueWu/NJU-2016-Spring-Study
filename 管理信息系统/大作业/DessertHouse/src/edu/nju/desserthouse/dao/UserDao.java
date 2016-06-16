package edu.nju.desserthouse.dao;

import java.util.List;
import edu.nju.desserthouse.model.User;

public interface UserDao {
	/*
	 * 像数据库中插入一条user记录
	 */
	public void save(User user);
	
	
	/*
	 * 根据id查找user对象,如果找到则返回这个对象,否则返回null
	 */
	public User find(int id);
	/*
	 * 删除一个user元组
	 */
	public void delete(int id);
	
	/*
	 * 根据id更新user表的一条记录
	 */
	public void updateByUserid(User user);
	/*
	 * 获得所有元组
	 */
	public List<User> getAllUerList();
}
