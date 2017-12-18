package com.app.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.app.web.dao.CommentDao;
import com.app.web.entity.Comment;
import com.app.web.service.CommentService;

@Service("commentService")
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDao commentDao;
	
	@Override
	public Comment queryObject(Long id){
		return commentDao.queryObject(id);
	}
	
	@Override
	public List<Comment> queryList(Map<String, Object> map){
		return commentDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return commentDao.queryTotal(map);
	}
	
	@Override
	public void save(Comment comment){
		commentDao.save(comment);
	}
	
	@Override
	public void update(Comment comment){
		commentDao.update(comment);
	}
	
	@Override
	public void delete(Long id){
		commentDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		commentDao.deleteBatch(ids);
	}

	@Override
	public List<Comment> queryWebList(Map<String, Object> map) {
		return commentDao.queryWebList(map);
	}

	@Override
	public int queryWebTotal(Map<String, Object> map) {
		return commentDao.queryWebTotal(map);
	}
	
}
