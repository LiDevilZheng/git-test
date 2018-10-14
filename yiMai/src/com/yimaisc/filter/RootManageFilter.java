package com.yimaisc.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yimaisc.entity.User;

public class RootManageFilter implements Filter{
	private List<String> list=Arrays.asList("/shopping.jsp","/address.action","/order.jsp");
	@Override
	public void destroy() {
		// TODO Auto-generated method stub		
	}
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request=(HttpServletRequest)arg0;
		HttpServletResponse response=(HttpServletResponse)arg1;
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		//获得访问路径
		String path=request.getServletPath();
		//1.判断是否访问后台
		if(path.startsWith("/manage")){
			if(user==null){
				response.sendRedirect("../login.jsp");
			}else if(user.getStatus()==1){
				response.sendRedirect("index.action");
			}else{
				arg2.doFilter(arg0, arg1);
			}
		}else if(list.contains(path)){//访问前台时是否登录
			if(user==null){
				response.sendRedirect("login.jsp");
			}else{
				arg2.doFilter(arg0, arg1);
			}
		}else{
			arg2.doFilter(arg0, arg1);
		}
		/*HttpSession session=request.getSession(false);
		if(session!=null&&session.getAttribute("user")!=null){
			arg2.doFilter(arg0, arg1);
		}else{
			System.out.println(request.getContextPath());
			System.out.println(request.getServletPath());
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		}*/
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub	
	}
}
