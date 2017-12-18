package com.app.web.service;

import com.app.web.entity.GrammarTypes;
import java.util.List;
import java.util.Map;

/**
 * @author liangliang
 * @Description: TODO()
 * @date 2017-11-20 20:49:42
 */
public interface GrammarTypesService {
	
	GrammarTypes queryObject(Long id);
	
	List<GrammarTypes> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(GrammarTypes grammarTypes);
	
	void update(GrammarTypes grammarTypes);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);

	List<GrammarTypes> queryListAll();

	List<GrammarTypes> search();

}
