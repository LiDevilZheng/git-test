package com.yimaisc.entity;

import java.io.Serializable;
import java.util.List;

public class OrderDTO implements Serializable{
	private Order order;
	private List<Detail> details;
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public List<Detail> getDetails() {
		return details;
	}
	public void setDetails(List<Detail> details) {
		this.details = details;
	}
	public OrderDTO() {
		// TODO Auto-generated constructor stub
	}
	public OrderDTO(Order order, List<Detail> details) {
		super();
		this.order = order;
		this.details = details;
	}
}
