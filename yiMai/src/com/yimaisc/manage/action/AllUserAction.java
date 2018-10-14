package com.yimaisc.manage.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yimaisc.comment.PageBean;
import com.yimaisc.entity.User;
import com.yimaisc.service.UserService;
import com.yimaisc.service.impl.UserServiceImpl;

public class AllUserAction extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AllUserAction() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

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
		UserService us=new UserServiceImpl();
		int pageNo=1;
		int pageSize=3;
		String str1=request.getParameter("pageNo");
    	String str2=request.getParameter("pageSize");
    	if(str1!=null){
    		pageNo=Integer.parseInt(str1);
    	}
    	if(str2!=null){
    		pageSize=Integer.parseInt(str2);
    	}
		PageBean<User> pb=new PageBean<User>(pageNo, pageSize);
		us.findByPage(pb);
		request.setAttribute("pb", pb);
		request.getRequestDispatcher("user.jsp").forward(request, response);

	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
