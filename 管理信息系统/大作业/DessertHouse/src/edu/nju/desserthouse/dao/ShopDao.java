package edu.nju.desserthouse.dao;

import java.util.List;

import edu.nju.desserthouse.model.Shop;

public interface ShopDao {
	/*
	 * 像数据库中插入一条shop
	 */
	public void save(Shop shop);
	/*
	 * 删除一个shop元组
	 */
	public void delete(int id);
	
	/*
	 * 根据id查找shop对象,如果找到则返回这个对象,否则返回null
	 */
	public Shop find(int id);
	
	
	/*
	 * 根据id更新shop表的一条记录
	 */
	public void updateByShopid(Shop shop);
	/*
	 * 获得所有元组
	 */
	public List<Shop> getAllShopList();
}
