package com.app.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.app.web.dao.ExampaperGroupDao;
import com.app.web.entity.ExampaperGroup;
import com.app.web.service.ExampaperGroupService;

@Service("exampaperGroupService")
public class ExampaperGroupServiceImpl implements ExampaperGroupService {

	@Autowired
	private ExampaperGroupDao exampaperGroupDao;
	
	@Override
	public ExampaperGroup queryObject(Long id){
		return exampaperGroupDao.queryObject(id);
	}
	
	@Override
	public List<ExampaperGroup> queryList(Map<String, Object> map){
		return exampaperGroupDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return exampaperGroupDao.queryTotal(map);
	}
	
	@Override
	public void save(ExampaperGroup exampaperGroup){
		exampaperGroupDao.save(exampaperGroup);
	}
	
	@Override
	public void update(ExampaperGroup exampaperGroup){
		exampaperGroupDao.update(exampaperGroup);
	}
	
	@Override
	public void delete(Long id){
		exampaperGroupDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		exampaperGroupDao.deleteBatch(ids);
	}
	
}
