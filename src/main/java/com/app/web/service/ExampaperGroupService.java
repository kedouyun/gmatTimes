package com.app.web.service;

import com.app.web.entity.ExampaperGroup;
import java.util.List;
import java.util.Map;

/**
 * @author liangliang
 * @Description: TODO(试卷组)
 * @date 2017-12-03 16:08:46
 */
public interface ExampaperGroupService {
	
	ExampaperGroup queryObject(Long id);
	
	List<ExampaperGroup> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ExampaperGroup exampaperGroup);
	
	void update(ExampaperGroup exampaperGroup);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);

	List<ExampaperGroup> queryWebList(Map<String, Object> params);

}
