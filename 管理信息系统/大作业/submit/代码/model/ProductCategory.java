package edu.nju.desserthouse.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productcategory")
public class ProductCategory implements Serializable{
	@Id
	private int pcid;
	private String pcname;
	private int ppcid;
	public ProductCategory(){}
	public ProductCategory(int pcid, String pcname, int ppcid) {
		super();
		this.pcid = pcid;
		this.pcname = pcname;
		this.ppcid = ppcid;
	}
	public int getPcid() {
		return pcid;
	}
	public void setPcid(int pcid) {
		this.pcid = pcid;
	}
	public String getPcname() {
		return pcname;
	}
	public void setPcname(String pcname) {
		this.pcname = pcname;
	}
	public int getPpcid() {
		return ppcid;
	}
	public void setPpcid(int ppcid) {
		this.ppcid = ppcid;
	}
	
}
