package edu.nju.desserthouse.model.stavo;

public class CategoryOnlyStaVO {
	public int pcid;
	public String pcname;
	public int amount;
	public double sum;
	public CategoryOnlyStaVO(){}
	public CategoryOnlyStaVO(int pcid, String pcname, int amount, double sum) {
		super();
		this.pcid = pcid;
		this.pcname = pcname;
		this.amount = amount;
		this.sum = sum;
	}
	
}
