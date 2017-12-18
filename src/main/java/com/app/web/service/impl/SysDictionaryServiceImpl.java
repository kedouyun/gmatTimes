package com.app.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.app.web.dao.SysDictionaryDao;
import com.app.web.entity.SysDictionary;
import com.app.web.service.SysDictionaryService;

@Service("sysDictionaryService")
public class SysDictionaryServiceImpl implements SysDictionaryService {

	@Autowired
	private SysDictionaryDao sysDictionaryDao;
	
	@Override
	public SysDictionary queryObject(Integer id){
		return sysDictionaryDao.queryObject(id);
	}
	
	@Override
	public List<SysDictionary> queryList(Map<String, Object> map){
		return sysDictionaryDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return sysDictionaryDao.queryTotal(map);
	}
	
	@Override
	public void save(SysDictionary sysDictionary){
		sysDictionaryDao.save(sysDictionary);
	}
	
	@Override
	public void update(SysDictionary sysDictionary){
		sysDictionaryDao.update(sysDictionary);
	}
	
	@Override
	public void delete(Integer id){
		sysDictionaryDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		sysDictionaryDao.deleteBatch(ids);
	}

	@Override
	public List<SysDictionary> queryByTypeId(int i) {
		return sysDictionaryDao.queryByTypeId(i);
	}
	
}
