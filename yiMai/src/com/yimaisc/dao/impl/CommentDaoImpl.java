package com.yimaisc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yimaisc.dao.BaseDao;
import com.yimaisc.dao.CommentDao;
import com.yimaisc.entity.Comment;


/**
 *
 *@author 极道鲜栗
 *@description 
 */
public class CommentDaoImpl extends BaseDao implements CommentDao{
	private Connection con=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	@Override
	public List<Comment> getAllComment() {
		// TODO Auto-generated method stub
		con=this.getConnection();
		List<Comment> li=new ArrayList<Comment>();
		String sql="SELECT id,content,create_time,reply,reply_time,nickname FROM `comment`";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				Comment c=new Comment(rs.getInt("id"), rs.getString("content"), rs.getTimestamp("create_time"), rs.getString("reply"), rs.getTimestamp("reply_time"), rs.getString("nickname"));
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
	public int getCommentCount() {
		// TODO Auto-generated method stub
		con=this.getConnection();
		int count=0;
		String sql="SELECT COUNT(`id`) AS c FROM `comment`";
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
	public List<Comment> getComment(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		con=this.getConnection();
		List<Comment> li=new ArrayList<Comment>();
		String sql="SELECT `id`,`content`,`create_time`,reply,reply_time,nickname FROM `comment` ORDER BY create_time DESC LIMIT ?,?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, (pageNo-1)*pageSize);
			ps.setInt(2, pageSize);
			rs=ps.executeQuery();
			while(rs.next()){
				Comment c=new Comment(rs.getInt("id"), rs.getString("content"), rs.getTimestamp("create_time"),rs.getString("reply"), rs.getTimestamp("reply_time"),rs.getString("nickname"));
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
	public Comment findById(int id) {
		// TODO Auto-generated method stub
		con=this.getConnection();
		Comment c=null;
		String sql="SELECT id,content,create_time,reply,reply_time,nickname FROM `comment` WHERE id=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next()){
				c=new Comment(rs.getInt("id"), rs.getString("content"), rs.getTimestamp("create_time"), rs.getString("reply"), rs.getTimestamp("reply_time"), rs.getString("nickname"));
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
	public int updateComment(Comment c) {
		// TODO Auto-generated method stub
		String sql="UPDATE `comment` SET reply=?,reply_time=? WHERE id=? ";
		Object []param={c.getReply(),c.getReplyTime(),c.getId()};
		return this.executeUpdate(sql, param);
	}
	@Override
	public int delComment(int id) {
		// TODO Auto-generated method stub
		String sql="UPDATE `comment` SET reply=NULL,reply_time=NULL WHERE id=?";
		Object[] param={id};
		return this.executeUpdate(sql, param);
	}
	@Override
	public int addComment(Comment c) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO `comment` (`content`,`create_time`,`nickname`) VALUES (?,?,?)";
		Object []param={c.getContent(),c.getCreateTime(),c.getNickName()};
		return this.executeUpdate(sql, param);
	}

}
