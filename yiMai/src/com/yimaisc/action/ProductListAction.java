package com.yimaisc.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yimaisc.comment.PageBean;
import com.yimaisc.entity.Category;
import com.yimaisc.entity.CategoryDTO;
import com.yimaisc.entity.Product;
import com.yimaisc.service.CategoryService;
import com.yimaisc.service.ProductService;
import com.yimaisc.service.impl.CategoryServiceImpl;
import com.yimaisc.service.impl.ProductServiceImpl;

public class ProductListAction extends HttpServlet {

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
		response.setCharacterEncoding("utf-8");
		String str=request.getParameter("id");
		//1.显示所有商品分类信息
		CategoryService cs=new CategoryServiceImpl();
		PageBean<CategoryDTO> pb=new PageBean<CategoryDTO>(1, 6);
		cs.findParentByPage(pb);
		request.setAttribute("pb", pb);
		//2.根据分类ID查询对应的商品信息并分页
		ProductService ps=new ProductServiceImpl();
		int pageNo=1;
		int pageSize=4;
		String str1=request.getParameter("pageNo");
    	String str2=request.getParameter("pageSize");
    	if(str1!=null){
    		pageNo=Integer.parseInt(str1);
    	}
    	if(str2!=null){
    		pageSize=Integer.parseInt(str2);
    	}
		if(str!=null&&!str.equals("")){
			Category c=cs.findById(Integer.parseInt(str));
			Category pc=cs.findById(c.getParentId());
			request.setAttribute("c", c);
			request.setAttribute("pc", pc);
			PageBean<Product> pbProduct=new PageBean<Product>(pageNo, pageSize);
			ps.findByPidPage(pbProduct, Integer.parseInt(str));
			request.setAttribute("id", Integer.parseInt(str));
			request.setAttribute("pbProduct", pbProduct);
		}
		String pcid=request.getParameter("pcid");
		if(pcid!=null&&!pcid.equals("")){
			PageBean<Product> pbProduct=new PageBean<Product>(pageNo, pageSize);
			ps.findByCidPage(pbProduct, Integer.parseInt(pcid));
			Category c=cs.findById(Integer.parseInt(pcid));
			request.setAttribute("cname", c.getName());
			request.setAttribute("pcid", Integer.parseInt(pcid));
			request.setAttribute("pbProduct", pbProduct);
		}
		request.getRequestDispatcher("product-list.jsp").forward(request, response);
	}
}
