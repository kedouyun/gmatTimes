package com.app.web.service;

import com.app.web.entity.SysDictionaryType;
import java.util.List;
import java.util.Map;

/**
 * @author liangliang
 * @Description: TODO(字典描述)
 * @date 2017-12-08 14:26:23
 */
public interface SysDictionaryTypeService {
	
	SysDictionaryType queryObject(Integer id);
	
	List<SysDictionaryType> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SysDictionaryType sysDictionaryType);
	
	void update(SysDictionaryType sysDictionaryType);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);

	List<SysDictionaryType> queryTotalAll();

}
