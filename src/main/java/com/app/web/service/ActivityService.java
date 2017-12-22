package com.app.web.service;

import com.app.web.entity.Activity;
import java.util.List;
import java.util.Map;

/**
 * @author liangliang
 * @Description: TODO(练习文章)
 * @date 2017-12-08 15:02:44
 */
public interface ActivityService {
	
	Activity queryObject(Long id);
	
	List<Activity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(Activity article);
	
	void update(Activity article);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);

	Activity queryWebFirst();

}
