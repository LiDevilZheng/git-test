package com.jbit.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jbit.entity.SmbmsUser;
import com.jbit.service.SmbmsUserService;

/**
 *
 *@author 栗子
 *@description 
 */
@Controller
public class LoginController {
	@Autowired
	private SmbmsUserService us;

	public SmbmsUserService getUs() {
		return us;
	}
	public void setUs(SmbmsUserService us) {
		this.us = us;
	}
	@RequestMapping("login.html")
	public String login(String userCode,String userPassword,Model m,HttpSession session){
		SmbmsUser su=us.login(userCode, userPassword);
		if(su==null){
			m.addAttribute("msg", "用户名密码错误！");
			return "login";
		}else{
			session.setAttribute("su", su);
			return "redirect:jsp/frame.jsp";
		}
	}
	@RequestMapping("jsp/loginOut.html")
	public String loginOut(HttpSession session){
		session.removeAttribute("su");
		//int c=10/0;
		return "redirect:../login.jsp";//写了前缀要补齐
	}
	//局部异常
	@ExceptionHandler(value={RuntimeException.class})
	public String myException(RuntimeException e){
		e.printStackTrace();
		return "error";
	}
}
