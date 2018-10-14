package com.yimaisc.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yimaisc.entity.User;
import com.yimaisc.service.UserService;
import com.yimaisc.service.impl.UserServiceImpl;

public class LoginAction extends HttpServlet {

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
		String id= request.getParameter("userId");
		String pwd= request.getParameter("password");
		String code= request.getParameter("code");
		String auth=(String) request.getSession().getAttribute("auth");
		if(code.equals(auth)){
			UserService us=new UserServiceImpl();
			User u=us.login(id, pwd);
			if(u==null){
				request.setAttribute("meg", "用户名或密码不正确！");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}else{
				request.getSession().setAttribute("user", u);
				if(u.getStatus()==1){
					request.getRequestDispatcher("index.action").forward(request, response);
				}else if(u.getStatus()==2){
					request.getRequestDispatcher("index.action").forward(request, response);
				}
			}
		}else{
			request.setAttribute("meg", "验证码不正确！");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}
