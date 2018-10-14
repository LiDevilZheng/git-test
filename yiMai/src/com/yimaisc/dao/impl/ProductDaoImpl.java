package com.yimaisc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yimaisc.dao.BaseDao;
import com.yimaisc.dao.ProductDao;
import com.yimaisc.entity.Product;

/**
 *
 *@author 栗子
 *@description 
 */
public class ProductDaoImpl extends BaseDao implements ProductDao{
	private Connection con=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	@Override
	public int updatePid(int id) {
		// TODO Auto-generated method stub
		String sql="UPDATE product SET pid=1 WHERE pid=?";
		Object []param={id};
		return this.executeUpdate(sql, param);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		con=this.getConnection();
		int count=0;
		String sql="SELECT COUNT(id) AS c FROM `product` WHERE `delete`=0";
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
	public List<Product> getAllProduct(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		con=this.getConnection();
		List<Product> li=new ArrayList<Product>();
		String sql="SELECT `id`,`name`,`description`,`price`,`stock`," +
				"`pid`,`cid`,`file_name`,`delete` FROM " +
				" `product` WHERE `delete`=0  LIMIT ?,?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, (pageNo-1)*pageSize);
			ps.setInt(2, pageSize);
			rs=ps.executeQuery();
			while(rs.next()){
				Product p=new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getInt(9));
				li.add(p);
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
	public int addProduct(Product p) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO `product` (`name`,`description`,`price`," +
				"`stock`,`pid`,`cid`,`file_name`,`delete`) " +
				"VALUES(?,?,?,?,?,?,?,?)";
		Object []param={p.getName(),p.getDescription(),p.getPrice(),
				p.getStock(),p.getPid(),p.getCid(),p.getFileName(),p.getDelete()};
		return this.executeUpdate(sql, param);
	}

	@Override
	public int delById(int id) {
		// TODO Auto-generated method stub
		String sql="UPDATE `product` SET `delete`=1 WHERE id=?";
		Object []param={id};
		return this.executeUpdate(sql, param);
	}

	@Override
	public Product findById(int id) {
		// TODO Auto-generated method stub
		con=this.getConnection();
		Product p=null;
		String sql="SELECT `id`,`name`,`description`,`price`,`stock`," +
				"`pid`,`cid`,`file_name`,`delete` FROM `product` " +
				"WHERE id=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next()){
				p=new Product(rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getDouble(4), rs.getInt(5), rs.getInt(6), 
						rs.getInt(7), rs.getString(8), rs.getInt(9));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(con, ps, rs);
		}
		return p;
	}

	@Override
	public int updateById(Product p) {
		// TODO Auto-generated method stub
		String sql="UPDATE `product` SET `name`=?,`description`=?," +
				"`price`=?,`stock`=?,`pid`=?,`cid`=?,`file_name`=? WHERE `id`=?";
		Object []param={p.getName(),p.getDescription(),p.getPrice(),
				p.getStock(),p.getPid(),p.getCid(),p.getFileName(),p.getId()};
		return this.executeUpdate(sql, param);
	}

	@Override
	public List<Product> getProductByPid(int pageNo, int pageSize, int pid) {
		// TODO Auto-generated method stub
		con=this.getConnection();
		List<Product> li=new ArrayList<Product>();
		String sql="SELECT `id`,`name`,`description`,`price`,`stock`," +
				"`pid`,`cid`,`file_name`,`delete` FROM " +
				" `product` WHERE `delete`=0 AND `pid`=?  LIMIT ?,?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, pid);
			ps.setInt(2, (pageNo-1)*pageSize);
			ps.setInt(3, pageSize);
			rs=ps.executeQuery();
			while(rs.next()){
				Product p=new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getInt(9));
				li.add(p);
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
	public int getCountByPid(int pid) {
		// TODO Auto-generated method stub
		con=this.getConnection();
		int count=0;
		String sql="SELECT COUNT(id) AS c FROM `product` WHERE `delete`=0 AND `pid`=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, pid);
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
	public List<Product> getProductByCid(int pageNo, int pageSize, int cid) {
		// TODO Auto-generated method stub
		con=this.getConnection();
		List<Product> li=new ArrayList<Product>();
		String sql="SELECT `id`,`name`,`description`,`price`,`stock`," +
				"`pid`,`cid`,`file_name`,`delete` FROM " +
				" `product` WHERE `delete`=0 AND `cid`=?  LIMIT ?,?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, cid);
			ps.setInt(2, (pageNo-1)*pageSize);
			ps.setInt(3, pageSize);
			rs=ps.executeQuery();
			while(rs.next()){
				Product p=new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getInt(9));
				li.add(p);
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
	public int getCountByCid(int cid) {
		// TODO Auto-generated method stub
		con=this.getConnection();
		int count=0;
		String sql="SELECT COUNT(id) AS c FROM `product` WHERE `delete`=0 AND `cid`=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, cid);
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
	public int updateStock(int id, int stock) {
		// TODO Auto-generated method stub
		String sql="update product set stock=? where id=?";
		Object []param={stock,id};
		return this.executeUpdate(sql, param);
	}
}
