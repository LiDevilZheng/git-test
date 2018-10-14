package com.jbit.dto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jbit.entity.SmbmsUser;

/**
 *
 *@author 栗子
 *@description 
 */
public class LoginInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		// TODO Auto-generated method stub
		SmbmsUser u=(SmbmsUser)request.getSession().getAttribute("user");
		if(u!=null){
			return true;
		}else{
			response.sendRedirect(request.getContextPath()+"/login.jsp");//绝对路径
			return false;
		}	
	}
}
