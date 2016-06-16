package edu.nju.desserthouse.action;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.model.Dessert;
import edu.nju.desserthouse.model.PlanVO;
import edu.nju.desserthouse.model.Shop;
import edu.nju.desserthouse.service.DessertService;
import edu.nju.desserthouse.service.PlanService;
import edu.nju.desserthouse.service.ShopService;

public class PlanPendingAction extends BaseAction{
	@Autowired
	private PlanService planService;
	private DessertService dessertService;
	private ShopService shopService;

	public PlanService getPlanService() {
		return planService;
	}

	public void setPlanService(PlanService planService) {
		this.planService = planService;
	}

	public DessertService getDessertService() {
		return dessertService;
	}

	public void setDessertService(DessertService dessertService) {
		this.dessertService = dessertService;
	}

	public ShopService getShopService() {
		return shopService;
	}

	public void setShopService(ShopService shopService) {
		this.shopService = shopService;
	}


	@Override
	public String execute() throws Exception {
		//获得所有商店id和名字的对应关系
		List<Shop> shopList = shopService.getAllShopList();
		HashMap<Integer,String> shopMap = new HashMap<Integer,String>();
		for(Shop s:shopList){
			shopMap.put(s.getSid(),s.getSname());
		}
		request.setAttribute("shopMap", shopMap);
		//获得所有商品id和名字的对应关系
		List<Dessert> dessertList = dessertService.getAllDessertList();
		HashMap<Integer,String> dessertMap = new HashMap<Integer,String>();
		for(Dessert d:dessertList){
			dessertMap.put(d.getDid(), d.getName());
		}
		request.setAttribute("dessertMap", dessertMap);
		List<PlanVO> planvoList = planService.getAllPendingPlan();
		request.setAttribute("planvoList", planvoList);
		
		HttpSession session = request.getSession();
		String type = (String) session.getAttribute("type");
		if(type.equals("ZD")){
			return "planPending";
		}else if(type.equals("JL")){
			return "dessertPlanJL";
		}
		return "login";
		
	}

}
