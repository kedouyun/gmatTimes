package com.app.web.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.web.dao.BbsDao;
import com.app.web.dao.BbsFaverDao;
import com.app.web.dao.CommentDao;
import com.app.web.entity.Bbs;
import com.app.web.entity.BbsFaver;
import com.app.web.entity.Comment;
import com.app.web.entity.BbsFaver;
import com.app.web.service.BbsFaverService;

@Service("bbsFaverService")
public class BbsFaverServiceImpl implements BbsFaverService {

	@Autowired
	private BbsFaverDao bbsFaverDao;
	@Autowired
	private BbsDao bbsDao;
	
	@Override
	public BbsFaver queryObject(Long memberId){
		return bbsFaverDao.queryObject(memberId);
	}
	
	@Override
	public List<BbsFaver> queryList(Map<String, Object> map){
		return bbsFaverDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return bbsFaverDao.queryTotal(map);
	}
	
	@Transactional
	@Override
	public void save(BbsFaver bbsFaver){
		BbsFaver exist =bbsFaverDao.queryExist(bbsFaver);
		Bbs queryObject = bbsDao.queryObject(bbsFaver.getBbsId());
		if(exist==null){
			 bbsFaverDao.save(bbsFaver);
			 queryObject.setFaver(queryObject.getFaver()+1);
			 bbsDao.update(queryObject);
		}else{
			 bbsFaverDao.delete(bbsFaver);
			 queryObject.setFaver(queryObject.getFaver()-1);
			 bbsDao.update(queryObject);
		}
	}
	
	@Override
	public void update(BbsFaver BbsFaver){
		bbsFaverDao.update(BbsFaver);
	}
	
	@Override
	public void delete(Long memberId){
		bbsFaverDao.delete(memberId);
	}
	
	@Override
	public void deleteBatch(Long[] memberIds){
		bbsFaverDao.deleteBatch(memberIds);
	}
	
}
