package edu.nju.desserthouse.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="planlist")
public class PlanList implements Serializable{
	@Id
	private int plid;
	private int pid;
	private Date date;
	private int did;
	private int amount;
	private double price;
	
	public PlanList(){}
	public PlanList(int plid, int pid, Date date, int did, int amount, double price) {
		super();
		this.plid = plid;
		this.pid = pid;
		this.date = date;
		this.did = did;
		this.amount = amount;
		this.price = price;
	}
	public int getPlid() {
		return plid;
	}
	public void setPlid(int plid) {
		this.plid = plid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
