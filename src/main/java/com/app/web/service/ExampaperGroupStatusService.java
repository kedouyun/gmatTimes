package com.app.web.service;

import java.util.List;
import java.util.Map;

import com.app.web.entity.ExampaperGroupStatus;

/**
 * @author liangliang
 * @Description: TODO(模拟考试状态)
 * @date 2017-12-18 15:15:31
 */
public interface ExampaperGroupStatusService {
	
	ExampaperGroupStatus queryObject(Long id);
	
	List<ExampaperGroupStatus> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ExampaperGroupStatus exampaperGroupStatus);
	
	void update(ExampaperGroupStatus exampaperGroupStatus);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
	
	ExampaperGroupStatus queryByUserAndKey(Long memberId, String rediskey);

}
