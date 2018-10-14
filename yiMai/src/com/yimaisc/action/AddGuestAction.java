package com.yimaisc.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yimaisc.entity.Comment;
import com.yimaisc.service.CommentService;
import com.yimaisc.service.impl.CommentServiceImpl;

public class AddGuestAction extends HttpServlet {

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
		response.setContentType("text/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		String guestName=request.getParameter("guestName");
		String guestContent=request.getParameter("guestContent");
		Timestamp t=new Timestamp(System.currentTimeMillis());
		Comment c=new Comment();
		c.setContent(guestContent);
		c.setNickName(guestName);
		c.setCreateTime(t);
		CommentService cs=new CommentServiceImpl();
		int result=cs.addComment(c);
		if(result>0){
			out.print(true);
		}else{
			out.print(false);
		}
		out.flush();
		out.close();
	}
}
