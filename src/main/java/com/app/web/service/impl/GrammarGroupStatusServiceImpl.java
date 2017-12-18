package com.app.web.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.dao.GrammarGroupStatusDao;
import com.app.web.entity.GrammarGroupStatus;
import com.app.web.service.GrammarGroupStatusService;

@Service("grammarGroupStatusService")
public class GrammarGroupStatusServiceImpl implements GrammarGroupStatusService {

	@Autowired
	private GrammarGroupStatusDao grammarGroupStatusDao;
	
	@Override
	public GrammarGroupStatus queryObject(Long id){
		return grammarGroupStatusDao.queryObject(id);
	}
	
	@Override
	public List<GrammarGroupStatus> queryList(Map<String, Object> map){
		return grammarGroupStatusDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return grammarGroupStatusDao.queryTotal(map);
	}
	
	@Override
	public void save(GrammarGroupStatus grammarGroupStatus){
		grammarGroupStatusDao.save(grammarGroupStatus);
	}
	
	@Override
	public void update(GrammarGroupStatus grammarGroupStatus){
		grammarGroupStatusDao.update(grammarGroupStatus);
	}
	
	@Override
	public void delete(Long id){
		grammarGroupStatusDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		grammarGroupStatusDao.deleteBatch(ids);
	}

	@Override
	public GrammarGroupStatus queryStatus(Long grammarGroupId, Long memberId) {
		return grammarGroupStatusDao.queryStatus(grammarGroupId,memberId);
	}

	@Override
	public GrammarGroupStatus queryByUserAndKey(Long memberId, String rediskey) {
		
		return grammarGroupStatusDao.queryByUserAndKey(memberId,rediskey);
	}

//	@Override
//	public void saveOrUpdate(Map<String, Object> map, ExemConfig config, Long userId, Long grammarGroupId) {
//		List<GrammarGroupStatus> queryList = grammarGroupStatusDao.queryList(map);
//		if(queryList!=null&&queryList.size()>0){
//			GrammarGroupStatus grammarGroupStatus=queryList.get(0);
//			grammarGroupStatus.setUserId(userId);
//			grammarGroupStatus.setProgress(config.getProgress());
//			grammarGroupStatus.setWrong(config.getWrong());
//			grammarGroupStatus.setGrammarGroupId(grammarGroupId);
//			grammarGroupStatus.setCostTime(config.get);	
////			grammarGroupStatus.setAccuracy(accuracy);
//			grammarGroupStatusService.update(grammarGroupStatus);
//		}else{
//			GrammarGroupStatus grammarGroupStatus=new GrammarGroupStatus();
//			grammarGroupStatus.setUserId(userId);
//			grammarGroupStatus.setProgress(progress);
//			grammarGroupStatus.setWrong(wrong);
//			grammarGroupStatus.setGrammarGroupId(grammarGroupId);
//			grammarGroupStatus.setCostTime(overTime);	
////			grammarGroupStatus.setAccuracy(accuracy);
//			grammarGroupStatusService.save(grammarGroupStatus);
//		}
//		
//	}
	
}
