package com.yimaisc.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 *@author 栗子
 *@description 
 */
public class Comment implements Serializable{
	private int id;
	private String content;
	private Timestamp createTime;
	private String reply;
	private Timestamp replyTime;
	private String nickName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public Timestamp getReplyTime() {
		return replyTime;
	}
	public void setReplyTime(Timestamp replyTime) {
		this.replyTime = replyTime;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public Comment() {
		// TODO Auto-generated constructor stub
	}
	public Comment(int id, String content, Timestamp createTime, String reply,
			Timestamp replyTime, String nickName) {
		super();
		this.id = id;
		this.content = content;
		this.createTime = createTime;
		this.reply = reply;
		this.replyTime = replyTime;
		this.nickName = nickName;
	}
}
