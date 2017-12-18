package com.app.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.app.web.entity.GrammarGroup;

@Mapper
public interface GrammarGroupDao extends BaseDao<GrammarGroup> {

	List<GrammarGroup> queryByGrammarTypesId(Long grammarTypesId);

	List<GrammarGroup> queryByGrammarTitleId(@Param("grammarTitleId") Long grammarTitleId,@Param("loginMemberId") Long loginMemberId);
	
}
