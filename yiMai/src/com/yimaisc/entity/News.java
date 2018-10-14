package com.yimaisc.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 *@author 栗子
 *@description 
 */
public class News implements Serializable{
	private int id;
	private String title;
	private String content;
	private Timestamp createTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public News() {
		// TODO Auto-generated constructor stub
	}
	public News(int id, String title, String content,
			Timestamp createTime) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.createTime = createTime;
	}
	
}
