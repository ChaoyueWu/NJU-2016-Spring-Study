package edu.nju.desserthouse.model.stavo;

public class MemberMonthStaVO {
	public int cid;
	public int deal;
	public double total;
	public int lastDeal;
	public double lastTotal;
	public double percent;
	public MemberMonthStaVO(){}
	public MemberMonthStaVO(int cid, int deal, double total, int lastDeal, double lastTotal, double percent) {
		super();
		this.cid = cid;
		this.deal = deal;
		this.total = total;
		this.lastDeal = lastDeal;
		this.lastTotal = lastTotal;
		this.percent = percent;
	}
	
	
}
