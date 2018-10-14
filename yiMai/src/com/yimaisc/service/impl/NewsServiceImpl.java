package com.yimaisc.service.impl;

import java.util.List;

import com.yimaisc.comment.PageBean;
import com.yimaisc.dao.NewsDao;
import com.yimaisc.dao.impl.NewsDaoImpl;
import com.yimaisc.entity.News;
import com.yimaisc.service.NewsService;

/**
 *
 *@author ����
 *@description 
 */
public class NewsServiceImpl implements NewsService{
	private NewsDao nd=new NewsDaoImpl();
	@Override
	public List<News> getAllNews() {
		// TODO Auto-generated method stub
		return nd.getAllNews();
	}

	@Override
	public int addNews(News news) {
		// TODO Auto-generated method stub
		return nd.addNews(news);
	}

	@Override
	public int updateNews(News news) {
		// TODO Auto-generated method stub
		return nd.updateNews(news);
	}

	@Override
	public int deleteNews(int id) {
		// TODO Auto-generated method stub
		return nd.deleteNews(id);
	}

	@Override
	public News findById(int id) {
		// TODO Auto-generated method stub
		return nd.findById(id);
	}

	@Override
	public void findByPage(PageBean<News> pb) {
		// TODO Auto-generated method stub
		int count=nd.getNewsCount();
		pb.setCount(count);
		List<News> list=nd.getNews(pb.getPageNo(), pb.getPageSize());
		pb.setList(list);
	}

}
