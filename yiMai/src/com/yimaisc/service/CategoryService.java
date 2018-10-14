package com.yimaisc.service;

import java.util.List;

import com.yimaisc.comment.PageBean;
import com.yimaisc.entity.Category;
import com.yimaisc.entity.CategoryDTO;

public interface CategoryService {	
	
	/**
	 * 查询所有分类
	 */
	List<Category> getAllCategory();
	
	
	void findParentByPage(PageBean<CategoryDTO> pb);
	/**
	 * 添加分类
	 */
	int addCategory(Category c);
	/**
	 * 根据id查询信息
	 */
	Category findById(int id);
	/**
	 * 删除分类
	 */
	int deleteById(int id);
	/**
	 * 根据ID修改分类名称
	 */
	int updateById(Category c);
	/**
	 * 根据父分类ID查询对应的子分类
	 * @param parentId
	 * @return
	 */
	List<Category> findByParentId(int parentId);
}
