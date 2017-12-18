package com.app.web.service;

import com.app.web.entity.GrammarTitle;
import java.util.List;
import java.util.Map;

/**
 * @author liangliang
 * @Description: TODO()
 * @date 2017-11-20 20:49:42
 */
public interface GrammarTitleService {
	
	GrammarTitle queryObject(Long id);
	
	List<GrammarTitle> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(GrammarTitle grammarTitle);
	
	void update(GrammarTitle grammarTitle);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);

	List<GrammarTitle> queryByGrammarTypesId(Long grammarTypesId);

	List<GrammarTitle> search(Long grammarTypesId);

}
