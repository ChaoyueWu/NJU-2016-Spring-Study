package edu.nju.desserthouse.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="paymentrecord")
public class PaymentRecord implements Serializable{
	@Id
	private int prid;
	private int cid;
	private Timestamp date;
	private int bcid;
	private double amount;
	
	public PaymentRecord(){}
	public PaymentRecord(int prid, int cid, Timestamp date, int bcid, double amount) {
		this.prid = prid;
		this.cid = cid;
		this.date = date;
		this.bcid = bcid;
		this.amount = amount;
	}
	
	public int getPrid() {
		return prid;
	}
	public void setPrid(int prid) {
		this.prid = prid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public int getBcid() {
		return bcid;
	}
	public void setBcid(int bcid) {
		this.bcid = bcid;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	

}
