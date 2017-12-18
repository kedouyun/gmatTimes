package com.app.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.app.web.dao.GrammarTypesDao;
import com.app.web.entity.GrammarTypes;
import com.app.web.service.GrammarTypesService;

@Service("grammarTypesService")
public class GrammarTypesServiceImpl implements GrammarTypesService {

	@Autowired
	private GrammarTypesDao grammarTypesDao;
	
	@Override
	public GrammarTypes queryObject(Long id){
		return grammarTypesDao.queryObject(id);
	}
	
	@Override
	public List<GrammarTypes> queryList(Map<String, Object> map){
		return grammarTypesDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return grammarTypesDao.queryTotal(map);
	}
	
	@Override
	public void save(GrammarTypes grammarTypes){
		grammarTypesDao.save(grammarTypes);
	}
	
	@Override
	public void update(GrammarTypes grammarTypes){
		grammarTypesDao.update(grammarTypes);
	}
	
	@Override
	public void delete(Long id){
		grammarTypesDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		grammarTypesDao.deleteBatch(ids);
	}

	@Override
	public List<GrammarTypes> queryListAll() {
		return grammarTypesDao.queryListAll();
	}

	@Override
	public List<GrammarTypes> search() {
		return grammarTypesDao.search();
	}
	
}
