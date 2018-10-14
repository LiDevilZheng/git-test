package com.yimaisc.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yimaisc.comment.PageBean;
import com.yimaisc.entity.CategoryDTO;
import com.yimaisc.entity.User;
import com.yimaisc.service.CategoryService;
import com.yimaisc.service.UserService;
import com.yimaisc.service.impl.CategoryServiceImpl;
import com.yimaisc.service.impl.UserServiceImpl;

/**
 *
 *@author 栗子
 *@description 
 */
public class AddressAction extends HttpServlet {

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
		HttpSession session=request.getSession();
		User u=(User)session.getAttribute("user");
		UserService us=new UserServiceImpl();
		User user=us.findById(u.getId());
		String []arr=user.getAddress().split(",");
		request.setAttribute("arr", arr);
		//查询商品分类
		CategoryService cs=new CategoryServiceImpl();
		PageBean<CategoryDTO> pb=new PageBean<CategoryDTO>(1, 6);
		cs.findParentByPage(pb);
		request.setAttribute("pb", pb);
		
		//直接购买，传商品id
		String str=request.getParameter("id");
		if(str!=null){
			int id=Integer.parseInt(str);
			request.setAttribute("id", id);
		}		
		request.getRequestDispatcher("address.jsp").forward(request, response);	
	}

}
