package edu.nju.desserthouse.model.stavo;

public class CateoryProductStaVO {
	public int pcid;
	public String pcname;
	public int did;
	public String dname;
	public int amount;
	public double sum;
	public CateoryProductStaVO(){}
	public CateoryProductStaVO(int pcid, String pcname, int did, String dname, int amount, double sum) {
		super();
		this.pcid = pcid;
		this.pcname = pcname;
		this.did = did;
		this.dname = dname;
		this.amount = amount;
		this.sum = sum;
	}
	
}
