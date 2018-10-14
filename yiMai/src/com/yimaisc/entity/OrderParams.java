package com.yimaisc.entity;

import java.io.Serializable;

public class OrderParams implements Serializable{
	private String id;
	private String userId;
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
	public OrderParams() {
		// TODO Auto-generated constructor stub
	}
	public OrderParams(String id, String userId) {
		super();
		this.id = id;
		this.userId = userId;
	}
}
