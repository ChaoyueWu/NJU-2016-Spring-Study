package edu.nju.desserthouse.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.model.Shop;
import edu.nju.desserthouse.service.ShopService;

public class DeleteShopAction extends BaseAction{
	@Autowired
	private ShopService shopService;
	private String sid;
	public ShopService getShopService() {
		return shopService;
	}

	public void setShopService(ShopService shopService) {
		this.shopService = shopService;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	@Override
	public String execute() throws Exception {
		shopService.deleteShop(Integer.valueOf(sid));;
		List<Shop> shopList = shopService.getAllShopList();
		request.setAttribute("shopList", shopList);
		return "shopManage";
	}
}
