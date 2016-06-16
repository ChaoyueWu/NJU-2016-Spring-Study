package edu.nju.desserthouse.model.stavo;
/*
 * 地区商品统计VO
 * 所有地区总计和具体每个地区总计都用此
 */
public class DisProductStaVO {
	public String product;
	public int pid;
	public String category;
	public int amount;
	public double sum;
	public DisProductStaVO(){}
	public DisProductStaVO(String product, int pid, String category, int amount, double sum) {
		super();
		this.product = product;
		this.pid = pid;
		this.category = category;
		this.amount = amount;
		this.sum = sum;
	}
	
}
