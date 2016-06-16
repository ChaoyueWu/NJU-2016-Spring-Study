package edu.nju.desserthouse.action;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.model.Dessert;
import edu.nju.desserthouse.model.PlanVO;
import edu.nju.desserthouse.model.Shop;
import edu.nju.desserthouse.service.DessertAvaliableService;
import edu.nju.desserthouse.service.DessertService;
import edu.nju.desserthouse.service.PlanService;
import edu.nju.desserthouse.service.ShopService;

public class HandlePlanAction extends BaseAction{
	@Autowired
	private PlanService planService;
	private DessertService dessertService;
	private ShopService shopService;
	private DessertAvaliableService dessertAvaliableService;
	private String pid;
	private int permit;
	
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
	

	public DessertAvaliableService getDessertAvaliableService() {
		return dessertAvaliableService;
	}

	public void setDessertAvaliableService(DessertAvaliableService dessertAvaliableService) {
		this.dessertAvaliableService = dessertAvaliableService;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public int getPermit() {
		return permit;
	}

	public void setPermit(int permit) {
		this.permit = permit;
	}

	@Override
	public String execute() throws Exception {
		if(permit == 1){
			planService.permitPlan(Integer.valueOf(pid));
			//对应生成某商店的可麦商品类别
			dessertAvaliableService.createAvaliableDeesert(Integer.valueOf(pid));
		}else if(permit == 0){
			planService.rejectPlan(Integer.valueOf(pid));
		}
		
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
		
		return "dessertPlanJL";
		
	}

}
