package com.app.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.app.web.entity.ExampaperQuestions;

@Mapper
public interface ExampaperQuestionsDao extends BaseDao<ExampaperQuestions> {
	List<Long> queryIDsByExampaperGroupId(Long exampaperGroupId);
	
}
