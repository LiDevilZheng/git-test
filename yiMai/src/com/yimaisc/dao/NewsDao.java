package com.yimaisc.dao;

import java.util.List;

import com.yimaisc.entity.News;

/**
*
*@author 栗子
*@description 
*/
public interface NewsDao {
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
	 * 查询新闻总条数
	 */
	int getNewsCount();
	/**
	 * 根据页码和每页显示的数量返回当前页的内容
	 */
	List<News> getNews(int pageNo,int pageSize);
}