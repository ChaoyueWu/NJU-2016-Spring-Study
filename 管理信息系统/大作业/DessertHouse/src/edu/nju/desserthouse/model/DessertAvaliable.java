package edu.nju.desserthouse.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dessertavaliable")
public class DessertAvaliable implements Serializable{
	@Id
	private int daid;
	private int sid;
	private Date date;
	private int did;
	private int amount;
	private double price;
	
	public DessertAvaliable(){}
	public DessertAvaliable(int daid, int sid, Date date, int did, int amount, double price) {
		super();
		this.daid = daid;
		this.sid = sid;
		this.date = date;
		this.did = did;
		this.amount = amount;
		this.price = price;
	}
	public int getDaid() {
		return daid;
	}
	public void setDaid(int daid) {
		this.daid = daid;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
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
