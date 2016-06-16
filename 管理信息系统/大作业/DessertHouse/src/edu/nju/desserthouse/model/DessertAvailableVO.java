package edu.nju.desserthouse.model;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

public class DessertAvailableVO {
	//可选择的店铺数组 可选择的店铺对应的可选择的日期 确定店铺和日期后对应的商品列表
	private List<Shop> shops;
	private HashMap<Shop,List<Date>> sdMap;//shop对应的date列表
	private HashMap<String ,List<DessertVO>> sddMap;//shop的id和date组成的字符串 对应的商品信息列表
	
	public DessertAvailableVO(){}
	public DessertAvailableVO(List<Shop> shops, HashMap<Shop, List<Date>> sdMap,
			HashMap<String, List<DessertVO>> sddMap) {
		super();
		this.shops = shops;
		this.sdMap = sdMap;
		this.sddMap = sddMap;
	}
	public List<Shop> getShops() {
		return shops;
	}
	public void setShops(List<Shop> shops) {
		this.shops = shops;
	}
	public HashMap<Shop, List<Date>> getSdMap() {
		return sdMap;
	}
	public void setSdMap(HashMap<Shop, List<Date>> sdMap) {
		this.sdMap = sdMap;
	}
	public HashMap<String, List<DessertVO>> getSddMap() {
		return sddMap;
	}
	public void setSddMap(HashMap<String, List<DessertVO>> sddMap) {
		this.sddMap = sddMap;
	}
	
}
