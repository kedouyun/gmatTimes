package com.app.web.service;

import com.app.web.entity.Comment;
import com.app.web.entity.CommentFaver;
import com.app.web.entity.Message;
import java.util.List;
import java.util.Map;

/**
 * @author liangliang
 * @Description: TODO(消息表)
 * @date 2017-12-20 17:33:10
 */
public interface MessageService {
	
	Message queryObject(Long id);
	
	List<Message> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(Message message);
	
	void update(Message message);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);

	void saveByCommnet(Comment comment);

	void saveByCommentFaver(CommentFaver commentFaver, Comment comment);

	void updateReaded(Long memberId);

}
