package com.jbit.dto;

import java.util.List;

import com.jbit.entity.Bill;



/**
 *
 *@author 栗子
 *@description 
 */
public class BillParams {
	private Integer pageNo=1;
	private Integer pageSize=5;
	private String productName;
	private Integer providerId=0;
	private Integer isPayment=0;
	private Integer from;
	private Integer offset;
	private Integer count;
	private Integer countPage;
	private List<Bill> li;
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
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getProviderId() {
		return providerId;
	}
	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}
	public Integer getIsPayment() {
		return isPayment;
	}
	public void setIsPayment(Integer isPayment) {
		this.isPayment = isPayment;
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
	public List<Bill> getLi() {
		return li;
	}
	public void setLi(List<Bill> li) {
		this.li = li;
	}
	public BillParams() {
		// TODO Auto-generated constructor stub
	}
	public BillParams(Integer pageNo, Integer pageSize, String productName,
			Integer providerId, Integer isPayment, Integer from,
			Integer offset, Integer count, Integer countPage, List<Bill> li) {
		super();
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.productName = productName;
		this.providerId = providerId;
		this.isPayment = isPayment;
		this.from = from;
		this.offset = offset;
		this.count = count;
		this.countPage = countPage;
		this.li = li;
	}
}
