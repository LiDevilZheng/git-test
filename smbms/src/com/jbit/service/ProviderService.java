package com.jbit.service;

import java.util.List;

import com.jbit.dto.ProviderParams;
import com.jbit.entity.Provider;

/**
 *
 *@author 栗子
 *@description 
 */
public interface ProviderService {
	/**
	 * 供应商查询
	 */
	public abstract void findProvider(ProviderParams params);
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
