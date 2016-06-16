package edu.nju.desserthouse.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.dao.OrderDao;
import edu.nju.desserthouse.model.stavo.DistrictYearRankVO;
import edu.nju.desserthouse.model.stavo.ShopRankVO;
import edu.nju.desserthouse.model.stavo.ShopYearRankItemVO;
import edu.nju.desserthouse.service.ShopRankService;

public class ShopRankServiceImpl implements ShopRankService {
	@Autowired
	private OrderDao orderDao;

	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	public ShopRankVO getShopRankVO(int choice) {
		 List<ShopYearRankItemVO> syrList;
		 List<DistrictYearRankVO> dyrList;
		 //choice = 0表示年统计
		// if(choice==0){
			 syrList = orderDao.getShopYearRank();
			 dyrList = orderDao.getDistrictYearRank();
		// }else{
			 //月统计暂时搁浅
		// }
			 ShopRankVO srvo = new ShopRankVO(syrList,dyrList);
		return srvo;
	}

}
