package com.yimaisc.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yimaisc.comment.PageBean;
import com.yimaisc.entity.CategoryDTO;
import com.yimaisc.entity.News;
import com.yimaisc.service.CategoryService;
import com.yimaisc.service.NewsService;
import com.yimaisc.service.impl.CategoryServiceImpl;
import com.yimaisc.service.impl.NewsServiceImpl;

/**
 *
 *@author 栗子
 *@description 
 */
public class NewsViewAction extends HttpServlet {

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
		int id=Integer.parseInt(request.getParameter("id"));
		NewsService ns=new NewsServiceImpl();
		News news=ns.findById(id);
		//显示商品分类信息
		CategoryService cs=new CategoryServiceImpl();
		PageBean<CategoryDTO> pb=new PageBean<CategoryDTO>(1, 6);
		cs.findParentByPage(pb);
		request.setAttribute("pb", pb);
		request.setAttribute("news", news);
		request.getRequestDispatcher("news-view.jsp").forward(request, response);
	}

}
