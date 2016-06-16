package edu.nju.desserthouse.model.stavo;

public class ShopProductStaVO {
	public String shop;
	public int pid;
	public String product;
	public String category;
	public int amount;
	public double sum;
	public ShopProductStaVO(){}
	public ShopProductStaVO(String shop, int pid, String product, String category, int amount, double sum) {
		super();
		this.shop = shop;
		this.pid = pid;
		this.product = product;
		this.category = category;
		this.amount = amount;
		this.sum = sum;
	}
	
}
