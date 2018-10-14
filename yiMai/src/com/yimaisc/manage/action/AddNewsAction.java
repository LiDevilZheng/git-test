package com.yimaisc.manage.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yimaisc.entity.News;
import com.yimaisc.service.NewsService;
import com.yimaisc.service.impl.NewsServiceImpl;

/**
 *
 *@author 栗子
 *@description 
 */
public class AddNewsAction extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		request.setCharacterEncoding("utf-8");
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		NewsService ns=new NewsServiceImpl();
		News news=new News();
		news.setTitle(title);
		news.setContent(content);
		Timestamp t=new Timestamp(System.currentTimeMillis());
		news.setCreateTime(t);
		int result=ns.addNews(news);
		if(result>0){
			request.getRequestDispatcher("manage-result.jsp").forward(request, response);
		}
	}
}
