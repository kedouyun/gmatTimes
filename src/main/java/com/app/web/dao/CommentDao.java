package com.app.web.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.app.web.entity.Comment;

@Mapper
public interface CommentDao extends BaseDao<Comment> {

	int queryWebTotal(Map<String, Object> map);

	List<Comment> queryWebList(Map<String, Object> map);
	
}
