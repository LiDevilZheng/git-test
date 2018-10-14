package com.yimaisc.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.yimaisc.comment.PageBean;
import com.yimaisc.dao.CategoryDao;
import com.yimaisc.dao.ProductDao;
import com.yimaisc.dao.impl.CategoryDaoImpl;
import com.yimaisc.dao.impl.ProductDaoImpl;
import com.yimaisc.entity.Category;
import com.yimaisc.entity.CategoryDTO;
import com.yimaisc.service.CategoryService;

public class CategoryServiceImpl implements CategoryService{
	private CategoryDao cd=new CategoryDaoImpl();
	@Override
	public void findParentByPage(PageBean<CategoryDTO> pb) {
		// TODO Auto-generated method stub
		int count=cd.getCategoryCount();
		pb.setCount(count);
		List<Category> pli=cd.findByPage(pb.getPageNo(), pb.getPageSize());
		List<CategoryDTO> li=new ArrayList<CategoryDTO>();
		for(Category c:pli){
			CategoryDTO cdo=new CategoryDTO();
			int parentId=c.getId();
			List<Category> cli=cd.findByParentId(parentId);
			cdo.setParent(c);
			cdo.setChilds(cli);
			li.add(cdo);
		}
		
		pb.setList(li);
	}	
	public static void main(String[] args){
		CategoryService cs=new CategoryServiceImpl();
		PageBean<CategoryDTO> pb=new PageBean<CategoryDTO>(1,3); 
		cs.findParentByPage(pb);
		List<CategoryDTO> li=pb.getList();
		for(CategoryDTO cd:li){
			System.out.println(cd.getParent().getName());
			List<Category> cli=cd.getChilds();
			for(Category c:cli){
				System.out.println(c.getName());
			}
		}
	}
	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return cd.getAllCategory();
	}
	@Override
	public int addCategory(Category c) {
		// TODO Auto-generated method stub
		return cd.addCategory(c);
	}
	@Override
	public Category findById(int id) {
		// TODO Auto-generated method stub
		return cd.findById(id);
	}
	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		ProductDao pd=new ProductDaoImpl();
		List<Category> cli=cd.findByParentId(id);
		if(cli.size()!=0){
			for(Category c:cli){
				int cid=c.getId();
				pd.updatePid(cid);
			}
		}else{
			pd.updatePid(id);
		}
		cd.deleteByParentId(id);
		return cd.delete(id);
	}
	@Override
	public int updateById(Category c) {
		// TODO Auto-generated method stub
		return cd.updateById(c);
	}
	@Override
	public List<Category> findByParentId(int parentId) {
		// TODO Auto-generated method stub
		return cd.findByParentId(parentId);
	}
}
