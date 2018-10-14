package com.jbit.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbit.dao.SmbmsUserDao;
import com.jbit.dto.SmbmsUserParams;
import com.jbit.entity.SmbmsUser;
import com.jbit.service.SmbmsUserService;

/**
 *
 *@author 栗子
 *@description 
 */
@Service
public class SmbmsUserServiceImpl implements SmbmsUserService{
@Autowired
	private SmbmsUserDao sud;
	public SmbmsUserDao getSud() {
		return sud;
	}
	public void setSud(SmbmsUserDao sud) {
		this.sud = sud;
	}
	@Override
	public SmbmsUser login(String userCode, String userPassword) {
		// TODO Auto-generated method stub
		return sud.login(userCode, userPassword);
	}
	@Override
	public void findUsers(SmbmsUserParams params) {
		// TODO Auto-generated method stub
		int count=sud.getCount(params);
		params.setCount(count);
		params.setCountPage(count%params.getPageSize()==0?(count/params.getPageSize()):(count/params.getPageSize()+1));
		params.setLi(sud.findUsers(params));
	}
	@Override
	public SmbmsUser findById(int id) {
		// TODO Auto-generated method stub
		return sud.findById(id);
	}
	@Override
	public int updateUser(SmbmsUser user) {
		// TODO Auto-generated method stub
		return sud.updateUser(user);
	}
	@Override
	public int addUser(SmbmsUser user) {
		// TODO Auto-generated method stub
		//应该先判断有没有，再添加
		SmbmsUser temp=sud.findByUserCode(user.getUserCode());
		if(temp!=null){
			return -1;
		}else{
			return sud.addUser(user);
		}
	}
	@Override
	public SmbmsUser findByUserCode(String userCode) {
		// TODO Auto-generated method stub
		return sud.findByUserCode(userCode);
	}
	@Override
	public int updateUserPassword(int id, String userPassword) {
		// TODO Auto-generated method stub
		return sud.updateUserPassword(id, userPassword);
	}
}
