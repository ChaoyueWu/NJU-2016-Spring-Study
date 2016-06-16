package edu.nju.desserthouse.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="district")
public class District  implements Serializable{
	@Id
	private int disid;
	private String disname;
	public District(){}
	public District(int disid, String disname) {
		super();
		this.disid = disid;
		this.disname = disname;
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
