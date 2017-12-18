package com.app.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.app.web.entity.GrammarTitle;

@Mapper
public interface GrammarTitleDao extends BaseDao<GrammarTitle> {

	List<GrammarTitle> queryByGrammarTypesId(Long grammarTypesId);

	List<GrammarTitle> search(Long grammarTypesId);
	
}
