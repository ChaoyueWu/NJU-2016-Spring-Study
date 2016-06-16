package edu.nju.desserthouse.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.model.Shop;
import edu.nju.desserthouse.service.ShopService;

public class AddShopAction extends BaseAction{
	@Autowired
	private ShopService shopService;
	private String sname;
	private String address;
	public ShopService getShopService() {
		return shopService;
	}

	public void setShopService(ShopService shopService) {
		this.shopService = shopService;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String execute() throws Exception {
		
		System.out.println("sname: "+sname+" add:"+address);
		Shop shop = new Shop();
		shop.setAddress(address);
		shop.setSname(sname);
		shopService.createShop(shop);
		List<Shop> shopList = shopService.getAllShopList();
		request.setAttribute("shopList", shopList);
		return "shopManage";
	}
}
