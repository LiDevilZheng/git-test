package com.jbit.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 *@author 栗子
 *@description 供应商
 */
public class Provider implements Serializable{
	private Integer id;
	private String proCode;
	private String proName;
	private String proDesc;
	private String proContact;
	private String proPhone;
	private String proAddress;
	private String proFax;
	private Integer createdBy;//创建者id
	private Timestamp creationDate;
	private Timestamp modifyDate;
	private Integer modifyBy;//更新者id
	private String idPic;//营业执照
	private String workPic;//组织机构代码证
	public String getIdPic() {
		return idPic;
	}
	public void setIdPic(String idPic) {
		this.idPic = idPic;
	}
	public String getWorkPic() {
		return workPic;
	}
	public void setWorkPic(String workPic) {
		this.workPic = workPic;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProCode() {
		return proCode;
	}
	public void setProCode(String proCode) {
		this.proCode = proCode;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public String getProDesc() {
		return proDesc;
	}
	public void setProDesc(String proDesc) {
		this.proDesc = proDesc;
	}
	public String getProContact() {
		return proContact;
	}
	public void setProContact(String proContact) {
		this.proContact = proContact;
	}
	public String getProPhone() {
		return proPhone;
	}
	public void setProPhone(String proPhone) {
		this.proPhone = proPhone;
	}
	public String getProAddress() {
		return proAddress;
	}
	public void setProAddress(String proAddress) {
		this.proAddress = proAddress;
	}
	public String getProFax() {
		return proFax;
	}
	public void setProFax(String proFax) {
		this.proFax = proFax;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public Timestamp getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}
	public Timestamp getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}
	public Integer getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(Integer modifyBy) {
		this.modifyBy = modifyBy;
	}
	public Provider() {
		// TODO Auto-generated constructor stub
	}
	public Provider(Integer id, String proCode, String proName, String proDesc,
			String proContact, String proPhone, String proAddress,
			String proFax, Integer createdBy, Timestamp creationDate,
			Timestamp modifyDate, Integer modifyBy, String idPic, String workPic) {
		super();
		this.id = id;
		this.proCode = proCode;
		this.proName = proName;
		this.proDesc = proDesc;
		this.proContact = proContact;
		this.proPhone = proPhone;
		this.proAddress = proAddress;
		this.proFax = proFax;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
		this.modifyDate = modifyDate;
		this.modifyBy = modifyBy;
		this.idPic = idPic;
		this.workPic = workPic;
	}
}
