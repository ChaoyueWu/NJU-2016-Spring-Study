package edu.nju.desserthouse.dao;

import java.util.List;

import edu.nju.desserthouse.model.DessertAvaliable;

public interface DessertAvaliableDao {
	/*
	 * 像数据库中插入一条DessertAvaliable记录
	 */
	public void save(DessertAvaliable dessertAvaliable);
	
	
	/*
	 * 根据id查找DessertAvaliable对象,如果找到则返回这个对象,否则返回null
	 */
	public DessertAvaliable find(int id);
	/*
	 * 删除一个DessertAvaliable元组
	 */
	public void delete(int id);
	
	/*
	 * 根据id更新user表的一条记录
	 */
	public void updateByDessertAvaliableId(DessertAvaliable dessertAvaliable);
	/*
	 * 获得所有元组
	 */
	public List<DessertAvaliable> getAllDessertAvaliableList();
}
