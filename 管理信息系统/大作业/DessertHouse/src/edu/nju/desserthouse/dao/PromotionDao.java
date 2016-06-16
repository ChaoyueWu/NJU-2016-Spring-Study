package edu.nju.desserthouse.dao;

import java.util.List;
import edu.nju.desserthouse.model.Promotion;

public interface PromotionDao {
	/*
	 * 像数据库中插入一条Promotion
	 */
	public void save(Promotion promotion);
	/*
	 * 获得所有元组
	 */
	public List<Promotion> getAllPromotionList();
	/*
	 * 查找某类型会员的促销策略
	 */
	public List<Promotion> findMemPromotion(int mid);
}
