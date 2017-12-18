package com.app.web.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.dao.ExampaperGroupStatusDao;
import com.app.web.entity.ExampaperGroupStatus;
import com.app.web.service.ExampaperGroupStatusService;

@Service("exampaperGroupStatusService")
public class ExampaperGroupStatusServiceImpl implements ExampaperGroupStatusService {

	@Autowired
	private ExampaperGroupStatusDao exampaperGroupStatusDao;
	
	@Override
	public ExampaperGroupStatus queryObject(Long id){
		return exampaperGroupStatusDao.queryObject(id);
	}
	
	@Override
	public List<ExampaperGroupStatus> queryList(Map<String, Object> map){
		return exampaperGroupStatusDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return exampaperGroupStatusDao.queryTotal(map);
	}
	
	@Override
	public void save(ExampaperGroupStatus exampaperGroupStatus){
		exampaperGroupStatusDao.save(exampaperGroupStatus);
	}
	
	@Override
	public void update(ExampaperGroupStatus exampaperGroupStatus){
		exampaperGroupStatusDao.update(exampaperGroupStatus);
	}
	
	@Override
	public void delete(Long id){
		exampaperGroupStatusDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		exampaperGroupStatusDao.deleteBatch(ids);
	}

	@Override
	public ExampaperGroupStatus queryByUserAndKey(Long memberId, String rediskey) {
		return exampaperGroupStatusDao.queryByUserAndKey(memberId,rediskey);
	}
	
}
