package com.yimaisc.entity;

import java.io.Serializable;

/**
 *
 *@author 栗子
 *@description 
 */
public class Category implements Serializable{
	private int id;
	private String name;
	private int parentId;
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
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public Category() {
		// TODO Auto-generated constructor stub
	}
	public Category(int id, String name, int parentId) {
		super();
		this.id = id;
		this.name = name;
		this.parentId = parentId;
	}
}
