package edu.nju.desserthouse.model.stavo;

import java.sql.Date;

public class ShopStaItemVO {
	public String date; 
	public int onlineDeal;
	public int totalDeal;
	public double total;
	public double realTotal;
	public int notMemberDeal = 0;
	public double notMemberSum = 0;
	public ShopStaItemVO(){}
	public ShopStaItemVO(String date, int onlineDeal, int totalDeal, double total, double realTotal, int notMemberDeal,
			double notMemberSum) {
		super();
		this.date = date;
		this.onlineDeal = onlineDeal;
		this.totalDeal = totalDeal;
		this.total = total;
		this.realTotal = realTotal;
		this.notMemberDeal = notMemberDeal;
		this.notMemberSum = notMemberSum;
	}
	
	
	
}
