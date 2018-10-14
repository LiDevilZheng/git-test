package com.yimaisc.manage.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yimaisc.entity.Category;
import com.yimaisc.service.CategoryService;
import com.yimaisc.service.impl.CategoryServiceImpl;

/**
 *
 *@author 栗子
 *@description 
 */
public class FindProductClassAction extends HttpServlet {

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
		CategoryService cs=new CategoryServiceImpl();
		Category c=cs.findById(id);
		int parentId=c.getParentId();
		if(parentId!=0){
			//根据父分类id查询所属的分类信息
			Category pc=cs.findById(parentId);
			request.setAttribute("pc", pc);
		}
		request.setAttribute("c", c);
		request.getRequestDispatcher("productClass-modify.jsp").forward(request, response);
	}

}
