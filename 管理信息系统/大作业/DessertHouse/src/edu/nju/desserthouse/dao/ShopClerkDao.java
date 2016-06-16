package edu.nju.desserthouse.dao;

import java.util.List;
import edu.nju.desserthouse.model.ShopClerk;

public interface ShopClerkDao {
	/*
	 * 像数据库中插入一条ShopClerk
	 */
	public void save(ShopClerk shopClerk);
	/*
	 * 删除一个ShopClerk元组
	 */
	public void delete(int id);
	
	/*
	 * 根据id查找ShopClerk对象,如果找到则返回这个对象,否则返回null
	 */
	public ShopClerk find(int id);
	
	
	/*
	 * 根据id更新shop表的一条记录
	 */
	public void updateByShopClerkId(ShopClerk shopClerk);
	/*
	 * 获得所有元组
	 */
	public List<ShopClerk> getAllShopClerkList();
}
