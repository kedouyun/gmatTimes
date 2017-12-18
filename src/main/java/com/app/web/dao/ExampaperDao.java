package com.app.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.app.web.entity.Exampaper;

@Mapper
public interface ExampaperDao extends BaseDao<Exampaper> {

	List<Exampaper> queryListAll();
	
}
