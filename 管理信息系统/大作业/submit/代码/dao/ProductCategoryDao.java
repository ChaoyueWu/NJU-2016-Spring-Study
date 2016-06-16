package edu.nju.desserthouse.dao;

import java.util.List;

import edu.nju.desserthouse.model.ProductCategory;

/*
 * 商品分类表
 * 需要的情况：在查看商品时，可以根据商品的分类进行查看 此时就需要商品分类进行选择
 * 查看某个大类的小分类
 * 查看某个小类所属的大类
 */
public interface ProductCategoryDao {
	/*
	 * 根据id查找ProductCategory对象,如果找到则返回这个对象,否则返回null
	 */
	public ProductCategory find(int id);
	/*
	 * 获得所有元组
	 */
	public List<ProductCategory> getAllProductCategoryList();
	/*
	 * 获得某父类的所有子类元组
	 */
	public List<ProductCategory> getAllChildrenProductCategoryList(int ppcid);
	/*
	 * 根据id查找ProductCategory对应的父类对象,如果找到则返回这个对象,否则返回null
	 */
	public ProductCategory findParent(int pcid);
	/*
	 * 获得所有最上层父类元组
	 */
	public List<ProductCategory> getAllParentProductCategoryList();
}
