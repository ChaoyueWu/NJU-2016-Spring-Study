package edu.nju.desserthouse.service;

import java.util.List;
import edu.nju.desserthouse.model.ShopClerk;
import edu.nju.desserthouse.model.User;

public interface ShopClerkService {
	/*
	 * 增加一个店员
	 */
	public void addShopClerk(ShopClerk shopClerk,User user);
	/*
	 * 删除一个店员
	 */
	public void deleteShopClerk(int scid,int uid);
	
	/*
	 * 根据id返回店员信息
	 */
	public ShopClerk findShopClerk(int id);
	
	
	/*
	 * 根据id更新店员信息
	 */
	public void updateByShopClerkId(ShopClerk shopClerk);
	/*
	 * 获得所有店员信息
	 */
	public List<ShopClerk> getAllShopClerkList();
}
