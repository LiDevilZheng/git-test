package com.yimaisc.dao;

import java.util.List;

import com.yimaisc.entity.Category;

public interface CategoryDao {
	/**
	 * 查询所有一级分类
	 */
	List<Category> getAllCategory();
	/**
	 * 获得父分类总条数
	 * @return
	 */
	int getCategoryCount();
	/**
	 * 查询每页显示的父分类
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<Category> findByPage(int pageNo,int pageSize);
	/**
	 * 根据父分类ID查询对应的子分类
	 * @param parentId
	 * @return
	 */
	List<Category> findByParentId(int parentId);
	/**
	 * 添加分类
	 */
	int addCategory(Category c);
	/**
	 * 根据id查询信息
	 */
	Category findById(int id);
	/**
	 * 按父类别编号删除类别
	 */
	int deleteByParentId(int parentId);
	/**
	 * 按照编号删除类别
	 */
	int delete(int id);
	/**
	 * 根据ID修改分类名称
	 */
	int updateById(Category c);
}
