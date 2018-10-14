package com.yimaisc.service.impl;

import com.yimaisc.dao.DetailDao;
import com.yimaisc.dao.impl.DetailDaoImpl;
import com.yimaisc.entity.Detail;
import com.yimaisc.service.DetailService;

/**
 *
 *@author 栗子
 *@description 
 */
public class DetailServiceImpl implements DetailService{
	private DetailDao dd=new DetailDaoImpl();
	@Override
	public int addDetail(Detail d) {
		// TODO Auto-generated method stub
		return dd.addDetail(d);
	}

}
