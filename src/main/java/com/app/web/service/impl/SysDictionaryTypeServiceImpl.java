package com.app.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.app.web.dao.SysDictionaryTypeDao;
import com.app.web.entity.SysDictionaryType;
import com.app.web.service.SysDictionaryTypeService;

@Service("sysDictionaryTypeService")
public class SysDictionaryTypeServiceImpl implements SysDictionaryTypeService {

	@Autowired
	private SysDictionaryTypeDao sysDictionaryTypeDao;
	
	@Override
	public SysDictionaryType queryObject(Integer id){
		return sysDictionaryTypeDao.queryObject(id);
	}
	
	@Override
	public List<SysDictionaryType> queryList(Map<String, Object> map){
		return sysDictionaryTypeDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return sysDictionaryTypeDao.queryTotal(map);
	}
	
	@Override
	public void save(SysDictionaryType sysDictionaryType){
		sysDictionaryTypeDao.save(sysDictionaryType);
	}
	
	@Override
	public void update(SysDictionaryType sysDictionaryType){
		sysDictionaryTypeDao.update(sysDictionaryType);
	}
	
	@Override
	public void delete(Integer id){
		sysDictionaryTypeDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		sysDictionaryTypeDao.deleteBatch(ids);
	}

	@Override
	public List<SysDictionaryType> queryTotalAll() {
		return sysDictionaryTypeDao.queryTotalAll();
	}
	
}
