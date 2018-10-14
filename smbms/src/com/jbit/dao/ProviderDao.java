package com.jbit.dao;

import java.util.List;

import com.jbit.dto.ProviderParams;
import com.jbit.entity.Provider;
import com.jbit.entity.SmbmsUser;

/**
 *
 *@author 栗子
 *@description 
 */
public interface ProviderDao {
	/**
	 * 根据条件查询总记录数
	 */
	public abstract int getCount(ProviderParams params);
	/**
	 * 根据条件查询供应商列表
	 */
	public abstract List<Provider> findProvider(ProviderParams params);
	/**
	 * 根据id查询详细
	 */
	public abstract Provider findById(int id);
	/**
	 * 根据编码查询供应商
	 */
	public Provider findByProCode(String proCode);
	/**
	 * 添加供应商
	 */
	public int addProvider(Provider provider);
	/**
	 * 查找所有的供应商名称
	 */
	public List<Provider> getAllproName();
}
