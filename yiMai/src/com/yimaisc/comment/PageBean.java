package com.yimaisc.comment;

import java.util.List;

public class PageBean<T> {
	private int pageNo=1;
	private int pageSize=4;
	private int countPage;
	private int count;
	private List<T> list;
	public int getPageNo() {
		if(pageNo>countPage){
			pageNo=countPage;
		}
		if(pageNo<1){
			pageNo=1;
		}
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		if(pageNo>0)
			this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		if(pageSize>0)
			this.pageSize = pageSize;
	}
	public int getCountPage() {
		return countPage;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		if(count>0){
			this.count = count;
			countPage=this.count%pageSize==0?(this.count/pageSize):(this.count/pageSize+1);
		}
		
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public PageBean() {
		
	}
	public PageBean(int pageNo, int pageSize, int countPage, int count,
			List<T> list) {
		super();
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.countPage = countPage;
		this.count = count;
		this.list = list;
	}
	public PageBean(int pageNo, int pageSize) {
		super();
		this.pageNo = pageNo;
		this.pageSize = pageSize;
	}
}
