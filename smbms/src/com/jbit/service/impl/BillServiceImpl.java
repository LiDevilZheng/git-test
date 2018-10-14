package com.jbit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbit.dao.BillDao;
import com.jbit.dto.BillParams;
import com.jbit.entity.Bill;
import com.jbit.service.BillService;

/**
 *
 *@author 栗子
 *@description 
 */
@Service
public class BillServiceImpl implements BillService{
	@Autowired
	private BillDao bd;
	public BillDao getBd() {
		return bd;
	}
	public void setBd(BillDao bd) {
		this.bd = bd;
	}
	@Override
	public void findBills(BillParams params) {
		// TODO Auto-generated method stub
		int count=bd.getCount(params);
		params.setCount(count);
		params.setCountPage(count%params.getPageSize()==0?(count/params.getPageSize()):(count/params.getPageSize()+1));
		params.setLi(bd.findBills(params));
	}

}
