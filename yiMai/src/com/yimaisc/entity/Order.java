package com.yimaisc.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 *@author 栗子
 *@description 
 */
public class Order implements Serializable{
	private String id;
	private String userId;
	private String name;
	private String address;
	private Timestamp createTime;
	private double cost;
	private int delete;
	private int status;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public int getDelete() {
		return delete;
	}
	public void setDelete(int delete) {
		this.delete = delete;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Order() {
		// TODO Auto-generated constructor stub
	}
	public Order(String id, String userId, String name, String address,
			Timestamp createTime, double cost, int delete, int status) {
		super();
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.address = address;
		this.createTime = createTime;
		this.cost = cost;
		this.delete = delete;
		this.status = status;
	}
}
