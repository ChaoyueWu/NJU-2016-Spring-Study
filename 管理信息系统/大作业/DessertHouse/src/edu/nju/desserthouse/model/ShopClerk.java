package edu.nju.desserthouse.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="shopclerk")
public class ShopClerk implements Serializable{
	
	@Id
	private int scid;
	private int sid;
	private String name;
	
	public ShopClerk(){}
	public ShopClerk(int scid, int sid, String name) {
		super();
		this.scid = scid;
		this.sid = sid;
		this.name = name;
	}
	public int getScid() {
		return scid;
	}
	public void setScid(int scid) {
		this.scid = scid;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
