package edu.nju.desserthouse.model;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
public class DessertAvailableBranchVO {
	//有商品的日期数组——注意判断时间，只要比当前时间晚的商品集
	private List<Date> dateList;
	//每天对应的商品列表 hashMap
	private HashMap<Date,List<DessertVO>> ddMap;
	
	public DessertAvailableBranchVO(){}
	public DessertAvailableBranchVO(List<Date> dateList, HashMap<Date, List<DessertVO>> ddMap) {
		super();
		this.dateList = dateList;
		this.ddMap = ddMap;
	}
	public List<Date> getDateList() {
		return dateList;
	}
	public void setDateList(List<Date> dateList) {
		this.dateList = dateList;
	}
	public HashMap<Date, List<DessertVO>> getDdMap() {
		return ddMap;
	}
	public void setDdMap(HashMap<Date, List<DessertVO>> ddMap) {
		this.ddMap = ddMap;
	}
	
}
