package com.app.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import com.app.web.dao.CommentDao;
import com.app.web.dao.CommentFaverDao;
import com.app.web.entity.Comment;
import com.app.web.entity.CommentFaver;
import com.app.web.service.CommentFaverService;

@Service("commentFaverService")
public class CommentFaverServiceImpl implements CommentFaverService {

	@Autowired
	private CommentFaverDao commentFaverDao;
	@Autowired
	private CommentDao commentDao;
	
	@Override
	public CommentFaver queryObject(Long memberId){
		return commentFaverDao.queryObject(memberId);
	}
	
	@Override
	public List<CommentFaver> queryList(Map<String, Object> map){
		return commentFaverDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return commentFaverDao.queryTotal(map);
	}
	
	@Transactional
	@Override
	public void save(CommentFaver commentFaver){
		CommentFaver exist =commentFaverDao.queryExist(commentFaver);
		if(exist==null){
			 commentFaverDao.save(commentFaver);
			 
			 Comment queryObject = commentDao.queryObject(commentFaver.getCommentId());
			 queryObject.setFaver(queryObject.getFaver()+1);
			 commentDao.update(queryObject);
		}else{
			 commentFaverDao.delete(commentFaver);
			 Comment queryObject = commentDao.queryObject(commentFaver.getCommentId());
			 queryObject.setFaver(queryObject.getFaver()-1);
			 commentDao.update(queryObject);
		}
	}
	
	@Override
	public void update(CommentFaver commentFaver){
		commentFaverDao.update(commentFaver);
	}
	
	@Override
	public void delete(Long memberId){
		commentFaverDao.delete(memberId);
	}
	
	@Override
	public void deleteBatch(Long[] memberIds){
		commentFaverDao.deleteBatch(memberIds);
	}
	
}
