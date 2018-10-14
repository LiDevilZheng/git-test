package com.jbit.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jbit.dto.ProviderParams;
import com.jbit.entity.Provider;
import com.jbit.entity.SmbmsUser;
import com.jbit.service.ProviderService;

/**
 *
 *@author 栗子
 *@description 
 */
@Controller
@RequestMapping("jsp")
public class providerController {
@Autowired
	private ProviderService ps;
	private List<String> allowedType=Arrays.asList("jpg","png","gif");
	public ProviderService getPs() {
		return ps;
	}
	public void setPs(ProviderService ps) {
		this.ps = ps;
	}
	@RequestMapping("/providerlist.html")
	public String ProviderList(ProviderParams params,Model model){
			ps.findProvider(params);
			model.addAttribute("params",params);
		return "jsp/providerlist";
	}
	@RequestMapping("providerview.html")
	public String findById(int id,Model model){
		model.addAttribute("provider", ps.findById(id));
		System.out.println(ps.findById(id).getProName());
		return "jsp/providerview";
	}
	/**
	 * rest风格
	 */
	@RequestMapping(value="provider/{id}",method=RequestMethod.GET,produces="application/json;charset=utf-8")//json数据传递的中文乱码问题响应格式及编码
	@ResponseBody  //响应成一个json对象
	public Object findById(@PathVariable("id")int id){
		return ps.findById(id);
	}
	
	@RequestMapping(value="providers",method=RequestMethod.GET)
	@ResponseBody
	public Object getAllproName(){
		List<Provider> li=ps.getAllproName();
		for(Provider p:li){
			System.out.println(p.getProName());
		}	
		return ps.getAllproName();
	}
	
	
	@RequestMapping("findByproCode.html")
	@ResponseBody
	public Object findByUserCode(String proCode){
		Provider temp=ps.findByProCode(proCode);
		System.out.println(temp);
		if(temp!=null){
			return "error";
		}else{
			return "success";
		}
	}
	@RequestMapping("addProvider.html")
	public String addProvider(@Valid Provider p,Model model,MultipartFile []pics,HttpSession session){
		String path=session.getServletContext().getRealPath("/provider_pic");//获取路径名
		File f=new File(path);
		if(!f.exists()){//创建文件夹
			f.mkdir();
		}
		for(MultipartFile pic:pics){
			if(!pic.isEmpty()){
				String oldName=pic.getOriginalFilename();//获取原始图片名称
				String type=oldName.substring(oldName.lastIndexOf(".")+1);//获取后缀名
				if(!allowedType.contains(type)){
					model.addAttribute("file_error","上传的文件格式不正确！");
					return "jsp/provideradd";
				}
			}
		}
		for(int i=0;i<pics.length;i++){
			if(!pics[i].isEmpty()){
				String oldName=pics[i].getOriginalFilename();//获取原始图片名称
				String type=oldName.substring(oldName.lastIndexOf(".")+1);//获取后缀名
				String newName=UUID.randomUUID().toString().replace("-", "")+"."+type;
				File upload=new File(path+"/"+newName);
				try {
					pics[i].transferTo(upload);//上传
					if(i==0){
						p.setIdPic(newName);
					}else if(i==1){
						p.setWorkPic(newName);
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
		SmbmsUser u=(SmbmsUser)session.getAttribute("su");
		p.setCreatedBy(u.getId());
		Timestamp t=new Timestamp(System.currentTimeMillis());
		p.setCreationDate(t);
		int r=ps.addProvider(p);
		if(r>0){
			return "redirect:providerlist.html";
		}else{
			model.addAttribute("user_error", "供应商编码已经存在");
			return "jsp/provideradd";
		}	
	}
}
