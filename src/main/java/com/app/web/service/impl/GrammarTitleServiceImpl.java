package com.app.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.app.web.dao.GrammarTitleDao;
import com.app.web.entity.GrammarTitle;
import com.app.web.service.GrammarTitleService;

@Service("grammarTitleService")
public class GrammarTitleServiceImpl implements GrammarTitleService {

	@Autowired
	private GrammarTitleDao grammarTitleDao;
	
	@Override
	public GrammarTitle queryObject(Long id){
		return grammarTitleDao.queryObject(id);
	}
	
	@Override
	public List<GrammarTitle> queryList(Map<String, Object> map){
		return grammarTitleDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return grammarTitleDao.queryTotal(map);
	}
	
	@Override
	public void save(GrammarTitle grammarTitle){
		grammarTitleDao.save(grammarTitle);
	}
	
	@Override
	public void update(GrammarTitle grammarTitle){
		grammarTitleDao.update(grammarTitle);
	}
	
	@Override
	public void delete(Long id){
		grammarTitleDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		grammarTitleDao.deleteBatch(ids);
	}

	@Override
	public List<GrammarTitle> queryByGrammarTypesId(Long grammarTypesId) {
		return grammarTitleDao.queryByGrammarTypesId(grammarTypesId);
	}
	@Override
	public List<GrammarTitle> search(Long grammarTypesId) {
		return grammarTitleDao.search(grammarTypesId);
	}
}
