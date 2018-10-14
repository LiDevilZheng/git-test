package com.yimaisc.entity;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 *@author 栗子
 *@description 
 */
public class User implements Serializable{
	private String id;
	private String name;
	private String password;
	private String sex;
	private Date birthday;
	private String identity;
	private String email;
	private String mobile;
	private String address;
	private int delete;
	private int status;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(String id, String name, String password, String sex,
			Date birthday, String identity, String email, String mobile,
			String address, int delete, int status) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.birthday = birthday;
		this.identity = identity;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
		this.delete = delete;
		this.status = status;
	}
}
