package edu.nju.desserthouse.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.model.Dessert;
import edu.nju.desserthouse.model.Shop;
import edu.nju.desserthouse.service.DessertService;
import edu.nju.desserthouse.service.ShopService;

public class PlanNewAction extends BaseAction{
	@Autowired
	private DessertService dessertService;
	private ShopService shopService;

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
		List<Shop> shopList = shopService.getAllShopList();
		request.setAttribute("shopList", shopList);
		
		List<Dessert> dessertList = dessertService.getAllDessertList();
		request.setAttribute("dessertList", dessertList);
		
		//计算时间
		String[] dateArr = new String[8];
		for(int i = 0;i<8;i++){
			dateArr[i] = getMonday(i);
		}
		request.setAttribute("dateArr", dateArr);
		return "planNew";
		
	}
	/*
	 *获得下一个周一 
	 */
	private String getMonday(int i){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_WEEK, 7*i);
        while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
            calendar.add(Calendar.DAY_OF_WEEK, 1);
        }
        String dayAfter = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
        return dayAfter;
	}
	
}
