package edu.nju.desserthouse.action;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.model.stavo.ShopStaVO;
import edu.nju.desserthouse.service.ShopStaService;

public class ShopStaAction extends BaseAction{
	
	@Autowired
	private ShopStaService shopStaService;
	private int sid;
	private int disid;
	private int choice;//比如1代表天统计，2代表月统计

	public ShopStaService getShopStaService() {
		return shopStaService;
	}

	public void setShopStaService(ShopStaService shopStaService) {
		this.shopStaService = shopStaService;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getDisid() {
		return disid;
	}

	public void setDisid(int disid) {
		this.disid = disid;
	}

	public int getChoice() {
		return choice;
	}

	public void setChoice(int choice) {
		this.choice = choice;
	}

	@Override
	public String execute() throws Exception {
		//每个分类下的商品信息
		//分类统计信息
		//传入地区和店铺，获得地区、店铺、分类、对应的分类统计列表、每个分类对应的商品统计列表
		
		System.out.println("sid:"+sid+";disid:"+disid+";choice:"+choice);
		ShopStaVO ssvo = shopStaService.getShopSta(sid, disid, choice);
		request.setAttribute("ssvo", ssvo);
		request.setAttribute("sid", sid);
		request.setAttribute("disid", disid);
		request.setAttribute("choice", choice);
		HttpSession session = request.getSession();
		String type = (String) session.getAttribute("type");
		if(type.equals("JL")){
			return "shopSta";
		}else if(type.equals("ZJL")){
			return "shopStaZJL";
		}
		return "login";
	}
}
