package com.yimaisc.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class SaleLine implements Serializable{
	private Product product;
	private Integer num=1;
	private Double sum;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Double getSum() {
		sum=product.getPrice()*num;
		BigDecimal b=new BigDecimal(sum);
		sum=b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		return sum;
	}
	public void setSum(Double sum) {
		this.sum = sum;
	}
	public SaleLine() {
		// TODO Auto-generated constructor stub
	}
	public SaleLine(Product product, Integer num, Double sum) {
		super();
		this.product = product;
		this.num = num;
		this.sum = sum;
	}
}
