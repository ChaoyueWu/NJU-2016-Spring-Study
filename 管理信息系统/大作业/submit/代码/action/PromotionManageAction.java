package edu.nju.desserthouse.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.model.Promotion;
import edu.nju.desserthouse.service.PromotionService;

public class PromotionManageAction extends BaseAction{
	@Autowired
	private PromotionService promotionService;

	public PromotionService getPromotionService() {
		return promotionService;
	}


	public void setPromotionService(PromotionService promotionService) {
		this.promotionService = promotionService;
	}


	@Override
	public String execute() throws Exception {
		List<Promotion> plist = promotionService.getPromotionList();
		request.setAttribute("plist", plist);
		return "promotionManage";
		
	}
}
