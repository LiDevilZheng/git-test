package com.jbit.dto;

import java.util.List;

import com.jbit.entity.Provider;

/**
 *
 *@author 栗子
 *@description 
 */
public class ProviderParams {
	private Integer pageNo=1;
	private Integer pageSize=5;
	private Integer from;
	private Integer offset;
	private Integer count;
	private Integer countPage;
	private String proCode;
	private String proName;
	private List<Provider> li;
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
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		if(pageSize>0)
		this.pageSize = pageSize;
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
	public List<Provider> getLi() {
		return li;
	}
	public void setLi(List<Provider> li) {
		this.li = li;
	}
	public ProviderParams() {
		// TODO Auto-generated constructor stub
	}
	public ProviderParams(Integer pageNo, Integer pageSize, Integer from,
			Integer offset, Integer count, Integer countPage, String proCode,
			String proName, List<Provider> li) {
		super();
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.from = from;
		this.offset = offset;
		this.count = count;
		this.countPage = countPage;
		this.proCode = proCode;
		this.proName = proName;
		this.li = li;
	}
}
