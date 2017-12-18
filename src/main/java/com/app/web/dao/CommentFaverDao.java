package com.app.web.dao;

import org.apache.ibatis.annotations.Mapper;

import com.app.web.entity.CommentFaver;

@Mapper
public interface CommentFaverDao extends BaseDao<CommentFaver> {

	CommentFaver queryExist(CommentFaver commentFaver);
	
}
