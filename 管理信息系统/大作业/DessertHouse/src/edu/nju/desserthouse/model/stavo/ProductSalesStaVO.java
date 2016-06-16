package edu.nju.desserthouse.model.stavo;
//ProductStaService中针对商品统计时从数据库中获得的数据集条目
//地区-店铺-商品-种类-个数-金额
public class ProductSalesStaVO {
	public String district;
	public String shop;
	public int sid;
	public String product;
	public int pid;
	public String category;
	public int amount;
	public double sum;
	
	public ProductSalesStaVO(){}
	public ProductSalesStaVO(String district, String shop, int sid, String product, int pid, String category,
			int amount, double sum) {
		super();
		this.district = district;
		this.shop = shop;
		this.sid = sid;
		this.product = product;
		this.pid = pid;
		this.category = category;
		this.amount = amount;
		this.sum = sum;
	}
	
}
