package com.jbit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jbit.entity.Role;
import com.jbit.service.RoleService;

/**
 *
 *@author 栗子
 *@description 
 */
@Controller
@RequestMapping("jsp")
public class RoleController {
@Autowired
	private RoleService rs;
	public RoleService getRs() {
		return rs;
	}
	public void setRs(RoleService rs) {
		this.rs = rs;
	}
	@RequestMapping(value="roles",method=RequestMethod.GET)
	@ResponseBody
	public Object getAll(){
		return rs.getAll();
	}
	
	@RequestMapping(value="roles/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Object findById(@PathVariable int id){
		return rs.findById(id);
	}
}
