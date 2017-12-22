package com.app.web.service;

import com.app.web.entity.Article;
import java.util.List;
import java.util.Map;

/**
 * @author liangliang
 * @Description: TODO(练习文章)
 * @date 2017-12-08 15:02:44
 */
public interface ArticleService {
	
	Article queryObject(Long id);
	
	List<Article> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(Article article);
	
	void update(Article article);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);

	Article queryWebFirst(String code);

}
