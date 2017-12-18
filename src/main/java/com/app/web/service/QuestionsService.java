package com.app.web.service;

import com.app.common.utils.Query;
import com.app.web.entity.Member;
import com.app.web.entity.Questions;
import com.app.web.vo.ExemConfig;

import java.util.List;
import java.util.Map;

/**
 * @author liangliang
 * @Description: TODO()
 * @date 2017-11-20 20:49:42
 */
public interface QuestionsService {
	
	Questions queryObject(Long id);
	
	List<Questions> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(Questions questions);
	
	void update(Questions questions);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);

	List<Questions> queryByGrammarGroupId(Long grammarGroupId);

	List<Long> queryIDsByGrammarGroupId(Long grammarGroupId);

	void importQuestTions(String path, Long id, String username);

	List<Questions> myqueryList(Query query);

	int myqueryTotal(Query query);

	void saveOrUpdateStatus(ExemConfig config, Long grammarGroupId, Member member,String rediskey);
}
