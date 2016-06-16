package edu.nju.desserthouse.model.stavo;

import java.util.HashMap;
import java.util.List;

import edu.nju.desserthouse.model.District;
import edu.nju.desserthouse.model.ProductCategory;
import edu.nju.desserthouse.model.Shop;

public class CategoryStaVO {
	public List<District> disList;
	public List<Shop> shopList;
	public List<ProductCategory> pcList;
	public List<CategoryOnlyStaVO> coList;
	public HashMap<String,List<ProductOnlyStaVO>> cpMap;
	public CategoryStaVO(){}
	public CategoryStaVO(List<District> disList, List<Shop> shopList, List<ProductCategory> pcList,
			List<CategoryOnlyStaVO> coList, HashMap<String, List<ProductOnlyStaVO>> cpMap) {
		super();
		this.disList = disList;
		this.shopList = shopList;
		this.pcList = pcList;
		this.coList = coList;
		this.cpMap = cpMap;
	}
	
}
