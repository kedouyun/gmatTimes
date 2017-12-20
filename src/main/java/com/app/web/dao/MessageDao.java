package com.app.web.dao;

import org.apache.ibatis.annotations.Mapper;

import com.app.web.entity.Message;

@Mapper
public interface MessageDao extends BaseDao<Message> {

	void updateReaded(Long memberId);
	
}
