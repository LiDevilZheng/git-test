package com.yimaisc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yimaisc.dao.BaseDao;
import com.yimaisc.dao.NewsDao;
import com.yimaisc.entity.News;

/**
 *
 *@author Рѕзг
 *@description 
 */
public class NewsDaoImpl extends BaseDao implements NewsDao{
	private Connection con=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	@Override
	public List<News> getAllNews() {
		// TODO Auto-generated method stub
		con=this.getConnection();
		List<News> li=new ArrayList<News>();
		String sql="SELECT `id`,`title`,`content`,`createTime` FROM `news`";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				News news=new News(rs.getInt("id"), rs.getString("title"), rs.getString("content"), rs.getTimestamp("createTime"));
				li.add(news);
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
	public int addNews(News news) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO `news` (`title`,`content`,`createTime`) VALUES (?,?,?)";
		Object param[]={news.getTitle(),news.getContent(),news.getCreateTime()};
		return this.executeUpdate(sql, param);
	}

	@Override
	public int updateNews(News news) {
		// TODO Auto-generated method stub
		String sql="UPDATE `news` SET `title`=?,`content`=?,`createTime`=? WHERE `id`=?";
		Object param[]={news.getTitle(),news.getContent(),news.getCreateTime(),news.getId()};
		return this.executeUpdate(sql, param);
	}

	@Override
	public int deleteNews(int id) {
		// TODO Auto-generated method stub
		String sql="DELETE FROM `news` WHERE id=?";
		Object param[]={id};
		return this.executeUpdate(sql, param);
	}

	@Override
	public News findById(int id) {
		// TODO Auto-generated method stub
		con=this.getConnection();
		News news=null;
		String sql="SELECT `id`,`title`,`content`,`createTime` FROM `news` WHERE id=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next()){
				news=new News(rs.getInt("id"), rs.getString("title"), rs.getString("content"), rs.getTimestamp("createTime"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(con, ps, rs);
		}
		return news;
	}

	@Override
	public int getNewsCount() {
		// TODO Auto-generated method stub
		con=this.getConnection();
		int count=0;
		String sql="SELECT COUNT(`id`) AS c FROM `news`";
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
	public List<News> getNews(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		con=this.getConnection();
		List<News> li=new ArrayList<News>();
		String sql="SELECT `id`,`title`,`content`,`createTime` FROM `news` ORDER BY createTime DESC LIMIT ?,?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, (pageNo-1)*pageSize);
			ps.setInt(2, pageSize);
			rs=ps.executeQuery();
			while(rs.next()){
				News news=new News(rs.getInt("id"), rs.getString("title"), rs.getString("content"), rs.getTimestamp("createTime"));
				li.add(news);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(con, ps, rs);
		}
		return li;
	}

}
