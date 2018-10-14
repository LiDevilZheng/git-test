package com.yimaisc.entity;

import java.io.Serializable;
import java.util.List;

public class CategoryDTO implements Serializable{
	private Category parent;
	private List<Category> childs;
	public Category getParent() {
		return parent;
	}
	public void setParent(Category parent) {
		this.parent = parent;
	}
	public List<Category> getChilds() {
		return childs;
	}
	public void setChilds(List<Category> childs) {
		this.childs = childs;
	}
	public CategoryDTO() {
		// TODO Auto-generated constructor stub
	}
	public CategoryDTO(Category parent, List<Category> childs) {
		super();
		this.parent = parent;
		this.childs = childs;
	}
}
