package edu.nju.desserthouse.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.model.Shop;
import edu.nju.desserthouse.service.ShopService;

public class ShopManageAction extends BaseAction{
	@Autowired
	private ShopService shopService;
	
	public ShopService getShopService() {
		return shopService;
	}

	public void setShopService(ShopService shopService) {
		this.shopService = shopService;
	}

	@Override
	public String execute() throws Exception {
		List<Shop> shopList = shopService.getAllShopList();
		request.setAttribute("shopList", shopList);
		return "shopManage";
	}
}
