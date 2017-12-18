package com.app.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.app.common.utils.Query;
import com.app.web.entity.Questions;

@Mapper
public interface QuestionsDao extends BaseDao<Questions> {

	List<Questions> queryByGrammarGroupId(Long grammarGroupId);

	List<Long> queryIDsByGrammarGroupId(Long grammarGroupId);

	List<Questions> myqueryList(Query query);

	int myqueryTotal(Query query);
	
}
