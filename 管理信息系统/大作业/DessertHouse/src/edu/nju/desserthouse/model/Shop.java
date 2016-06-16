package edu.nju.desserthouse.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="shop")
public class Shop implements Serializable{
	@Id
	private int sid;
	private String address;
	private String sname;
	private String stel;
	private String openTime;
	private int disid;
	private String disname;
	
	public Shop(){}

	public Shop(int sid, String address, String sname, String stel, String openTime, int disid, String disname) {
		super();
		this.sid = sid;
		this.address = address;
		this.sname = sname;
		this.stel = stel;
		this.openTime = openTime;
		this.disid = disid;
		this.disname = disname;
	}

	public Shop(int sid, String address, String sname) {
		super();
		this.sid = sid;
		this.address = address;
		this.sname = sname;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getStel() {
		return stel;
	}

	public void setStel(String stel) {
		this.stel = stel;
	}

	public String getOpenTime() {
		return openTime;
	}

	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}

	public int getDisid() {
		return disid;
	}

	public void setDisid(int disid) {
		this.disid = disid;
	}

	public String getDisname() {
		return disname;
	}

	public void setDisname(String disname) {
		this.disname = disname;
	}
	
	
}
