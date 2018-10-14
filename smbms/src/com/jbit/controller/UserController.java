package com.jbit.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jbit.dto.SmbmsUserParams;
import com.jbit.entity.SmbmsUser;
import com.jbit.service.SmbmsUserService;

/**
 *
 *@author 栗子
 *@description 
 */
@Controller
@RequestMapping("jsp")
public class UserController {
	@Autowired
	private SmbmsUserService sus;
	private List<String> allowedType=Arrays.asList("jpg","png","jpeg");
	public SmbmsUserService getSus() {
		return sus;
	}
	public void setSus(SmbmsUserService sus) {
		this.sus = sus;
	}
	@RequestMapping("/userlist.html")
	public String userList(SmbmsUserParams params,Model model){
		sus.findUsers(params);
		model.addAttribute("params", params);
		return "jsp/userlist";
	}
	@RequestMapping("findByUserCode.html")
	@ResponseBody
	public Object findByUserCode(String userCode){
		SmbmsUser temp=sus.findByUserCode(userCode);
		System.out.println(temp);
		if(temp!=null){
			return "error";
		}else{
			return "success";
		}
	}
	@RequestMapping("addUser.html")
	public String addUser(@Valid SmbmsUser user,BindingResult result,Model model,MultipartFile []pics,HttpServletRequest request){
		/*验证信息if(result.hasErrors()){
			List<FieldError> li=result.getFieldErrors();
			for(FieldError f:li){
				model.addAttribute("error_"+f.getField(), f.getDefaultMessage());
				//System.out.println(f.getField()+","+f.getDefaultMessage());
			}
			return "jsp/useradd";
		}*/
		String path=request.getSession().getServletContext().getRealPath("/pic");
		File f=new File(path);
		if(!f.exists()){
			f.mkdir();
		}
		for(MultipartFile pic:pics){//验证格式
			if(!pic.isEmpty()){
				String fname=pic.getOriginalFilename();//获取原始图片的名字
				String type=fname.substring(fname.lastIndexOf(".")+1);
				if(!allowedType.contains(type.toLowerCase())){
					model.addAttribute("file_error", "只能上传图片格式");
					return "jsp/useradd";
				}
			}
		}
		for(int i=0;i<pics.length;i++){//上传
			if(!pics[i].isEmpty()){
				String fname=pics[i].getOriginalFilename();//获取原始图片的名字
				String type=fname.substring(fname.lastIndexOf(".")+1);
				String newName=UUID.randomUUID().toString().replace("-", "")+"."+type;
				File uploadFile=new File(path+"/"+newName);
				try {
					pics[i].transferTo(uploadFile);//上传
					if(i==0){
						user.setIdPic(newName);
					}else if(i==1){
						user.setWorkPic(newName);
					}
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}		
		}
		SmbmsUser u=(SmbmsUser)request.getSession().getAttribute("su");
		System.out.println(u.getId());
		user.setCreatedBy(u.getId());
		Timestamp t=new Timestamp(System.currentTimeMillis());
		user.setCreationDate(t);
		int r=sus.addUser(user);
		if(r>0){
			System.out.println(user);
			return "redirect:userlist.html";
		}else{
			model.addAttribute("user_error", "用户编码已经存在");
			return "jsp/useradd";
		}
		
		
	}
	/**
	 * rest风格
	 */
	@RequestMapping(value="user/{id}",method=RequestMethod.GET,produces="application/json;charset=utf-8")//json数据传递的中文乱码问题响应格式及编码
	@ResponseBody  //响应成一个对象
	public Object findById(@PathVariable("id")int id){
		return sus.findById(id);
	}
	@RequestMapping("findById.html")
	public String findUserById(int id,Model model){
		model.addAttribute("user",sus.findById(id));
		return "jsp/userview";
	}
	/*@RequestMapping(value="view/{id}",method=RequestMethod.GET)
	public String view(@PathVariable int id,Model model){
		SmbmsUser user=	sus.findById(id);
		model.addAttribute("user",user);
		return "jsp/userview";
	}*/
	@RequestMapping("usermodify.html")
	public String updateById(int id,Model model){
		model.addAttribute("user",sus.findById(id));
		return "jsp/usermodify";
	}
	@RequestMapping("updateUser.html")
	public String doUpdate(SmbmsUser user){
		int result=sus.updateUser(user);
		if(result>0){
			return "redirect:userlist.html";
		}else{
			return "jsp/usermodify";
		}
	}
	@RequestMapping("checkPwd.html")
	@ResponseBody
	public Object checkPwd(String oldPwd,HttpSession session){
		SmbmsUser user=(SmbmsUser)session.getAttribute("su");
		if(user.getUserPassword().equals(oldPwd)){
			System.out.println("密码正确");
			return "success";
		}else{
			System.out.println("密码错误！");
			return "error";
		}
	}
	@RequestMapping("updatePassword.html")
	public String updatePassword(String newpassword,String rnewpassword,String oldpassword,Model model,HttpSession session){
		SmbmsUser user=(SmbmsUser)session.getAttribute("su");
		if(!newpassword.equals("")&&!rnewpassword.equals("")&&!oldpassword.equals("")){
			int result=sus.updateUserPassword(user.getId(),newpassword);
			if(result>0){
				model.addAttribute("meg", "更改密码成功！");
			}else{
				model.addAttribute("meg", "更新失败！");
			}
		}else{
			model.addAttribute("meg", "请先完成输入！");
		}	
		return "jsp/pwdmodify";
	}
}
