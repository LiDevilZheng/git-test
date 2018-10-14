package com.yimaisc.dao;

import java.util.List;

import com.yimaisc.entity.Comment;


/**
 *
 *@author 
 *@description 
 */
public interface CommentDao {
	List<Comment> getAllComment();
	/**
	 * 查询总条数
	 */
	int getCommentCount();
	/**
	 * 每页的内容
	 */
	List<Comment> getComment(int pageNo,int pageSize);
	/**
	 * 根据id查询信息
	 */
	Comment findById(int id);
	/**
	 * 根据ID修改评论内容
	 */
	int updateComment(Comment c);
	/**
	 * 根据id删除回复
	 */
	int delComment(int id);
	/**
	 * 新增留言
	 */
	int addComment(Comment c);
}
