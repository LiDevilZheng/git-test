package com.yimaisc.dao;

import java.util.List;

import com.yimaisc.entity.Order;
import com.yimaisc.entity.OrderParams;

public interface OrderDao {
	int getOrderCount(OrderParams op);
	
	
	List<Order> findByParams(int pageNo,int pageSize,OrderParams op);

	/**
	 * 根据订单号修改订单状态
	 */
	int updateOrder(String id,int status);
	/**
	 * 添加订单
	 */
	int addOrder(Order o);
}
