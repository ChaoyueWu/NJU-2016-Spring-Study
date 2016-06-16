package edu.nju.desserthouse.model.stavo;

import java.util.List;

import edu.nju.desserthouse.model.District;
import edu.nju.desserthouse.model.Shop;

public class ShopStaVO {
	public List<District> disList;
	public List<Shop> shopList;
	public List<ShopStaItemVO> ssiList;
	public InValidAnalysis inValidAnalysis;
	public ShopStaVO(){}
	public ShopStaVO(List<District> disList, List<Shop> shopList, List<ShopStaItemVO> ssiList,
			InValidAnalysis inValidAnalysis) {
		super();
		this.disList = disList;
		this.shopList = shopList;
		this.ssiList = ssiList;
		this.inValidAnalysis = inValidAnalysis;
	}
	
	
}
