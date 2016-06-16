package edu.nju.desserthouse.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="plan")
public class Plan implements Serializable{
	@Id
	private int pid;
	private int state;
	private int sid;
	private Date startDate;
	
	public Plan(){}
	public Plan(int pid, int state, int sid, Date startDate) {
		super();
		this.pid = pid;
		this.state = state;
		this.sid = sid;
		this.startDate = startDate;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	
}
