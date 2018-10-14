package com.yimaisc.service;

import java.util.List;

import com.yimaisc.comment.PageBean;

import com.yimaisc.entity.Product;

public interface ProductService {
	public abstract void findByPage(PageBean<Product> pb);
	
	public abstract void findByPidPage(PageBean<Product> pb,int pid);
	
	public abstract void findByCidPage(PageBean<Product> pb,int cid);
	int addProduct(Product p);
	/**
	 * 删除商品
	 * @param id
	 * @return
	 */
	int delById(int id);
	/**
	 * 根据ID查询商品信息
	 */
	Product findById(int id);
	/**
	 * 根据ID修改商品信息
	 * @return 
	 */
	int updateById(Product p);
	/**
	 *修改商品库存
	 */
	int updateStock(int id,int stock);
	/**
	 * 查询浏览过的商品
	 */
	List<Product> findByStr(String str);
}
