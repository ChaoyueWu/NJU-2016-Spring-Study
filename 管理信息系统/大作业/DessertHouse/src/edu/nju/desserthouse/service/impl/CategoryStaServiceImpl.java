package edu.nju.desserthouse.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.dao.DistrictDao;
import edu.nju.desserthouse.dao.OrderDao;
import edu.nju.desserthouse.dao.ProductCategoryDao;
import edu.nju.desserthouse.dao.ShopDao;
import edu.nju.desserthouse.model.District;
import edu.nju.desserthouse.model.ProductCategory;
import edu.nju.desserthouse.model.Shop;
import edu.nju.desserthouse.model.stavo.CategoryOnlyStaVO;
import edu.nju.desserthouse.model.stavo.CategoryStaVO;
import edu.nju.desserthouse.model.stavo.CateoryProductStaVO;
import edu.nju.desserthouse.model.stavo.ProductOnlyStaVO;
import edu.nju.desserthouse.service.CategoryStaService;
import edu.nju.desserthouse.sort.CateoryProductStaVOSortByAmount;

public class CategoryStaServiceImpl implements CategoryStaService{
	@Autowired
	private OrderDao orderDao;
	private DistrictDao districtDao;
	private ShopDao shopDao;
	private ProductCategoryDao productCategoryDao;
	
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

	public ProductCategoryDao getProductCategoryDao() {
		return productCategoryDao;
	}

	public void setProductCategoryDao(ProductCategoryDao productCategoryDao) {
		this.productCategoryDao = productCategoryDao;
	}

	@Override
	//在这里获得category并做处理
	//——获得所有的商品统计，然后再搞个hashmap好了 结合category list对应展示,展示的都是最详细的分类，因此蛋糕list要做处理
	public CategoryStaVO getCategorySta(int sid, int disid) {
		List<Shop> shopList = new ArrayList<Shop>();
		List<District> disList = districtDao.getAllDistrictList();
		List<Shop> sl = shopDao.getAllShopList();
		
		List<ProductCategory> pcList = productCategoryDao.getAllProductCategoryList();
		List<CategoryOnlyStaVO> coList;
		//to be 进一步处理
		List<CateoryProductStaVO> cpList;
		//如果是所有地区总计
		if(disid==0){
			coList = orderDao.getCategoryOnlyStaVOList();
			cpList = orderDao.getCateoryProductStaVOList();
			//shop只有一个总的
			Shop s = new Shop();
			s.setSid(0);
			s.setSname("所有店铺");
			shopList.add(s);
		}
		//某地区总计
		else if(disid!=0&&sid==0){
			coList = orderDao.getCategoryOnlyStaVOList(disid);
			cpList = orderDao.getCateoryProductStaVOList(disid);
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
		}
		//某店铺总计
		else{
			coList = orderDao.getCategoryOnlyStaVOList(disid,sid);
			cpList = orderDao.getCateoryProductStaVOList(disid,sid);
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
		}
		//排序
		Collections.sort(cpList, new CateoryProductStaVOSortByAmount());
		//按商品分类分组
		HashMap<String,List<ProductOnlyStaVO>> cpMap = new HashMap<String,List<ProductOnlyStaVO>>();
		Iterator<ProductCategory> it = pcList.iterator();
		while (it.hasNext())
		{
			ProductCategory pc = it.next();
			if(pc.getPcid()!= 2){
				List<ProductOnlyStaVO> list = new ArrayList<ProductOnlyStaVO>();
				cpMap.put(pc.getPcname(), list);
			}else{
				it.remove();
			}

		}
		/* wrong
		for(ProductCategory pc:pcList){
			if(pc.getPcid()!= 2){
				List<ProductOnlyStaVO> list = new ArrayList<ProductOnlyStaVO>();
				cpMap.put(pc.getPcname(), list);
			}else{
				pcList.remove(pc);
			}
		}
		*/
		for(CateoryProductStaVO cpvo:cpList){
			ProductOnlyStaVO posvo = new ProductOnlyStaVO();
			posvo.did = cpvo.did;
			posvo.dname = cpvo.dname;
			posvo.amount = cpvo.amount;
			posvo.sum = cpvo.sum;
			cpMap.get(cpvo.pcname).add(posvo);
		}
		CategoryStaVO csvo = new CategoryStaVO(disList,shopList,pcList,coList,cpMap);
		return csvo;
	}

}
