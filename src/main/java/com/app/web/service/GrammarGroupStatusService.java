package com.app.web.service;

import com.app.web.entity.GrammarGroupStatus;
import java.util.List;
import java.util.Map;

/**
 * @author liangliang
 * @Description: TODO()
 * @date 2017-11-20 20:49:43
 */
public interface GrammarGroupStatusService {
	
	GrammarGroupStatus queryObject(Long id);
	
	List<GrammarGroupStatus> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(GrammarGroupStatus grammarGroupStatus);
	
	void update(GrammarGroupStatus grammarGroupStatus);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);

	GrammarGroupStatus queryStatus(Long grammarGroupId, Long memberId);

	GrammarGroupStatus queryByUserAndKey(Long memberId, String rediskey);

}
