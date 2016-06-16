package edu.nju.desserthouse.model.stavo;

public class AutoGeneratingPlanItem {
	public int did;
	public String dname;
	public int amount;
	public int price;
	public AutoGeneratingPlanItem(){}
	public AutoGeneratingPlanItem(int did, String dname, int amount, int price) {
		super();
		this.did = did;
		this.dname = dname;
		this.amount = amount;
		this.price = price;
	}
	
}
