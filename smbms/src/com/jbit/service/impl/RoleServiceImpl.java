package com.jbit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbit.dao.RoleDao;
import com.jbit.entity.Role;
import com.jbit.service.RoleService;

/**
 *
 *@author 栗子
 *@description 
 */
@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	private RoleDao rd;
	public RoleDao getRd() {
		return rd;
	}
	public void setRd(RoleDao rd) {
		this.rd = rd;
	}
	@Override
	public List<Role> getAll() {
		// TODO Auto-generated method stub
		return rd.getAll();
	}
	@Override
	public Role findById(int id) {
		// TODO Auto-generated method stub
		return rd.findById(id);
	}

}
