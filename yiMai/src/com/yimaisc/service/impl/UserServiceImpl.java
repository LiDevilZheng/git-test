package com.yimaisc.service.impl;

import java.util.List;

import com.yimaisc.comment.PageBean;
import com.yimaisc.dao.UserDao;
import com.yimaisc.dao.impl.UserDaoImpl;
import com.yimaisc.entity.User;
import com.yimaisc.service.UserService;

public class UserServiceImpl implements UserService{
	private UserDao ud=new UserDaoImpl();
	@Override
	public int updateUser(User u) {
		// TODO Auto-generated method stub
		return ud.updateUser(u);
	}

	@Override
	public int delUser(String id) {
		// TODO Auto-generated method stub
		return ud.delUser(id);
	}

	@Override
	public void findByPage(PageBean<User> pb) {
		// TODO Auto-generated method stub
		int count=ud.getCount();
		pb.setCount(count);
		List<User> list=ud.getAllUser(pb.getPageNo(), pb.getPageSize());
		pb.setList(list);
	}

	@Override
	public User findById(String id) {
		// TODO Auto-generated method stub
		return ud.findById(id);
	}

	@Override
	public User login(String id, String password) {
		// TODO Auto-generated method stub
		return ud.login(id, password);
	}

	@Override
	public int addUser(User u) {
		// TODO Auto-generated method stub
		return ud.addUser(u);
	}

	@Override
	public int addUserAddress(String id, String address) {
		// TODO Auto-generated method stub
		return ud.addUserAddress(id, address);
	}

}
