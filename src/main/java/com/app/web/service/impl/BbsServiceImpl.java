package com.app.web.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.dao.BbsDao;
import com.app.web.entity.Bbs;
import com.app.web.service.BbsService;

@Service("bbsService")
public class BbsServiceImpl implements BbsService {

	@Autowired
	private BbsDao bbsDao;
	
	@Override
	public Bbs queryObject(Long id){
		return bbsDao.queryObject(id);
	}
	
	@Override
	public List<Bbs> queryList(Map<String, Object> map){
		return bbsDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return bbsDao.queryTotal(map);
	}
	
	@Override
	public void save(Bbs Bbs){
		bbsDao.save(Bbs);
	}
	
	@Override
	public void update(Bbs Bbs){
		bbsDao.update(Bbs);
	}
	
	@Override
	public void delete(Long id){
		bbsDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		bbsDao.deleteBatch(ids);
	}

	@Override
	public List<Bbs> queryWebList(Map<String, Object> map) {
		return bbsDao.queryWebList(map);
	}

	@Override
	public int queryWebTotal(Map<String, Object> map) {
		return bbsDao.queryWebTotal(map);
	}
	
}
