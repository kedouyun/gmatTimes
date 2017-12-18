package com.app.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.app.web.dao.ExampaperDao;
import com.app.web.entity.Exampaper;
import com.app.web.service.ExampaperService;

@Service("exampaperService")
public class ExampaperServiceImpl implements ExampaperService {

	@Autowired
	private ExampaperDao exampaperDao;
	
	@Override
	public Exampaper queryObject(Long id){
		return exampaperDao.queryObject(id);
	}
	
	@Override
	public List<Exampaper> queryList(Map<String, Object> map){
		return exampaperDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return exampaperDao.queryTotal(map);
	}
	
	@Override
	public void save(Exampaper exampaper){
		exampaperDao.save(exampaper);
	}
	
	@Override
	public void update(Exampaper exampaper){
		exampaperDao.update(exampaper);
	}
	
	@Override
	public void delete(Long id){
		exampaperDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		exampaperDao.deleteBatch(ids);
	}

	@Override
	public List<Exampaper> queryListAll() {
		return exampaperDao.queryListAll();
	}
	
}
