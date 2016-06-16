package edu.nju.desserthouse.model.stavo;

import java.util.HashMap;
import java.util.List;

import edu.nju.desserthouse.model.District;
import edu.nju.desserthouse.model.Shop;

public class ProductStaVO {
	public List<District> disList;
	public List<Shop> shopList;
	public List<DisProductStaVO> tdpList;
	public HashMap<String,List<DisProductStaVO>> dpMap;
	public HashMap<String, List<DisProductStaVO>> spMap;
	
	public ProductStaVO(){}

	public ProductStaVO(List<District> disList, List<Shop> shopList, List<DisProductStaVO> tdpList,
			HashMap<String, List<DisProductStaVO>> dpMap, HashMap<String, List<DisProductStaVO>> spMap) {
		super();
		this.disList = disList;
		this.shopList = shopList;
		this.tdpList = tdpList;
		this.dpMap = dpMap;
		this.spMap = spMap;
	}

	
	
}
