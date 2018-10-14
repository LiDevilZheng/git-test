package com.yimaisc.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yimaisc.entity.User;
import com.yimaisc.service.UserService;
import com.yimaisc.service.impl.UserServiceImpl;

/**
 *
 *@author 栗子
 *@description 
 */
public class RegisterAction extends HttpServlet {

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
		response.setContentType("text/json;charset=utf-8");
		String id=request.getParameter("userId");
		String name=request.getParameter("userName");
		String password=request.getParameter("password");
		String confirmPassword=request.getParameter("confirmPassword");
		String sex=request.getParameter("sex");
		if(sex.equals("male")){
			sex="男";
		}else if(sex.equals("female")){
			sex="女";
		}
		String birthday=request.getParameter("birthday");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date d=new java.util.Date();
		try {
			d=sdf.parse(birthday);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date time=new java.sql.Date(d.getTime());
		
		String identity=request.getParameter("identityCode");
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		String address=request.getParameter("address");
		PrintWriter out = response.getWriter();
		UserService us=new UserServiceImpl();
		User u=new User(id, name, password, sex, time, identity, email, mobile, address, 0, 1);
		int result=us.addUser(u);
		if(result>0){
			out.print(true);
		}else{
			out.print(false);
		}
		out.flush();
		out.close();
	}

}
