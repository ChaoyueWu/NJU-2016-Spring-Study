package edu.nju.desserthouse.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.model.Shop;
import edu.nju.desserthouse.service.ShopService;

public class UpdateShopAction extends BaseAction{
	@Autowired
	private ShopService shopService;
	private String sname;
	private String address;
	private String sid;
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

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	@Override
	public String execute() throws Exception {
		
		System.out.println("sname: "+sname+" add:"+address+" sid:"+sid);
		Shop shop = shopService.findShop(Integer.valueOf(sid));
		shop.setAddress(address);
		shop.setSname(sname);
		shopService.updateByShopid(shop);
		List<Shop> shopList = shopService.getAllShopList();
		request.setAttribute("shopList", shopList);
		return "shopManage";
	}
}
