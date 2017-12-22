package com.app.web.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.app.web.entity.ExampaperGroup;

@Mapper
public interface ExampaperGroupDao extends BaseDao<ExampaperGroup> {

	List<ExampaperGroup> queryWebList(Map<String, Object> params);
	
}
