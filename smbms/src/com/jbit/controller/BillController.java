package com.jbit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jbit.dto.BillParams;
import com.jbit.service.BillService;

/**
 *
 *@author 栗子
 *@description 
 */
@Controller
@RequestMapping("jsp")
public class BillController {
@Autowired
	private BillService bs;
	public BillService getBs() {
		return bs;
	}
	public void setBs(BillService bs) {
		this.bs = bs;
	}
	@RequestMapping("/billlist.html")
	public String billList(BillParams params,Model model){
		System.out.println(params.getIsPayment());
		bs.findBills(params);
		model.addAttribute("params",params);
		return "jsp/billlist";
	}
	@RequestMapping(value="bill/{id}",method=RequestMethod.GET,produces="application/json;charset=utf-8")
	@ResponseBody
	public Object findById(@PathVariable("id")int id){
		return "";
	}
	@RequestMapping("billview.html")
	public String findById(int id,Model model){	
		model.addAttribute("","");
		return "jsp/billview";
	}
}
