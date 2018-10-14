package com.jbit.dao;

import java.util.List;

import com.jbit.dto.BillParams;
import com.jbit.entity.Bill;

/**
 *
 *@author 栗子
 *@description 
 */
public interface BillDao {
	public int getCount(BillParams params);
	public List<Bill> findBills(BillParams params);
}
