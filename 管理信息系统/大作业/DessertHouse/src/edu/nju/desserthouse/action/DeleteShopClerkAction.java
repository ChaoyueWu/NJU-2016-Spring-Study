package edu.nju.desserthouse.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.model.Shop;
import edu.nju.desserthouse.model.ShopClerk;
import edu.nju.desserthouse.service.ShopClerkService;
import edu.nju.desserthouse.service.ShopService;

public class DeleteShopClerkAction extends BaseAction{
	@Autowired
	private ShopClerkService shopClerkService;
	private ShopService shopService;
	private String scid;
	
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

	public String getScid() {
		return scid;
	}

	public void setScid(String scid) {
		this.scid = scid;
	}

	@Override
	public String execute() throws Exception {
		shopClerkService.deleteShopClerk(Integer.valueOf(scid), Integer.valueOf(scid));
		
		List<Shop> shopList = shopService.getAllShopList();
		request.setAttribute("shopList", shopList);
		List<ShopClerk> shopClerkList = shopClerkService.getAllShopClerkList();
		request.setAttribute("shopClerkList", shopClerkList);
		return "shopClerkManage";
	}
}
