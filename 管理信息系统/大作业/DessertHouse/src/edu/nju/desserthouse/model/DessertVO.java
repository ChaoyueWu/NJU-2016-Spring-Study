package edu.nju.desserthouse.model;

public class DessertVO {
	private int daid;
	private int did;
	private String name;
	private String img;
	private int amount;
	private double price;
	public DessertVO(){}
	public DessertVO(int daid, int did, String name, String img, int amount, double price) {
		super();
		this.daid = daid;
		this.did = did;
		this.name = name;
		this.img = img;
		this.amount = amount;
		this.price = price;
	}
	public int getDaid() {
		return daid;
	}
	public void setDaid(int daid) {
		this.daid = daid;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
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
