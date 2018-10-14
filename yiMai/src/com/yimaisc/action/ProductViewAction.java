package com.yimaisc.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yimaisc.comment.CookieStrUtil;
import com.yimaisc.comment.PageBean;
import com.yimaisc.entity.Category;
import com.yimaisc.entity.CategoryDTO;
import com.yimaisc.entity.Product;
import com.yimaisc.service.CategoryService;
import com.yimaisc.service.ProductService;
import com.yimaisc.service.impl.CategoryServiceImpl;
import com.yimaisc.service.impl.ProductServiceImpl;

/**
 *
 *@author 栗子
 *@description 
 */
public class ProductViewAction extends HttpServlet {

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
		//1.显示商品详细信息
		int id=Integer.parseInt(request.getParameter("id"));
		ProductService ps=new ProductServiceImpl();
		Product p=ps.findById(id);
		CategoryService cs=new CategoryServiceImpl();
		//查询对应的分类名称
		int pid=p.getPid();
		Category c1=cs.findById(pid);
		request.setAttribute("c1", c1);
		//查询对应的二级分类名称
		int cid=p.getCid();
		Category c2=cs.findById(cid);
		request.setAttribute("c2", c2);
		request.setAttribute("p", p);
		//2.显示商品分类信息
		PageBean<CategoryDTO> pb=new PageBean<CategoryDTO>(1, 6);
		cs.findParentByPage(pb);
		request.setAttribute("pb", pb);
		
		//显示最近浏览商品信息
		String str="";
		Cookie[] cookies=request.getCookies();
		if(cookies!=null){
			for(Cookie c:cookies){
				if(c.getName().equals("productId")){
					str=c.getValue();
					break;
				}
			}
		}
		String newStr=CookieStrUtil.addValues(str, id+"");
		Cookie c=new Cookie("productId", newStr);
		c.setMaxAge(60*60*24*7);
		response.addCookie(c);
		request.getRequestDispatcher("product-view.jsp").forward(request, response);
	}

}
