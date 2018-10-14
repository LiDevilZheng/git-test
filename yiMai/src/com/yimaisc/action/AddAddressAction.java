package com.yimaisc.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yimaisc.entity.User;
import com.yimaisc.service.UserService;
import com.yimaisc.service.impl.UserServiceImpl;

/**
 *
 *@author 栗子
 *@description 
 */
public class AddAddressAction extends HttpServlet {

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
		response.setContentType("text/html;charset=utf-8");
		String address=request.getParameter("address");
		//address=new String(address.getBytes("ISO-8859-1"),"UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession();
		User u=(User)session.getAttribute("user");
		UserService us=new UserServiceImpl();
		User user=us.findById(u.getId());
		address=user.getAddress()+","+address;
		int result=us.addUserAddress(u.getId(), address);
		if(result>0){
			out.print(true);
		}else{
			out.print(false);
		}
		out.flush();
		out.close();
	}
}
