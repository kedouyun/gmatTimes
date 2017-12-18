package com.app.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.app.web.dao.GrammarGroupDao;
import com.app.web.entity.GrammarGroup;
import com.app.web.service.GrammarGroupService;

@Service("grammarGroupService")
public class GrammarGroupServiceImpl implements GrammarGroupService {

	@Autowired
	private GrammarGroupDao grammarGroupDao;
	
	@Override
	public GrammarGroup queryObject(Long id){
		return grammarGroupDao.queryObject(id);
	}
	
	@Override
	public List<GrammarGroup> queryList(Map<String, Object> map){
		return grammarGroupDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return grammarGroupDao.queryTotal(map);
	}
	
	@Override
	public void save(GrammarGroup grammarGroup){
		grammarGroupDao.save(grammarGroup);
	}
	
	@Override
	public void update(GrammarGroup grammarGroup){
		grammarGroupDao.update(grammarGroup);
	}
	
	@Override
	public void delete(Long id){
		grammarGroupDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		grammarGroupDao.deleteBatch(ids);
	}

	@Override
	public List<GrammarGroup> queryByGrammarTypesId(Long grammarTypesId) {
		return grammarGroupDao.queryByGrammarTypesId(grammarTypesId);
	}

	@Override
	public List<GrammarGroup> queryByGrammarTitleId(Long grammarTitleId,Long loginMemberId) {
		return grammarGroupDao.queryByGrammarTitleId(grammarTitleId,loginMemberId);
	}
	
}
