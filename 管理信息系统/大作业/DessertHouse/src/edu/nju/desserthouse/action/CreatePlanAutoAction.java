package edu.nju.desserthouse.action;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.model.Dessert;
import edu.nju.desserthouse.model.Shop;
import edu.nju.desserthouse.model.stavo.AutoGeneratingPlanItem;
import edu.nju.desserthouse.service.DessertService;
import edu.nju.desserthouse.service.PlanAutoGenerateService;
import edu.nju.desserthouse.service.ShopService;

public class CreatePlanAutoAction extends BaseAction{
	@Autowired
	private DessertService dessertService;
	private ShopService shopService;
	private PlanAutoGenerateService planAutoGenerateService;
	private int range;
	private int type;
	private int sid;
	private String date;

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

	public PlanAutoGenerateService getPlanAutoGenerateService() {
		return planAutoGenerateService;
	}

	public void setPlanAutoGenerateService(PlanAutoGenerateService planAutoGenerateService) {
		this.planAutoGenerateService = planAutoGenerateService;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("sid:"+sid+",date:"+date+",range:"+range+",type:"+type);
		List<Shop> shopList = shopService.getAllShopList();
		request.setAttribute("shopList", shopList);
		
		List<Dessert> dessertList = dessertService.getAllDessertList();
		request.setAttribute("dessertList", dessertList);
		
		List<List<AutoGeneratingPlanItem>> agpList = planAutoGenerateService.getAutoGeneratingPlan(sid, range, type);
		request.setAttribute("agpList", agpList);
		//计算时间
		String[] dateArr = new String[8];
		for(int i = 0;i<8;i++){
			dateArr[i] = getMonday(i);
		}
		request.setAttribute("dateArr", dateArr);
		request.setAttribute("sid", sid);
		request.setAttribute("date", date);
		return "createPlanAuto";
		
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
