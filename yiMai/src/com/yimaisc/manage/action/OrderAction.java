package com.yimaisc.manage.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yimaisc.comment.PageBean;
import com.yimaisc.entity.OrderDTO;
import com.yimaisc.entity.OrderParams;

import com.yimaisc.service.OrderService;
import com.yimaisc.service.impl.OrderServiceImpl;

public class OrderAction extends HttpServlet {

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
		PrintWriter out=response.getWriter();
		String sta=request.getParameter("status");
		String orderId=request.getParameter("orderId");
		int status=1;
		if(sta!=null){
			status=Integer.parseInt(sta);
		}
		String id=request.getParameter("entityId");
		String userName=request.getParameter("userName");
		OrderService os=new OrderServiceImpl();
		//修改订单状态
		int result=0;
		if(orderId!=null){
			result=os.updateOrder(orderId, status);
		}
		System.out.println(result);
		if(result>0){
			out.print("true");
		}else{
			out.print("false");
		}
		OrderParams op=new OrderParams();
		op.setId(id);
		op.setUserId(userName);
		int pageNo=1;
		int pageSize=2;
		String str1=request.getParameter("pageNo");
    	String str2=request.getParameter("pageSize");
    	if(str1!=null){
    		pageNo=Integer.parseInt(str1);
    	}
    	if(str2!=null){
    		pageSize=Integer.parseInt(str2);
    	}
		PageBean<OrderDTO> pb=new PageBean<OrderDTO>(pageNo, pageSize);
		os.findByPage(pb, op);
		request.setAttribute("pb", pb);
		//获取管理员信息
		request.getRequestDispatcher("order.jsp").forward(request, response);
		out.flush();
		out.close();
	}
}
