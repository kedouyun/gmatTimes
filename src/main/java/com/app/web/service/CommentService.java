package com.app.web.service;

import com.app.web.entity.Comment;
import java.util.List;
import java.util.Map;

/**
 * @author liangliang
 * @Description: TODO(题库评论表)
 * @date 2017-12-07 16:05:14
 */
public interface CommentService {
	
	Comment queryObject(Long id);
	
	List<Comment> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(Comment comment);
	
	void update(Comment comment);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);

	List<Comment> queryWebList(Map<String, Object> map);

	int queryWebTotal(Map<String, Object> map);

}
