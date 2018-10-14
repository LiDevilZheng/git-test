package com.yimaisc.dao;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;





public class BaseDao {
	
	private static String CLASSNAME="com.mysql.jdbc.Driver";
	private static String URL="jdbc:mysql://localhost:3306/kgcnews?useUnicode=true&characterEncoding=utf-8";
	private static String USERNAME="root";
	private static String PASSWORD="123456";
	Connection conn=null;
	static{
		Properties params=new Properties();
		try {
			InputStream is=BaseDao.class.getClassLoader().getResourceAsStream("database.properties");
			params.load(is);
			CLASSNAME=params.getProperty("driver");
			URL=params.getProperty("url");
			USERNAME=params.getProperty("username");
			PASSWORD=params.getProperty("password");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @return
	 */
	public Connection getConnection(){
		try {
			Class.forName(CLASSNAME);
			conn=DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*Context ctx;
		try {
			ctx = new InitialContext();
			DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/news");
			conn=ds.getConnection();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		return conn;
	}
	/**
	 * 关闭资源
	 * @param con
	 * @param ps
	 * @param rs
	 */
	public void closeAll(Connection con,Statement ps,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * 增删改操作
	 * @param sql
	 * @param param
	 * @return
	 */
	public int executeUpdate(String sql,Object...param){
		PreparedStatement ps=null;
		int result=0;
		conn=this.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			if(param!=null){
				for(int i=0;i<param.length;i++){
					ps.setObject(i+1, param[i]);
				}
			}
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(conn, ps, null);
		}
		return result;
	}
}
