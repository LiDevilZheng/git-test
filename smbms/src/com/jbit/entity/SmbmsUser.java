package com.jbit.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *
 *@author 栗子
 *@description 
 */
public class SmbmsUser implements Serializable{
	private Integer id;
	@NotEmpty(message="用户编码不能为空")
	private String userCode;//用户编码
	@NotEmpty(message="用户名称不能为空")
	private String userName;//用户名称
	private String userPassword;//用户密码
	private Integer gender;//性别（1：女、2：男）
	@DateTimeFormat(pattern="yyyy-MM-dd")
	//@JSONField(format="yyyy-MM-dd")//全局配置后可以不用写注解
	private Date birthday;//出生日期 ,加注解（请求）
	private Integer age;
	@Pattern(regexp="^((13[0-9])|(15[4,\\D])|(18[0,4-9]))\\d{8}$",message="请输入正确格式的手机号")
	private String phone;//手机
	private String address;//地址
	private Integer userRole;//用户角色（取自角色表-角色id）
	private Integer createdBy;//创建者（userId）
	private Timestamp creationDate;//创建时间
	private Integer modifyBy;//更新者（userId）
	private Timestamp modifyDate;//更新时间
	private String idPic="default.jpg";
	private String workPic="default.jpg";
	private String userRoleName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getUserRole() {
		return userRole;
	}
	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
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
	public Integer getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(Integer modifyBy) {
		this.modifyBy = modifyBy;
	}
	public Timestamp getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}
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
	public String getUserRoleName() {
		return userRoleName;
	}
	public void setUserRoleName(String userRoleName) {
		this.userRoleName = userRoleName;
	}
	public SmbmsUser() {
		// TODO Auto-generated constructor stub
	}
	public SmbmsUser(Integer id, String userCode, String userName,
			String userPassword, Integer gender, Date birthday, Integer age,
			String phone, String address, Integer userRole, Integer createdBy,
			Timestamp creationDate, Integer modifyBy, Timestamp modifyDate,
			String idPic, String workPic, String userRoleName) {
		super();
		this.id = id;
		this.userCode = userCode;
		this.userName = userName;
		this.userPassword = userPassword;
		this.gender = gender;
		this.birthday = birthday;
		this.age = age;
		this.phone = phone;
		this.address = address;
		this.userRole = userRole;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
		this.modifyBy = modifyBy;
		this.modifyDate = modifyDate;
		this.idPic = idPic;
		this.workPic = workPic;
		this.userRoleName = userRoleName;
	}
	@Override
	public String toString() {
		return "SmbmsUser [id=" + id + ", userCode=" + userCode + ", userName="
				+ userName + ", userPassword=" + userPassword + ", gender="
				+ gender + ", birthday=" + birthday + ", age=" + age
				+ ", phone=" + phone + ", address=" + address + ", userRole="
				+ userRole + ", createdBy=" + createdBy + ", creationDate="
				+ creationDate + ", modifyBy=" + modifyBy + ", modifyDate="
				+ modifyDate + ", idPic=" + idPic + ", workPic=" + workPic
				+ ", userRoleName=" + userRoleName + "]";
	}
}
