package edu.nju.desserthouse.service;

import edu.nju.desserthouse.model.stavo.ProductStaVO;

/*
 * 从地区的角度统计
 * TOP5商品统计-柱状图&商品销售一览-列表
 * 商品种类统计-饼图&商品种类中具体商品统计-列表
 * 在此处包装成VO
 * 增加针对某商品的走势分析
 */
public interface ProductStaService {
//商品统计

	//商品统计
	public ProductStaVO getProductStaVO();
}
