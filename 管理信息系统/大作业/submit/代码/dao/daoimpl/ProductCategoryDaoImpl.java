package edu.nju.desserthouse.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.nju.desserthouse.dao.BaseDao;
import edu.nju.desserthouse.dao.ProductCategoryDao;
import edu.nju.desserthouse.model.ProductCategory;

@Repository
public class ProductCategoryDaoImpl implements ProductCategoryDao{

	@Autowired
	private BaseDao baseDao;
	
	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public ProductCategory find(int id) {
		ProductCategory pc = (ProductCategory)baseDao.load(ProductCategory.class, id);
		return pc;
	}

	@Override
	public List<ProductCategory> getAllProductCategoryList() {
		@SuppressWarnings("unchecked")
		List<ProductCategory> list = baseDao.getAllList(ProductCategory.class);
		return list;
	}

	@Override
	public List<ProductCategory> getAllChildrenProductCategoryList(int ppcid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductCategory findParent(int pcid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductCategory> getAllParentProductCategoryList() {
		// TODO Auto-generated method stub
		return null;
	}
	
}