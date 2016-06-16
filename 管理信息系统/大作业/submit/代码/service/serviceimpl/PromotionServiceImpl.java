package edu.nju.desserthouse.service.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.dao.PromotionDao;
import edu.nju.desserthouse.model.Promotion;
import edu.nju.desserthouse.service.PromotionService;

public class PromotionServiceImpl implements PromotionService{
	@Autowired
	private PromotionDao promotionDao;

	public PromotionDao getPromotionDao() {
		return promotionDao;
	}

	public void setPromotionDao(PromotionDao promotionDao) {
		this.promotionDao = promotionDao;
	}

	@Override
	public void generatePromotion(int level, int value, int require, String date) {
		Promotion p = new Promotion();
		p.setName("´ú½ðÈ¯");
		p.setMemtype(level);
		p.setRequire(require);
		p.setValue(value);
		p.setDeadline(Date.valueOf(date));
		promotionDao.save(p);
	}

	@Override
	public List<Promotion> getPromotionList() {
		return promotionDao.getAllPromotionList();
	}
	
}
