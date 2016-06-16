package edu.nju.desserthouse.model;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

public class PlanVO {

	private int pid;
	private int sid;
	private Date startDate;
	private HashMap<Date,List<Goods>> map;
	
	public PlanVO(){}

	public PlanVO(int pid, int sid, Date startDate, HashMap<Date, List<Goods>> map) {
		super();
		this.pid = pid;
		this.sid = sid;
		this.startDate = startDate;
		this.map = map;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
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

	public HashMap<Date, List<Goods>> getMap() {
		return map;
	}

	public void setMap(HashMap<Date, List<Goods>> map) {
		this.map = map;
	}
	
	
}
