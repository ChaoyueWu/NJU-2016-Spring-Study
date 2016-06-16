package edu.nju.desserthouse.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="order")
public class Order implements Serializable{
	@Id
	private int oid;
	private int sid;
	private int scid;
	private Timestamp orderTime;
	private double total;
	private double realToral;
	private int isOnline;
	private Date takeDate;
	private String takeTime;
	private int isValid;
	private int cid;
	private String discountMessage;
	private String seat;
	private int verification;
	public Order(){}
	public Order(int oid, int sid, int scid, Timestamp orderTime, double total, double realToral, int isOnline,
			Date takeDate, String takeTime, int isValid, int cid, String discountMessage, String seat,
			int verification) {
		super();
		this.oid = oid;
		this.sid = sid;
		this.scid = scid;
		this.orderTime = orderTime;
		this.total = total;
		this.realToral = realToral;
		this.isOnline = isOnline;
		this.takeDate = takeDate;
		this.takeTime = takeTime;
		this.isValid = isValid;
		this.cid = cid;
		this.discountMessage = discountMessage;
		this.seat = seat;
		this.verification = verification;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
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
	public Timestamp getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Timestamp orderTime) {
		this.orderTime = orderTime;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getRealToral() {
		return realToral;
	}
	public void setRealToral(double realToral) {
		this.realToral = realToral;
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
	public String getTakeTime() {
		return takeTime;
	}
	public void setTakeTime(String takeTime) {
		this.takeTime = takeTime;
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
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	public int getVerification() {
		return verification;
	}
	public void setVerification(int verification) {
		this.verification = verification;
	}
	
}
