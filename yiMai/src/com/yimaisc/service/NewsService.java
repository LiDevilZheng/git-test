package com.yimaisc.service;

import java.util.List;

import com.yimaisc.comment.PageBean;
import com.yimaisc.entity.News;

/**
 *
 *@author 栗子
 *@description 
 */
public interface NewsService {
	/**
	 * 查看所有新闻
	 */
	List<News> getAllNews();
	/**
	 * 添加新闻
	 */
	int addNews(News news);
	/**
	 * 修改新闻
	 */
	int updateNews(News news);
	/**
	 * 删除新闻
	 */
	int deleteNews(int id);
	/**
	 * 根据id查询新闻
	 */
	News findById(int id);
	/**
	 * 新闻分页查询
	 */
	public abstract void findByPage(PageBean<News> pb);
}
