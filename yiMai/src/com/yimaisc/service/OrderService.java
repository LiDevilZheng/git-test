package com.yimaisc.service;

import com.yimaisc.comment.PageBean;
import com.yimaisc.entity.Order;
import com.yimaisc.entity.OrderDTO;
import com.yimaisc.entity.OrderParams;


public interface OrderService {
	void findByPage(PageBean<OrderDTO> pb,OrderParams op);
	
	/**
	 * 根据订单号修改订单状态
	 */
	int updateOrder(String id,int status);
	/**
	 * 添加订单
	 */
	int addOrder(Order o);
}
