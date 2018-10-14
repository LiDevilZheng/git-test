package com.jbit.dto;

import java.util.List;

import com.jbit.entity.SmbmsUser;

/**
 *@author 栗子
 *@description 
 */
public class SmbmsUserParams {	
	private Integer pageNo=1;
	private Integer pageSize=5;
	private String userName;
	private Integer userRole=0;
	private Integer from;
	private Integer offset;
	private Integer count;
	private Integer countPage;
	private List<SmbmsUser> li;
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
			this.count = count;
	}
	public Integer getCountPage() {
		return countPage;
	}
	public void setCountPage(Integer countPage) {
		this.countPage = countPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		if(pageSize>0)
		this.pageSize = pageSize;
	}
	public Integer getPageNo() {
		if(pageNo>countPage){
			pageNo=countPage;
		}
		if(pageNo<1){
			pageNo=1;
		}
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		if(pageNo>0)
		this.pageNo = pageNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getRoleName() {
		return userRole;
	}
	public void setRoleName(Integer roleName) {
		this.userRole = roleName;
	}
	public Integer getFrom() {
		from=(pageNo-1)*pageSize;
		return from;
	}
	public void setFrom(Integer from) {
		if(from>0)
		this.from = from;
	}
	public Integer getOffset() {
		offset=pageSize;
		return offset;
	}
	public void setOffset(Integer offset) {
		if(offset>0)
		this.offset = offset;
	}
	public Integer getUserRole() {
		return userRole;
	}
	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}
	public List<SmbmsUser> getLi() {
		return li;
	}
	public void setLi(List<SmbmsUser> li) {
		this.li = li;
	}
	public SmbmsUserParams() {
		// TODO Auto-generated constructor stub
	}
	public SmbmsUserParams(Integer pageNo, Integer pageSize, String userName,
			Integer userRole, Integer from, Integer offset, Integer count,
			Integer countPage, List<SmbmsUser> li) {
		super();
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.userName = userName;
		this.userRole = userRole;
		this.from = from;
		this.offset = offset;
		this.count = count;
		this.countPage = countPage;
		this.li = li;
	}	
}
