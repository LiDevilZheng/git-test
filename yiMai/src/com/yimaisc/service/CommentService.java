package com.yimaisc.service;

import java.util.List;

import com.yimaisc.comment.PageBean;
import com.yimaisc.entity.Comment;


/**
 *
 *@author 
 *@description 
 */
public interface CommentService {
	List<Comment> getAllComment();
	/**
	 * 每页的内容
	 */
	public abstract void findByPage(PageBean<Comment> pb);
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
