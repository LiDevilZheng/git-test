package com.yimaisc.dao;

import java.util.List;

import com.yimaisc.entity.User;

public interface UserDao {
	int getCount();
	
	List<User> getAllUser(int pageNo, int pageSize);
	
	int updateUser(User u);
	
	int delUser(String id);
	
	User findById(String id);
	/**
	 * 登录验证
	 * @param id
	 * @param passwrod
	 * @return
	 */
	User login(String id,String password);
	/**
	 * 用户注册
	 */
	int addUser(User u);
	/**
	 * 添加新地址
	 */
	int addUserAddress(String id,String address);
}
