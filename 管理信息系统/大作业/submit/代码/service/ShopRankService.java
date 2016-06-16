package edu.nju.desserthouse.service;

import edu.nju.desserthouse.model.stavo.ShopRankVO;

public interface ShopRankService {
//返回每个店铺和每个区域的总销售单数和销售金额,店铺显示其所属区域，按降序排序。今年统计和本月统计（先这样，之后可以本月和上月）增加平均线？
	public ShopRankVO getShopRankVO(int choice);
}
