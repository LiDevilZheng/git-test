package com.yimaisc.manage.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yimaisc.comment.PageBean;
import com.yimaisc.entity.News;
import com.yimaisc.entity.Product;
import com.yimaisc.service.NewsService;
import com.yimaisc.service.ProductService;
import com.yimaisc.service.impl.NewsServiceImpl;
import com.yimaisc.service.impl.ProductServiceImpl;

public class AllProductAction extends HttpServlet {

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
		response.setContentType("text/html;charset=utf-8");
		//PrintWriter out = response.getWriter();
		ProductService ps=new ProductServiceImpl();
		int pageSize=4;
    	int pageNo=1;
    	String str1=request.getParameter("pageNo");
    	String str2=request.getParameter("pageSize");
    	if(str1!=null){
    		pageNo=Integer.parseInt(str1);
    	}
    	if(str2!=null){
    		pageSize=Integer.parseInt(str2);
    	}
    	PageBean<Product> pb=new PageBean<Product>(pageNo,pageSize);
    	ps.findByPage(pb);
		request.setAttribute("pb",pb);
		request.getRequestDispatcher("product.jsp").forward(request, response);
	}

}
