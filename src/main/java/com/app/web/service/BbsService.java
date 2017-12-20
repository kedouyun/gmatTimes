package com.app.web.service;

import com.app.web.entity.Bbs;
import java.util.List;
import java.util.Map;

/**
 * @author liangliang
 * @Description: TODO(题库评论表)
 * @date 2017-12-07 16:05:14
 */
public interface BbsService {
	
	Bbs queryObject(Long id);
	
	List<Bbs> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(Bbs Bbs);
	
	void update(Bbs Bbs);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);

	List<Bbs> queryWebList(Map<String, Object> map);

	int queryWebTotal(Map<String, Object> map);

}
