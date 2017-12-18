package com.app.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.app.web.entity.GrammarTypes;

@Mapper
public interface GrammarTypesDao extends BaseDao<GrammarTypes> {

	List<GrammarTypes> queryListAll();

	List<GrammarTypes> search();
	
}
