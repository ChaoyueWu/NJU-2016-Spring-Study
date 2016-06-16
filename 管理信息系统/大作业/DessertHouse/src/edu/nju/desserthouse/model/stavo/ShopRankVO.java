package edu.nju.desserthouse.model.stavo;

import java.util.List;

public class ShopRankVO {
	public List<ShopYearRankItemVO> syrList;
	public List<DistrictYearRankVO> dyrList;
	public ShopRankVO(List<ShopYearRankItemVO> syrList, List<DistrictYearRankVO> dyrList) {
		super();
		this.syrList = syrList;
		this.dyrList = dyrList;
	}
	
}
