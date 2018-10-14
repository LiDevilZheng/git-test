package com.yimaisc.service.impl;

import java.util.List;

import com.yimaisc.comment.PageBean;
import com.yimaisc.dao.CommentDao;
import com.yimaisc.dao.impl.CommentDaoImpl;
import com.yimaisc.entity.Comment;

import com.yimaisc.service.CommentService;

/**
 *
 *@author 
 *@description 
 */
public class CommentServiceImpl implements CommentService{
	private CommentDao cd=new CommentDaoImpl();
	@Override
	public List<Comment> getAllComment() {
		// TODO Auto-generated method stub
		return cd.getAllComment();
	}
	@Override
	public void findByPage(PageBean<Comment> pb) {
		// TODO Auto-generated method stub
		int count=cd.getCommentCount();
		pb.setCount(count);
		List<Comment> list=cd.getComment(pb.getPageNo(), pb.getPageSize());
		pb.setList(list);
	}
	@Override
	public Comment findById(int id) {
		// TODO Auto-generated method stub
		return cd.findById(id);
	}
	@Override
	public int updateComment(Comment c) {
		// TODO Auto-generated method stub
		return cd.updateComment(c);
	}
	@Override
	public int delComment(int id) {
		// TODO Auto-generated method stub
		return cd.delComment(id);
	}
	@Override
	public int addComment(Comment c) {
		// TODO Auto-generated method stub
		return cd.addComment(c);
	}

}
