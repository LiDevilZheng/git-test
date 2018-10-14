package com.yimaisc.entity;

import java.io.Serializable;

/**
 *
 *@author 栗子
 *@description 
 */
public class Detail implements Serializable{
	private int id;
	private String oid;
	private int pid;
	private int quantity;
	private double cost;
	
	//商品信息
	private String name;
	private String pic;
	private double price;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public Detail() {
		// TODO Auto-generated constructor stub
	}
	public Detail(int id,String oid, int pid, int quantity, double cost,
			String name, String pic, double price) {
		super();
		this.id=id;
		this.oid = oid;
		this.pid = pid;
		this.quantity = quantity;
		this.cost = cost;
		this.name = name;
		this.pic = pic;
		this.price = price;
	}
	public Detail(String oid, int pid, int quantity, double cost) {
		super();
		this.oid = oid;
		this.pid = pid;
		this.quantity = quantity;
		this.cost = cost;
	}
	public Detail(int id, String oid, int pid, int quantity, double cost) {
		super();
		this.id = id;
		this.oid = oid;
		this.pid = pid;
		this.quantity = quantity;
		this.cost = cost;
	}
}
