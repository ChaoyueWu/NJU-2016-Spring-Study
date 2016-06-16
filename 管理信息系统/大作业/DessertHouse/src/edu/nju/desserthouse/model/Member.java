package edu.nju.desserthouse.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="member")
public class Member implements Serializable{
	@Id
	private int cid;
	private Date birth;
	private int sex;
	private String address;
	private int state;
	private Date handleDate;
	private double balance;
	private int level;
	private double credit;
	private double discount;
	private int bcid;
	
	public Member(){}

	public Member(int cid, Date birth, int sex, String address, int state, Date handleDate, double balance, int level,
			double credit, double discount, int bcid) {
		this.cid = cid;
		this.birth = birth;
		this.sex = sex;
		this.address = address;
		this.state = state;
		this.handleDate = handleDate;
		this.balance = balance;
		this.level = level;
		this.credit = credit;
		this.discount = discount;
		this.bcid = bcid;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Date getHandleDate() {
		return handleDate;
	}

	public void setHandleDate(Date handleDate) {
		this.handleDate = handleDate;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public double getCredit() {
		return credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public int getBcid() {
		return bcid;
	}

	public void setBcid(int bcid) {
		this.bcid = bcid;
	}
	
}
