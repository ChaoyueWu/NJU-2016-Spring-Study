package edu.nju.desserthouse.model.stavo;

public class ProductOnlyStaVO {
	public int did;
	public String dname;
	public int amount;
	public double sum;
	public ProductOnlyStaVO(){}
	public ProductOnlyStaVO(int did, String dname, int amount, double sum) {
		super();
		this.did = did;
		this.dname = dname;
		this.amount = amount;
		this.sum = sum;
	}
	
}
