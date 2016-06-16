package edu.nju.desserthouse.dao;

import java.util.List;

import edu.nju.desserthouse.model.Dessert;

public interface DessertDao {
	/*
	 * 像数据库中插入一条Dessert
	 */
	public void save(Dessert dessert);
	/*
	 * 删除一个Dessert元组
	 */
	public void delete(int id);
	
	/*
	 * 根据id查找Dessert对象,如果找到则返回这个对象,否则返回null
	 */
	public Dessert find(int id);
	
	
	/*
	 * 根据id更新Dessert表的一条记录
	 */
	public void updateByDessertId(Dessert dessert);
	/*
	 * 获得所有元组
	 */
	public List<Dessert> getAllDessertList();
}
