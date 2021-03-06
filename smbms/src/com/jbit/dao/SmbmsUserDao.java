package com.jbit.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jbit.dto.SmbmsUserParams;
import com.jbit.entity.SmbmsUser;

/**
 *
 *@author 栗子
 *@description 
 */
public interface SmbmsUserDao {
	/**
	 * 查询用户表记录数
	 */
	public Integer getCount(SmbmsUserParams params);
	/**
	 * 登录验证
	 */
	public SmbmsUser login(@Param("userCode")String userCode,@Param("userPassword")String userPassword);
	/**
	 * 用户查询
	 */
	public List<SmbmsUser> findUsers(SmbmsUserParams param);
	/**
	 * 根据id查询
	 */
	public SmbmsUser findById(int id);
	/**
	 * 修改用户信息
	 */
	public abstract int updateUser(SmbmsUser user);
	/**
	 * 添加用户
	 */
	public abstract int addUser(SmbmsUser user);
	/**
	 * 根据编码查询用户
	 */
	public SmbmsUser findByUserCode(String userCode);
	/**
	 * 更改密码
	 */
	public int updateUserPassword(@Param("id")int id,@Param("userPassword")String userPassword);
}

