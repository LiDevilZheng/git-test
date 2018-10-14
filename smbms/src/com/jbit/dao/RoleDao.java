package com.jbit.dao;

import java.util.List;

import com.jbit.entity.Role;

/**
 *
 *@author 栗子
 *@description 
 */
public interface RoleDao {
	public abstract List<Role> getAll();
	public Role findById(int id);
}
