package com.yimaisc.service;

import com.yimaisc.comment.PageBean;
import com.yimaisc.entity.User;

public interface UserService {
	int updateUser(User u);
	
	int delUser(String id);
	
	void findByPage(PageBean<User> pb);
	
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
