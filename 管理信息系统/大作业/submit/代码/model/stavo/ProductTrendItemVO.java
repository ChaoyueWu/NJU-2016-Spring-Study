package edu.nju.desserthouse.model.stavo;

//商品每天的销售总数&总金额
public class ProductTrendItemVO {
	public String date; 
	public int amount;
	public double total;
	public ProductTrendItemVO(){}
	public ProductTrendItemVO(String date, int amount, double total) {
		super();
		this.date = date;
		this.amount = amount;
		this.total = total;
	}
	
}
