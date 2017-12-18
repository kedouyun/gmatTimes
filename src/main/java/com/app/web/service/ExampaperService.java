package com.app.web.service;

import com.app.web.entity.Exampaper;
import java.util.List;
import java.util.Map;

/**
 * @author liangliang
 * @Description: TODO(试卷管理)
 * @date 2017-12-03 14:45:13
 */
public interface ExampaperService {
	
	Exampaper queryObject(Long id);
	
	List<Exampaper> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(Exampaper exampaper);
	
	void update(Exampaper exampaper);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);

	List<Exampaper> queryListAll();

}
