package com.yimaisc.manage.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yimaisc.entity.User;
import com.yimaisc.service.UserService;
import com.yimaisc.service.impl.UserServiceImpl;

public class UpdateUserAction extends HttpServlet {

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
		String id=request.getParameter("userName");
		String name=request.getParameter("name");
		String password1=request.getParameter("passWord1");
		String password2=request.getParameter("passWord2");
		String sex=request.getParameter("sex");
		String birthday=request.getParameter("birthday");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date d=new java.util.Date();
		try {
			 d=sdf.parse(birthday);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date date=new java.sql.Date(d.getTime());
		String mobile=request.getParameter("mobile");
		String address=request.getParameter("address");
		User u=new User();
		u.setId(id);
		u.setName(name);
		u.setPassword(password2);
		u.setSex(sex);
		u.setBirthday(date);
		u.setMobile(mobile);
		u.setAddress(address);
		int result=0;	
		if(password1.equals(password2)){
			UserService us=new UserServiceImpl();
			result=us.updateUser(u);
		}			
		if(result>0){
			request.getRequestDispatcher("manage-result.jsp").forward(request, response);
		}else{
			request.setAttribute("meg", "修改失败！");
			request.getRequestDispatcher("user-modify.jsp").forward(request, response);
		}
	}

}
