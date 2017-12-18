package com.app.web.service;

import com.app.web.entity.SysDictionary;
import java.util.List;
import java.util.Map;

/**
 * @author liangliang
 * @Description: TODO(字典类型)
 * @date 2017-12-08 14:26:23
 */
public interface SysDictionaryService {
	
	SysDictionary queryObject(Integer id);
	
	List<SysDictionary> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SysDictionary sysDictionary);
	
	void update(SysDictionary sysDictionary);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);

	List<SysDictionary> queryByTypeId(int i);

}
