package com.app.web.service;

import com.app.web.entity.CommentFaver;
import java.util.List;
import java.util.Map;

/**
 * @author liangliang
 * @Description: TODO(评论表点赞记录)
 * @date 2017-12-07 16:05:13
 */
public interface CommentFaverService {
	
	CommentFaver queryObject(Long memberId);
	
	List<CommentFaver> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(CommentFaver commentFaver);
	
	void update(CommentFaver commentFaver);
	
	void delete(Long memberId);
	
	void deleteBatch(Long[] memberIds);

}
