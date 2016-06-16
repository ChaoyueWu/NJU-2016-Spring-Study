package edu.nju.desserthouse.service;

import java.util.List;

import edu.nju.desserthouse.model.Promotion;

public interface PromotionService {

	public void generatePromotion(int level,int value,int require,String date);
	public List<Promotion> getPromotionList();
}
