package com.yimaisc.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.yimaisc.comment.PageBean;
import com.yimaisc.dao.ProductDao;
import com.yimaisc.dao.impl.ProductDaoImpl;
import com.yimaisc.entity.Product;
import com.yimaisc.service.ProductService;

public class ProductServiceImpl implements ProductService{
	private ProductDao pd=new ProductDaoImpl();
	@Override
	public void findByPage(PageBean<Product> pb) {
		// TODO Auto-generated method stub
		int count=pd.getCount();
		pb.setCount(count);
		List<Product> list=pd.getAllProduct(pb.getPageNo(), pb.getPageSize());
		pb.setList(list);
	}
	@Override
	public int addProduct(Product p) {
		// TODO Auto-generated method stub
		return pd.addProduct(p);
	}
	@Override
	public int delById(int id) {
		// TODO Auto-generated method stub
		return pd.delById(id);
	}
	@Override
	public Product findById(int id) {
		// TODO Auto-generated method stub
		return pd.findById(id);
	}
	@Override
	public int updateById(Product p) {
		// TODO Auto-generated method stub
		return pd.updateById(p);
	}
	@Override
	public void findByPidPage(PageBean<Product> pb, int pid) {
		// TODO Auto-generated method stub
		int count=pd.getCountByPid(pid);
		pb.setCount(count);
		List<Product> list=pd.getProductByPid(pb.getPageNo(), pb.getPageSize(), pid);
		pb.setList(list);
	}
	@Override
	public void findByCidPage(PageBean<Product> pb, int cid) {
		// TODO Auto-generated method stub
		int count=pd.getCountByCid(cid);
		pb.setCount(count);
		List<Product> list=pd.getProductByCid(pb.getPageNo(), pb.getPageSize(), cid);
		pb.setList(list);
	}
	@Override
	public int updateStock(int id, int stock) {
		// TODO Auto-generated method stub
		return pd.updateStock(id, stock);
	}
	@Override
	public List<Product> findByStr(String str) {
		// TODO Auto-generated method stub
		List<Product> li=new ArrayList<Product>();
		String []s=str.split("a");
		for(int i=0;i<s.length;i++){
			Product p=new Product();
			p=pd.findById(Integer.parseInt(s[i]));
			li.add(p);
		}
		return li;
	}
}
