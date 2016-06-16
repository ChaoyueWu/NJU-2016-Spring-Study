package edu.nju.desserthouse.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.model.Shop;
import edu.nju.desserthouse.model.ShopClerk;
import edu.nju.desserthouse.service.ShopClerkService;
import edu.nju.desserthouse.service.ShopService;

public class ShopClerkManageAction extends BaseAction{
	@Autowired
	private ShopClerkService shopClerkService;
	private ShopService shopService;
	
	public ShopClerkService getShopClerkService() {
		return shopClerkService;
	}

	public void setShopClerkService(ShopClerkService shopClerkService) {
		this.shopClerkService = shopClerkService;
	}

	public ShopService getShopService() {
		return shopService;
	}

	public void setShopService(ShopService shopService) {
		this.shopService = shopService;
	}

	@Override
	public String execute() throws Exception {
		List<ShopClerk> shopClerkList = shopClerkService.getAllShopClerkList();
		request.setAttribute("shopClerkList", shopClerkList);
		List<Shop> shopList = shopService.getAllShopList();
		request.setAttribute("shopList", shopList);
		return "shopClerkManage";
	}
}
