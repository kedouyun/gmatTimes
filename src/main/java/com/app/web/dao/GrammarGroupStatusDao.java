package com.app.web.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.app.web.entity.GrammarGroupStatus;

@Mapper
public interface GrammarGroupStatusDao extends BaseDao<GrammarGroupStatus> {

	GrammarGroupStatus queryStatus(@Param("grammarGroupId") Long grammarGroupId,@Param("memberId") Long memberId);

	GrammarGroupStatus queryByUserAndKey(@Param("memberId")  Long memberId,@Param("rediskey")  String rediskey);
	
}
