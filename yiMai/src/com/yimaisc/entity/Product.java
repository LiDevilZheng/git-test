package com.yimaisc.entity;

import java.io.Serializable;

/**
 *
 *@author 栗子
 *@description 
 */
public class Product implements Serializable{
	private int id;
	private String name;
	private String description;
	private double price;
	private int stock;
	private int pid;
	private int cid;
	private String fileName;
	private int delete;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getDelete() {
		return delete;
	}
	public void setDelete(int delete) {
		this.delete = delete;
	}
	public Product() {
		// TODO Auto-generated constructor stub
	}
	public Product(int id, String name, String description, double price,
			int stock, int pid, int cid, String fileName, int delete) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.pid = pid;
		this.cid = cid;
		this.fileName = fileName;
		this.delete = delete;
	}
}
