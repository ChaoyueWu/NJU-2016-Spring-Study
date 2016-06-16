package edu.nju.desserthouse.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.dao.DistrictDao;
import edu.nju.desserthouse.dao.OrderDao;
import edu.nju.desserthouse.dao.ShopDao;
import edu.nju.desserthouse.model.District;
import edu.nju.desserthouse.model.Shop;
import edu.nju.desserthouse.model.stavo.InValidAnalysis;
import edu.nju.desserthouse.model.stavo.ShopStaItemVO;
import edu.nju.desserthouse.model.stavo.ShopStaVO;
import edu.nju.desserthouse.service.ShopStaService;

public class ShopStaServiceImpl implements ShopStaService{
	@Autowired
	private OrderDao orderDao;
	private DistrictDao districtDao;
	private ShopDao shopDao;
	public OrderDao getOrderDao() {
		return orderDao;
	}
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	public DistrictDao getDistrictDao() {
		return districtDao;
	}
	public void setDistrictDao(DistrictDao districtDao) {
		this.districtDao = districtDao;
	}
	public ShopDao getShopDao() {
		return shopDao;
	}
	public void setShopDao(ShopDao shopDao) {
		this.shopDao = shopDao;
	}
	@Override
	public ShopStaVO getShopSta(int sid, int disid, int choice) {
		List<Shop> shopList = new ArrayList<Shop>();
		List<District> disList = districtDao.getAllDistrictList();
		List<Shop> sl = shopDao.getAllShopList();
		List<ShopStaItemVO> ssiList = new ArrayList<ShopStaItemVO>();
		InValidAnalysis inValidAnalysis ;
		//只针对地区总计
		if(disid==0){
			inValidAnalysis = orderDao.getInvalidOrderAnalysis();
			//shop只有一个总的
			Shop s = new Shop();
			s.setSid(0);
			s.setSname("所有店铺");
			shopList.add(s);
			if(choice==0){
				//choice==0代表天统计
				ssiList = orderDao.getDayShopStaItemVOList();
			}else if(choice == 1){
				//choice==1代表月统计
				ssiList = orderDao.getMonthShopStaItemVOList();
			}
		}else if(disid!=0&&sid==0){
			inValidAnalysis = orderDao.getInvalidOrderAnalysis(disid);
			//shop对应到具体的地区
			Shop s = new Shop();
			s.setSid(0);
			s.setSname("所有店铺");
			shopList.add(s);
			for(Shop shop:sl){
				if(shop.getDisid()==disid){
					shopList.add(shop);
				}
			}
			//针对某地区总计
			if(choice==0){
				//天统计
				ssiList = orderDao.getDayShopStaItemVOList(disid);
			}else if(choice == 1){
				//choice==1代表月统计
				ssiList = orderDao.getMonthShopStaItemVOList(disid);
			}
		}else{
			inValidAnalysis = orderDao.getInvalidOrderAnalysis(disid,sid);
			//shop对应到具体的地区
			Shop s = new Shop();
			s.setSid(0);
			s.setSname("所有店铺");
			shopList.add(s);
			for(Shop shop:sl){
				if(shop.getDisid()==disid){
					shopList.add(shop);
				}
			}
			//针对某店铺总计
			if(choice==0){
				//天统计
				ssiList = orderDao.getDayShopStaItemVOList(disid, sid);
			}else if(choice == 1){
				//choice==1代表月统计
				ssiList = orderDao.getMonthShopStaItemVOList(disid, sid);
			}
		}
		ShopStaVO ssvo = new ShopStaVO(disList,shopList,ssiList,inValidAnalysis);
		return ssvo;
	}
	
}
