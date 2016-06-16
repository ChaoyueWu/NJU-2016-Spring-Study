package edu.nju.desserthouse.model.stavo;

import java.util.List;

import edu.nju.desserthouse.model.Dessert;
import edu.nju.desserthouse.model.District;
import edu.nju.desserthouse.model.Shop;

public class ProductTrendVO {
	public List<District> disList;
	public List<Shop> shopList;
	public List<Dessert> dessertList;
	public List<ProductTrendItemVO> ptiList;
	public ProductTrendVO(){}
	public ProductTrendVO(List<District> disList, List<Shop> shopList, List<Dessert> dessertList,
			List<ProductTrendItemVO> ptiList) {
		super();
		this.disList = disList;
		this.shopList = shopList;
		this.dessertList = dessertList;
		this.ptiList = ptiList;
	}
	
}
