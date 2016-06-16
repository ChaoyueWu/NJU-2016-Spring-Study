package edu.nju.desserthouse.model.stavo;

public class ShopYearRankItemVO {
	public int sid;
	public String sname;
	public String disname;
	public int deal;
	public double sum;
	public ShopYearRankItemVO(){}
	public ShopYearRankItemVO(int sid, String sname, String disname, int deal, double sum) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.disname = disname;
		this.deal = deal;
		this.sum = sum;
	}
	
}
