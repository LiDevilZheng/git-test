package com.yimaisc.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.yimaisc.comment.PageBean;
import com.yimaisc.dao.DetailDao;
import com.yimaisc.dao.OrderDao;
import com.yimaisc.dao.impl.DetailDaoImpl;
import com.yimaisc.dao.impl.OrderDaoImpl;
import com.yimaisc.entity.Detail;
import com.yimaisc.entity.Order;
import com.yimaisc.entity.OrderDTO;
import com.yimaisc.entity.OrderParams;
import com.yimaisc.service.OrderService;

public class OrderServiceImpl implements OrderService{
	private OrderDao os=new OrderDaoImpl();
	private DetailDao dd=new DetailDaoImpl();
	@Override
	public void findByPage(PageBean<OrderDTO> pb, OrderParams op) {
		// TODO Auto-generated method stub	
		int count=os.getOrderCount(op);
		pb.setCount(count);
		List<Order> li=os.findByParams(pb.getPageNo(), pb.getPageSize(), op);
		List<OrderDTO> dtoLi=new ArrayList<OrderDTO>();
		for(Order o:li){
			OrderDTO od=new OrderDTO();
			String oId=o.getId();
			List<Detail> details=dd.findByOrderId(oId);//查询该订单下的订单详情
			double cost=0;
			for(Detail d:details){
				cost+=d.getPrice()*d.getQuantity();
			}
			o.setCost(cost);
			od.setOrder(o);
			od.setDetails(details);
			dtoLi.add(od);
		}	
		pb.setList(dtoLi);
	}	
	//测试数据
	public static void main(String[] args){
		OrderService os=new OrderServiceImpl();
		PageBean<OrderDTO> pb=new PageBean<OrderDTO>(1,3);
		OrderParams op=new OrderParams();
		//op.setId("w");
		os.findByPage(pb, op);
		System.out.println("共"+pb.getCount()+"条数据");
		List<OrderDTO> li=pb.getList();
		for(OrderDTO ooo:li){
			Order order=ooo.getOrder();
			List<Detail> dli=ooo.getDetails();
			System.out.println(order.getId()+","+order.getName());
			for(Detail d:dli){
				System.out.println("---->"+d.getId()+","+d.getName()+","+d.getPic());
			}
		}
	}
	@Override
	public int updateOrder(String id, int status) {
		// TODO Auto-generated method stub
		return os.updateOrder(id, status);
	}
	@Override
	public int addOrder(Order o) {
		// TODO Auto-generated method stub
		return os.addOrder(o);
	}
}
