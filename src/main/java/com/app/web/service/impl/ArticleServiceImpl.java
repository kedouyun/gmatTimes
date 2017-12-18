package com.app.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.app.web.dao.ArticleDao;
import com.app.web.entity.Article;
import com.app.web.service.ArticleService;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleDao articleDao;
	
	@Override
	public Article queryObject(Long id){
		return articleDao.queryObject(id);
	}
	
	@Override
	public List<Article> queryList(Map<String, Object> map){
		return articleDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return articleDao.queryTotal(map);
	}
	
	@Override
	public void save(Article article){
		articleDao.save(article);
	}
	
	@Override
	public void update(Article article){
		articleDao.update(article);
	}
	
	@Override
	public void delete(Long id){
		articleDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		articleDao.deleteBatch(ids);
	}
	
}
