package com.app.web.dao;

import org.apache.ibatis.annotations.Mapper;

import com.app.web.entity.ExampaperGroupStatus;

@Mapper
public interface ExampaperGroupStatusDao extends BaseDao<ExampaperGroupStatus> {

	ExampaperGroupStatus queryByUserAndKey(Long memberId, String rediskey);
	
}
