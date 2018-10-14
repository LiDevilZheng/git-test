package com.yimaisc.manage.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yimaisc.entity.Comment;
import com.yimaisc.service.CommentService;
import com.yimaisc.service.impl.CommentServiceImpl;

public class GuestSelectAction extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public GuestSelectAction() {
		super();
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
		request.setCharacterEncoding("utf-8");		
		int id=Integer.parseInt(request.getParameter("id"));
		CommentService cs=new CommentServiceImpl();
		Comment c=cs.findById(id);
		if(c.getReply()!=null){
			request.setAttribute("meg", "修改留言");
		}else{
			request.setAttribute("meg", "回复留言");
		}
		request.setAttribute("c", c);
		request.getRequestDispatcher("guestbook-modify.jsp").forward(request, response);
	}

}
