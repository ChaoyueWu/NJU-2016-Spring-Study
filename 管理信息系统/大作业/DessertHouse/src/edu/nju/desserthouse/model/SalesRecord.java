package edu.nju.desserthouse.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="salesrecord")
public class SalesRecord implements Serializable{
	
	@Id
	private int srid;
	private int sid;
	private int scid;
	private Timestamp salesTime;
	private int did;
	private int amount;
	private double total;
	private double realTotal;
	private int isOnline;
	private Date takeDate;
	private int isValid;
	private int cid;
	private String discountMessage;
	
	public SalesRecord(){}
	public SalesRecord(int srid, int sid, int scid, Timestamp salesTime, int did, int amount, double total,
			double realTotal, int isOnline, Date takeDate, int isValid, int cid, String discountMessage) {
		super();
		this.srid = srid;
		this.sid = sid;
		this.scid = scid;
		this.salesTime = salesTime;
		this.did = did;
		this.amount = amount;
		this.total = total;
		this.realTotal = realTotal;
		this.isOnline = isOnline;
		this.takeDate = takeDate;
		this.isValid = isValid;
		this.cid = cid;
		this.discountMessage = discountMessage;
	}
	public int getSrid() {
		return srid;
	}
	public void setSrid(int srid) {
		this.srid = srid;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getScid() {
		return scid;
	}
	public void setScid(int scid) {
		this.scid = scid;
	}
	public Timestamp getSalesTime() {
		return salesTime;
	}
	public void setSalesTime(Timestamp salesTime) {
		this.salesTime = salesTime;
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
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getRealTotal() {
		return realTotal;
	}
	public void setRealTotal(double realTotal) {
		this.realTotal = realTotal;
	}
	public int getIsOnline() {
		return isOnline;
	}
	public void setIsOnline(int isOnline) {
		this.isOnline = isOnline;
	}
	public Date getTakeDate() {
		return takeDate;
	}
	public void setTakeDate(Date takeDate) {
		this.takeDate = takeDate;
	}
	public int getIsValid() {
		return isValid;
	}
	public void setIsValid(int isValid) {
		this.isValid = isValid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getDiscountMessage() {
		return discountMessage;
	}
	public void setDiscountMessage(String discountMessage) {
		this.discountMessage = discountMessage;
	}
	
}
