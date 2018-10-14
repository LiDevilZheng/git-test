package com.jbit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbit.dao.ProviderDao;
import com.jbit.dto.ProviderParams;
import com.jbit.entity.Provider;
import com.jbit.service.ProviderService;

/**
 *
 *@author 栗子
 *@description 
 */
@Service
public class ProviderServiceImpl implements ProviderService{
@Autowired
	private ProviderDao pd;
	public ProviderDao getPd() {
		return pd;
	}
	public void setPd(ProviderDao pd) {
		this.pd = pd;
	}
	@Override
	public void findProvider(ProviderParams params) {
		// TODO Auto-generated method stub
		int count=pd.getCount(params);
		params.setCount(count);
		params.setCountPage(count%params.getPageSize()==0?(count/params.getPageSize()):(count/params.getPageSize()+1));
		params.setLi(pd.findProvider(params));
	}
	@Override
	public Provider findById(int id) {
		// TODO Auto-generated method stub
		return pd.findById(id);
	}
	@Override
	public int addProvider(Provider provider) {
		// TODO Auto-generated method stub
		//先判断有没有，再添加
		Provider temp=pd.findByProCode(provider.getProCode());
		if(temp!=null){
			return -1;
		}else{
			return pd.addProvider(provider);
		}	
	}
	@Override
	public Provider findByProCode(String proCode) {
		// TODO Auto-generated method stub
		return pd.findByProCode(proCode);
	}
	@Override
	public List<Provider> getAllproName() {
		// TODO Auto-generated method stub
		return pd.getAllproName();
	}

}
