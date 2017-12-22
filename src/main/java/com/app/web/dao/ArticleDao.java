package com.app.web.dao;

import org.apache.ibatis.annotations.Mapper;

import com.app.web.entity.Article;

@Mapper
public interface ArticleDao extends BaseDao<Article> {

	
}
