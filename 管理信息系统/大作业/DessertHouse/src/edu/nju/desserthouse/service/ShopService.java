package edu.nju.desserthouse.service;

import java.util.List;

import edu.nju.desserthouse.model.Shop;

public interface ShopService {
	/*
	 * 增加一个店面
	 */
	public void createShop(Shop shop);
	/*
	 * 删除一个店面
	 */
	public void deleteShop(int id);
	
	/*
	 * 根据id返回店面信息
	 */
	public Shop findShop(int id);
	
	
	/*
	 * 根据id更新店面信息
	 */
	public void updateByShopid(Shop shop);
	/*
	 * 获得所有店面信息
	 */
	public List<Shop> getAllShopList();
}
