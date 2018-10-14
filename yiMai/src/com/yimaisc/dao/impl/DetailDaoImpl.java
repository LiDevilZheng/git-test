package com.yimaisc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yimaisc.dao.BaseDao;
import com.yimaisc.dao.DetailDao;
import com.yimaisc.entity.Detail;

public class DetailDaoImpl extends BaseDao implements DetailDao{
	private Connection con=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	@Override
	public List<Detail> findByOrderId(String oId) {
		// TODO Auto-generated method stub
		List<Detail> li=new ArrayList<Detail>();
		con=this.getConnection();
		String sql="SELECT d.id,d.oid,d.pid,d.quantity,d.cost,p.name,p.file_name,p.price "
				+ "FROM detail d INNER JOIN product p ON d.pid=p.id WHERE oid=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1,oId);
			rs=ps.executeQuery();
			while(rs.next()){
				Detail d=new Detail( rs.getInt(1),rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getDouble(5), 
						rs.getString(6), rs.getString(7), rs.getDouble(8));				
				li.add(d);
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
	public int addDetail(Detail d) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO `detail` (`oid`,`pid`,`quantity`,`cost`) VALUES(?,?,?,?)";
		Object []param={d.getOid(),d.getPid(),d.getQuantity(),d.getCost()};
		return this.executeUpdate(sql, param);
	}
}
