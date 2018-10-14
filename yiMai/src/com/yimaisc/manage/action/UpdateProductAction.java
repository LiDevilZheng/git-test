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

public class UpdateProductAction extends HttpServlet {

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
		String name=request.getParameter("className");
		CategoryService cs=new CategoryServiceImpl();
		Category c=new Category();
		c.setId(id);
		c.setName(name);
		int result=cs.updateById(c);
		if(result>0){
			request.getRequestDispatcher("manage-result.jsp").forward(request, response);
		}else{
			request.setAttribute("meg", "修改失败！");
			request.getRequestDispatcher("productClass-modify.jsp").forward(request, response);
		}
	}

}
