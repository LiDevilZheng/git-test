package com.yimaisc.dao;

import java.util.List;

import com.yimaisc.entity.Product;


/**
 *
 *@author 栗子
 *@description 
 */
public interface ProductDao {
	
	int updatePid(int id);
	
	int getCount();
	
	List<Product> getAllProduct(int pageNo, int pageSize);
	
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
	 * 根据分类ID查询对应的商品信息并分页
	 */
	List<Product> getProductByPid(int pageNo, int pageSize,int pid);

	int getCountByPid(int pid);
	
	/**
	 * 根据二级分类ID查询对应的商品信息并分页
	 */
	List<Product> getProductByCid(int pageNo, int pageSize,int cid);

	int getCountByCid(int cid);
	/**
	 *修改商品库存
	 */
	int updateStock(int id,int stock);
}
