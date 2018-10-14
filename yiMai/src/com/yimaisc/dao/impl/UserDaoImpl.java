package com.yimaisc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import com.yimaisc.dao.BaseDao;
import com.yimaisc.dao.UserDao;
import com.yimaisc.entity.User;

public class UserDaoImpl extends BaseDao implements UserDao{
	private Connection con=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	@Override
	public List<User> getAllUser(int pageNo, int pageSize){
		// TODO Auto-generated method stub
		con=this.getConnection();
		List<User> li=new ArrayList<User>();
		String sql="SELECT `id`,`name`,`password`,`sex`,`birthday`," +
				"`identity`,`email`,`mobile`,`address`,`delete`,`status` FROM" +
				" `user` WHERE `delete`=0 AND `status`=1 LIMIT ?,?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, (pageNo-1)*pageSize);
			ps.setInt(2, pageSize);
			rs=ps.executeQuery();
			while(rs.next()){
				User u=new User(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getDate(5), rs.getString(6), 
						rs.getString(7), rs.getString(8), rs.getString(9), 
						rs.getInt(10), rs.getInt(11));
				li.add(u);
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
	public int updateUser(User u) {
		// TODO Auto-generated method stub
		String sql="UPDATE `user` SET `name`=?,`password`=?,`sex`=?,`birthday`=?,`mobile`=?,`address`=? WHERE id=?";
		Object param[]={u.getName(),u.getPassword(),u.getSex(),u.getBirthday(),u.getMobile(),u.getAddress(),u.getId()};
		return this.executeUpdate(sql, param);
	}
	@Override
	public int delUser(String id) {
		// TODO Auto-generated method stub
		String sql="UPDATE `user` SET `delete`=1 WHERE id=?";
		Object param[]={id};
		return this.executeUpdate(sql, param);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		con=this.getConnection();
		int count=0;
		String sql="SELECT COUNT(id) AS c FROM `user` WHERE `delete`=0 AND `status`=1";
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
	public User findById(String id) {
		// TODO Auto-generated method stub
		con=this.getConnection();
		User user=null;
		String sql="SELECT * FROM `user` WHERE id=?";
		try {
			ps=con.prepareStatement(sql);	
			ps.setString(1, id);
			rs=ps.executeQuery();
			if(rs.next()){
				user=new User(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getDate(5), rs.getString(6), 
						rs.getString(7), rs.getString(8), rs.getString(9), 
						rs.getInt(10), rs.getInt(11));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(con, ps, rs);
		}
		return user;
	}

	@Override
	public User login(String id, String password) {
		// TODO Auto-generated method stub
		con=this.getConnection();
		User user=null;
		String sql="SELECT * FROM `user` WHERE `id`=? AND `password`=? AND `delete`=0";
		try {
			ps=con.prepareStatement(sql);	
			ps.setString(1, id);
			ps.setString(2, password);
			rs=ps.executeQuery();
			if(rs.next()){
				user=new User(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getDate(5), rs.getString(6), 
						rs.getString(7), rs.getString(8), rs.getString(9), 
						rs.getInt(10), rs.getInt(11));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(con, ps, rs);
		}
		return user;
	}
	@Override
	public int addUser(User u) {
		// TODO Auto-generated method stub
		String sql="INSERT  INTO `user`(`id`,`name`,`password`,`sex`,`birthday`,`identity`,`email`,"
				+ "`mobile`,`address`,`delete`,`status`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		Object []param={u.getId(),u.getName(),u.getPassword(),u.getSex(),u.getBirthday(),u.getIdentity(),
				u.getEmail(),u.getMobile(),u.getAddress(),u.getDelete(),u.getStatus()};
		return this.executeUpdate(sql, param);
	}

	@Override
	public int addUserAddress(String id, String address) {
		// TODO Auto-generated method stub
		String sql="update user set address=? where id=?";
		Object []param={address,id};
		return this.executeUpdate(sql, param);
	}
}
