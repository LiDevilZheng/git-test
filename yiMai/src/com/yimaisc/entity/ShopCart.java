package com.yimaisc.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class ShopCart implements Serializable{
	private List<SaleLine> lines=new LinkedList<SaleLine>();
	private Double total=0.0;
	public List<SaleLine> getLines() {
		return lines;
	}
	public void setLines(List<SaleLine> lines) {
		this.lines = lines;
	}
	public Double getTotal() {
		double temp=0.0;
		for(SaleLine sl:lines){
			temp+=sl.getSum();
		}
		BigDecimal b=new BigDecimal(temp);
		total=b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public ShopCart() {
		// TODO Auto-generated constructor stub
	}
	public ShopCart(List<SaleLine> lines, Double total) {
		super();
		this.lines = lines;
		this.total = total;
	}
	public void add(SaleLine sl){
		for(SaleLine line:lines){
			if(line.getProduct().getId()==sl.getProduct().getId()){
				line.setNum(line.getNum()+1);
				return ;
			}
		}
		lines.add(sl);
	}
	public void update(int id, int num){
		for(SaleLine line:lines){
			if(line.getProduct().getId()==id){
				line.setNum(num);
				return ;
			}
		}
	}
	public void del(int id){
		for(SaleLine line:lines){
			if(line.getProduct().getId()==id){
				lines.remove(line);
				return;
			}
		}
	}
	public void clear(){
		lines.clear();
	}
}
