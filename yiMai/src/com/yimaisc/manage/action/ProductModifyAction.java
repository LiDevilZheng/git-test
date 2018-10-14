package com.yimaisc.manage.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yimaisc.comment.PageBean;
import com.yimaisc.entity.CategoryDTO;
import com.yimaisc.entity.Product;
import com.yimaisc.service.CategoryService;
import com.yimaisc.service.ProductService;
import com.yimaisc.service.impl.CategoryServiceImpl;
import com.yimaisc.service.impl.ProductServiceImpl;

public class ProductModifyAction extends HttpServlet {

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
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String str=request.getParameter("id");
		int id=0;
		if(str!=null){
			id=Integer.parseInt(str);
		}
		ProductService ps=new ProductServiceImpl();
		Product p=ps.findById(id);
		CategoryService cs=new CategoryServiceImpl();
		PageBean<CategoryDTO> pb=new PageBean<CategoryDTO>(1, 10);
		cs.findParentByPage(pb);
		request.setAttribute("p", p);
		request.setAttribute("pb", pb);
		request.getRequestDispatcher("product-modify.jsp").forward(request, response);
	}

}
