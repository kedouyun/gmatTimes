package com.app.web.service;

import com.app.web.entity.ExampaperQuestions;
import com.app.web.entity.Member;
import com.app.web.vo.ExemConfig;

import java.util.List;
import java.util.Map;

/**
 * @author liangliang
 * @Description: TODO(考试组试题)
 * @date 2017-12-05 10:26:49
 */
public interface ExampaperQuestionsService {
	
	ExampaperQuestions queryObject(Long id);
	
	List<ExampaperQuestions> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ExampaperQuestions exampaperQuestions);
	
	void update(ExampaperQuestions exampaperQuestions);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);

	List<Long> queryIDsByExampaperGroupId(Long exampaperGroupId);
	//提前结束考试 查看结果 保存当前用户状态
	void saveOrUpdateStatus(ExemConfig config, Long exampaperGroupId, Member loginMember, String rediskey);

}
