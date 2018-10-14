package com.yimaisc.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yimaisc.comment.PageBean;
import com.yimaisc.entity.CategoryDTO;
import com.yimaisc.entity.Comment;
import com.yimaisc.service.CategoryService;
import com.yimaisc.service.CommentService;
import com.yimaisc.service.impl.CategoryServiceImpl;
import com.yimaisc.service.impl.CommentServiceImpl;

public class GuestAction extends HttpServlet {

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
		//商品分类列表
		CategoryService cgs=new CategoryServiceImpl();
		PageBean<CategoryDTO> pbNews=new PageBean<CategoryDTO>(1, 6);
		cgs.findParentByPage(pbNews);
		request.setAttribute("pbNews", pbNews);
		//分页显示留言
		CommentService cs=new CommentServiceImpl();
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
		PageBean<Comment> pb=new PageBean<Comment>(pageNo, pageSize);
		cs.findByPage(pb);
		request.setAttribute("pb", pb);
		request.getRequestDispatcher("guestbook.jsp").forward(request, response);
	}

}
