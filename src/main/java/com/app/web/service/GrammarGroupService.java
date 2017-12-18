package com.app.web.service;

import com.app.web.entity.GrammarGroup;
import java.util.List;
import java.util.Map;

/**
 * @author liangliang
 * @Description: TODO()
 * @date 2017-11-20 20:49:42
 */
public interface GrammarGroupService {
	
	GrammarGroup queryObject(Long id);
	
	List<GrammarGroup> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(GrammarGroup grammarGroup);
	
	void update(GrammarGroup grammarGroup);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);

	List<GrammarGroup> queryByGrammarTypesId(Long grammarTypesId);

	List<GrammarGroup> queryByGrammarTitleId(Long grammarTitleId, Long loginMemberId);

}
