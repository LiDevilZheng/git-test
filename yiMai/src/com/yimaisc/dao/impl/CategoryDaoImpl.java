package com.yimaisc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.yimaisc.dao.BaseDao;
import com.yimaisc.dao.CategoryDao;
import com.yimaisc.entity.Category;
public class CategoryDaoImpl extends BaseDao implements CategoryDao{
	private Connection con=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	@Override
	public int getCategoryCount() {
		// TODO Auto-generated method stub
		con=this.getConnection();
		int count=0;
		String sql="SELECT COUNT(parent_id) AS c FROM category WHERE parent_id=0";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()){
				count=rs.getInt("c");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(con, ps, rs);
		}
		return count;
	}
	@Override
	public List<Category> findByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		con=this.getConnection();
		List<Category> li=new ArrayList<Category>();
		String sql="SELECT id ,`name`,parent_id FROM category WHERE parent_id=0 LIMIT ?,?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, (pageNo-1)*pageSize);
			ps.setInt(2, pageSize);
			rs=ps.executeQuery();
			while(rs.next()){
				Category c=new Category(rs.getInt("id"), rs.getString("name"), rs.getInt("parent_id"));
				li.add(c);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(con, ps, rs);
		}
		return li;
	}

	@Override
	public List<Category> findByParentId(int parentId) {
		// TODO Auto-generated method stub
		con=this.getConnection();
		List<Category> li=new ArrayList<Category>();
		String sql="SELECT id ,`name`,parent_id FROM category WHERE parent_id=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, parentId);
			rs=ps.executeQuery();
			while(rs.next()){
				Category c=new Category(rs.getInt("id"), rs.getString("name"), rs.getInt("parent_id"));
				li.add(c);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(con, ps, rs);
		}
		return li;
	}

	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		con=this.getConnection();
		List<Category> li=new ArrayList<Category>();
		String sql="SELECT id ,`name`,parent_id FROM category WHERE parent_id=0";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				Category c=new Category(rs.getInt("id"), rs.getString("name"), rs.getInt("parent_id"));
				li.add(c);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(con, ps, rs);
		}
		return li;
	}
	@Override
	public int addCategory(Category c) {
		// TODO Auto-generated method stub
		String sql="INSERT  INTO `category`(`name`,`parent_id`) VALUES (?,?)";
		Object []param={c.getName(),c.getParentId()};
		return this.executeUpdate(sql, param);
	}

	@Override
	public Category findById(int id) {
		// TODO Auto-generated method stub
		con=this.getConnection();
		Category c=null;
		String sql="SELECT id,`name`,`parent_id` FROM `category` WHERE id=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next()){
				c=new Category(rs.getInt("id"), rs.getString("name"), rs.getInt("parent_id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(con, ps, rs);
		}		
		return c;
	}
	@Override
	public int deleteByParentId(int parentId) {
		// TODO Auto-generated method stub
		String sql="DELETE FROM category WHERE parent_id=?";
		Object []param={parentId};
		return this.executeUpdate(sql, param);
	}
	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		String sql="DELETE FROM category WHERE id=?";
		Object []param={id};
		return this.executeUpdate(sql, param);
	}
	@Override
	public int updateById(Category c) {
		// TODO Auto-generated method stub
		String sql="update category set name=? where id=?";
		Object []param={c.getName(),c.getId()};
		return this.executeUpdate(sql, param);
	}
}
