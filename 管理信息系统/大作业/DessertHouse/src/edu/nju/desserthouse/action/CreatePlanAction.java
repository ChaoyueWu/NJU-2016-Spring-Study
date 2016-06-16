package edu.nju.desserthouse.action;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.model.Dessert;
import edu.nju.desserthouse.model.Goods;
import edu.nju.desserthouse.model.PlanVO;
import edu.nju.desserthouse.model.Shop;
import edu.nju.desserthouse.service.DessertService;
import edu.nju.desserthouse.service.PlanService;
import edu.nju.desserthouse.service.ShopService;

public class CreatePlanAction extends BaseAction{
	@Autowired
	private PlanService planService;
	private DessertService dessertService;
	private ShopService shopService;
	private String dessert;
	private String sid;
	private String date;

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

	public String getDessert() {
		return dessert;
	}

	public void setDessert(String dessert) {
		this.dessert = dessert;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
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
		System.out.println("sid:"+sid+" date:"+date+" dessert:"+dessert);
		Date startDate = java.sql.Date.valueOf(date);
		Date date1 = getDateBefore(startDate);
		HashMap<Date,List<Goods>> map = new HashMap<Date,List<Goods>>();
		//每一天的计划
		String[] day = dessert.split("\\|");
		for(int i =0;i<day.length;i++){
			date1 = getDateAfter(date1);
			List<Goods> list = new ArrayList<Goods>();
			String[] goods = day[i].split(";");
			for(int j =0;j<goods.length;j++){
				Goods good = getGood(goods[j]);
				list.add(good);
			}
			map.put(date1, list);
		}
		planService.createPlan(Integer.valueOf(sid),startDate, map);
		
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
		List<PlanVO> planvoList = planService.getAllApprovedPlan();
		request.setAttribute("planvoList", planvoList);
		return "planApproved";
		
	}
	private Goods getGood(String string) {
		Goods good = new Goods();
		String[] item = string.split(" ");
		good.setDid(Integer.valueOf(item[0]));
		good.setAmount(Integer.valueOf(item[1]));
		String temp = item[2]+"."+item[3];
		System.out.println(temp);
		double price = Double.valueOf(temp);
		good.setPrice(price);
		return good;
	}

	/*
	 * 获得当前日期的后一天
	 */
	private Date getDateAfter(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day + 1);
		String dayAfter = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
		date = Date.valueOf(dayAfter);
		return date;
	}
	/*
	 * 获得当前日期的前一天
	 */
	private Date getDateBefore(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day - 1);
		String dayAfter = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
		date = Date.valueOf(dayAfter);
		return date;
	}
}
