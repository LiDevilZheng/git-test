package com.yimaisc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yimaisc.dao.BaseDao;
import com.yimaisc.dao.OrderDao;
import com.yimaisc.entity.Order;
import com.yimaisc.entity.OrderParams;

public class OrderDaoImpl extends BaseDao implements OrderDao{
	private Connection con=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	@Override
	public int getOrderCount(OrderParams op) {
		// TODO Auto-generated method stub
		con=this.getConnection();
		int count=0;
		StringBuffer sql=new StringBuffer("SELECT COUNT(id) AS c FROM `order` WHERE 1=1 ");
		if(op.getId()!=null&&!op.getId().equals("")){
			sql.append(" AND id LIKE '%"+op.getId()+"%' ");
		}
		if(op.getUserId()!=null&&!op.getUserId().equals("")){
			sql.append(" AND user_id LIKE '%"+op.getUserId()+"%' ");
		}
		try {
			ps=con.prepareStatement(sql.toString());
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
	public List<Order> findByParams(int pageNo, int pageSize, OrderParams op) {
		// TODO Auto-generated method stub
		con=this.getConnection();
		List<Order> li=new ArrayList<Order>();
		StringBuffer sql=new StringBuffer("SELECT * FROM `order` WHERE 1=1 ");
		if(op.getId()!=null&&!op.getId().equals("")){
			sql.append(" AND id LIKE '%"+op.getId()+"%' ");
		}
		if(op.getUserId()!=null&&!op.getUserId().equals("")){
			sql.append(" AND user_id LIKE '%"+op.getUserId()+"%' ");
		}
		sql.append(" ORDER BY create_time DESC LIMIT ?,? ");
		//System.out.println(sql);
		try {
			ps=con.prepareStatement(sql.toString());
			ps.setInt(1, (pageNo-1)*pageSize);
			ps.setInt(2, pageSize);
			rs=ps.executeQuery();
			while(rs.next()){
				Order o=new Order(rs.getString(1), rs.getString(2), 
						rs.getString(3), rs.getString(4), rs.getTimestamp(5), 
						rs.getDouble(6), rs.getInt(7), rs.getInt(8));
			li.add(o);
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
	public int updateOrder(String id, int status) {
		// TODO Auto-generated method stub
		String sql="UPDATE `order` SET `status`=? WHERE id=?";
		Object []param={status,id};
		return this.executeUpdate(sql, param);
	}

	@Override
	public int addOrder(Order o) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO `order` (`id`,`user_id`,`name`,`address`,`create_time`,"
				+ "`cost`,`delete`,`status`) VALUES (?,?,?,?,?,?,?,?)";
		Object []param={o.getId(),o.getUserId(),o.getName(),o.getAddress(),
				o.getCreateTime(),o.getCost(),o.getDelete(),o.getStatus()};
		return this.executeUpdate(sql, param);
	}

}
