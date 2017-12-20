package com.app.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.app.web.dao.MessageDao;
import com.app.web.entity.Comment;
import com.app.web.entity.CommentFaver;
import com.app.web.entity.Message;
import com.app.web.service.MessageService;

@Service("messageService")
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageDao messageDao;
	
	@Override
	public Message queryObject(Long id){
		return messageDao.queryObject(id);
	}
	
	@Override
	public List<Message> queryList(Map<String, Object> map){
		return messageDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return messageDao.queryTotal(map);
	}
	
	@Override
	public void save(Message message){
		messageDao.save(message);
	}
	
	@Override
	public void update(Message message){
		messageDao.update(message);
	}
	
	@Override
	public void delete(Long id){
		messageDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		messageDao.deleteBatch(ids);
	}

	@Override
	public void saveByCommnet(Comment comment) {
		
		Message message=new Message();
		message.setFromMemberId(comment.getMemberId());
		message.setToMemberId(comment.getToMemberId());
		message.setStatus(0);
		message.setForKey(comment.getId());
		message.setForKeyId(comment.getQuestionId());
		message.setType(0);
		message.setIsread(0);
		messageDao.save(message);
		
	}

	@Override
	public void saveByCommentFaver(CommentFaver commentFaver,Comment comment) {
		Message message=new Message();
		message.setFromMemberId(commentFaver.getMemberId());
		message.setToMemberId(comment.getToMemberId());
		message.setStatus(1);
		message.setForKey(comment.getId());
		message.setForKeyId(comment.getQuestionId());
		message.setType(0);
		message.setIsread(0);
		messageDao.save(message);
	}

	@Override
	public void updateReaded(Long memberId) {
		messageDao.updateReaded(memberId);
	}
	
}
