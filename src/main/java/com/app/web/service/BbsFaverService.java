package com.app.web.service;

import com.app.web.entity.BbsFaver;
import java.util.List;
import java.util.Map;

/**
 * @author liangliang
 * @Description: TODO(评论表点赞记录)
 * @date 2017-12-07 16:05:13
 */
public interface BbsFaverService {
	
	BbsFaver queryObject(Long memberId);
	
	List<BbsFaver> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(BbsFaver BbsFaver);
	
	void update(BbsFaver BbsFaver);
	
	void delete(Long memberId);
	
	void deleteBatch(Long[] memberIds);

}
