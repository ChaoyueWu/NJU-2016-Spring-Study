package edu.nju.desserthouse.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="promotion")
public class Promotion implements Serializable{
	@Id
	private int id;
	private String name;
	private int value;
	private int require;
	private Date deadline;
	private int memtype;
	
	public Promotion(){}
	public Promotion(int id, String name, int value, int require, Date deadline, int memtype) {
		super();
		this.id = id;
		this.name = name;
		this.value = value;
		this.require = require;
		this.deadline = deadline;
		this.memtype = memtype;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getRequire() {
		return require;
	}
	public void setRequire(int require) {
		this.require = require;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public int getMemtype() {
		return memtype;
	}
	public void setMemtype(int memtype) {
		this.memtype = memtype;
	}
	
}
