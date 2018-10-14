package com.yimaisc.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yimaisc.entity.Product;
import com.yimaisc.entity.SaleLine;
import com.yimaisc.entity.ShopCart;
import com.yimaisc.entity.User;
import com.yimaisc.service.ProductService;
import com.yimaisc.service.impl.ProductServiceImpl;

/**
 *
 *@author 栗子
 *@description 
 */
public class AddCartAction extends HttpServlet {

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
		
		int id=Integer.parseInt(request.getParameter("id"));
		ProductService ps=new ProductServiceImpl();
		Product product=ps.findById(id);
		SaleLine sl=new SaleLine();
		sl.setProduct(product);
		HttpSession session=request.getSession();
		ShopCart sc=(ShopCart) session.getAttribute("cart");
		if(sc==null){
			sc=new ShopCart();
		}
		sc.add(sl);
		List<SaleLine> li=sc.getLines();
		int temp=0;
		for(SaleLine s:li){
			temp+=s.getNum();
		}	
		User u=(User) session.getAttribute("user");
		if(u!=null){
			session.setAttribute("sum", temp);
			session.setAttribute("cart", sc);	
		}	
		response.sendRedirect("shopping.jsp");
	}
}
