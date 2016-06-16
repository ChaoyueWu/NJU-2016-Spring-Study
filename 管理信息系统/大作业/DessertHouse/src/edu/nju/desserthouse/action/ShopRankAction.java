package edu.nju.desserthouse.action;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.model.stavo.ShopRankVO;
import edu.nju.desserthouse.service.ShopRankService;

public class ShopRankAction extends BaseAction{
	
	@Autowired
	private ShopRankService shopRankService;
	private int choice;//比如1代表年统计，2代表月统计


	public ShopRankService getShopRankService() {
		return shopRankService;
	}


	public void setShopRankService(ShopRankService shopRankService) {
		this.shopRankService = shopRankService;
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
		
		System.out.println("choice:"+choice);
		ShopRankVO srvo = shopRankService.getShopRankVO(choice);
		request.setAttribute("srvo", srvo);
		request.setAttribute("choice", choice);
		HttpSession session = request.getSession();
		String type = (String) session.getAttribute("type");
		if(type.equals("JL")){
			return "shopRank";
		}else if(type.equals("ZJL")){
			return "shopRankZJL";
		}
		return "login";
	}
}
