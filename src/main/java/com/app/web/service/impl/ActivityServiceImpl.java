package com.app.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.app.web.dao.ActivityDao;
import com.app.web.entity.Activity;
import com.app.web.service.ActivityService;

@Service
public class ActivityServiceImpl implements ActivityService {

	@Autowired
	private ActivityDao activityDao;
	
	@Override
	public Activity queryObject(Long id){
		return activityDao.queryObject(id);
	}
	
	@Override
	public List<Activity> queryList(Map<String, Object> map){
		return activityDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return activityDao.queryTotal(map);
	}
	
	@Override
	public void save(Activity article){
		activityDao.save(article);
	}
	
	@Override
	public void update(Activity article){
		activityDao.update(article);
	}
	
	@Override
	public void delete(Long id){
		activityDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		activityDao.deleteBatch(ids);
	}

	@Override
	public Activity queryWebFirst() {
		return activityDao.queryWebFirst();
	}
	
}
