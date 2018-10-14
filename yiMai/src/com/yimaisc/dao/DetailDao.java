package com.yimaisc.dao;

import java.util.List;

import com.yimaisc.entity.Detail;

public interface DetailDao {
	List<Detail> findByOrderId(String oId);
	/**
	 * 添加订单详情
	 */
	int addDetail(Detail d);
}
