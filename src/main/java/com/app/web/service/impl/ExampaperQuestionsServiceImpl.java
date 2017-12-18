package com.app.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.app.web.dao.ExampaperGroupDao;
import com.app.web.dao.ExampaperGroupStatusDao;
import com.app.web.dao.ExampaperQuestionsDao;
import com.app.web.entity.ExampaperGroup;
import com.app.web.entity.ExampaperGroupStatus;
import com.app.web.entity.ExampaperQuestions;
import com.app.web.entity.GrammarGroup;
import com.app.web.entity.GrammarGroupStatus;
import com.app.web.entity.Member;
import com.app.web.service.ExampaperQuestionsService;
import com.app.web.vo.ExemConfig;
import com.app.web.vo.ExemVo;

@Service("exampaperQuestionsService")
public class ExampaperQuestionsServiceImpl implements ExampaperQuestionsService {

	@Autowired
	private ExampaperQuestionsDao exampaperQuestionsDao;
	@Autowired
	private ExampaperGroupDao exampaperGroupDao;
	@Autowired
	private ExampaperGroupStatusDao exampaperGroupStatusDao;
	
	@Override
	public ExampaperQuestions queryObject(Long id){
		return exampaperQuestionsDao.queryObject(id);
	}
	
	@Override
	public List<ExampaperQuestions> queryList(Map<String, Object> map){
		return exampaperQuestionsDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return exampaperQuestionsDao.queryTotal(map);
	}
	
	@Override
	public void save(ExampaperQuestions exampaperQuestions){
		exampaperQuestionsDao.save(exampaperQuestions);
	}
	
	@Override
	public void update(ExampaperQuestions exampaperQuestions){
		exampaperQuestionsDao.update(exampaperQuestions);
	}
	
	@Override
	public void delete(Long id){
		exampaperQuestionsDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		exampaperQuestionsDao.deleteBatch(ids);
	}


	@Override
	public List<Long> queryIDsByExampaperGroupId(Long exampaperGroupId) {
		return exampaperQuestionsDao.queryIDsByExampaperGroupId(exampaperGroupId);
	}

	@Override
	public void saveOrUpdateStatus(ExemConfig config, Long exampaperGroupId, Member member, String rediskey) {
		Integer progress =0;
		Integer wrong =0;
		Integer overTime =0;
		
		Map<Long, ExemVo> answer = config.getAnswer();
		
		for (Long questionId : answer.keySet()) {
			progress++;
			if(answer.get(questionId).getStatus()!=null&&!answer.get(questionId).getStatus()){
				wrong++;
			}
			overTime=overTime+answer.get(questionId).getOverTime();
		}
		
		config.setProgress(progress);
		config.setWrong(wrong);
		
		if(overTime<=60){
			config.setSecond(overTime);
		}else{
			config.setMinute(overTime/60);
			config.setSecond(overTime%60);
		}
		
		if(member!=null){//保存用户题组状态
			
			
			Map<String, Object> map=new HashMap<>();
			map.put("userId", member.getId());
			map.put("grammarGroupId", exampaperGroupId);
			
			List<ExampaperGroupStatus> queryList = exampaperGroupStatusDao.queryList(map);
			float f=(float)(progress-wrong)/(float)progress*100F;
			
			
			ExampaperGroup t=exampaperGroupDao.queryObject(exampaperGroupId);//更新该组的平均分
			if(t.getAvgAccuracy()==0){
				t.setAvgAccuracy(f);
			}else{
				t.setAvgAccuracy((t.getAvgAccuracy()+f)/2F);
			}
			
			if(queryList!=null&&queryList.size()>0){
				ExampaperGroupStatus grammarGroupStatus=queryList.get(0);
				grammarGroupStatus.setUserId(member.getId());
				grammarGroupStatus.setProgress(progress);
				grammarGroupStatus.setWrong(wrong);
//				grammarGroupStatus.setExampaperGroupId(exampaperGroupId);
				grammarGroupStatus.setCostTime(overTime);
				grammarGroupStatus.setAccuracy(f);
				grammarGroupStatus.setContentStatus(JSON.toJSONString(config).toString());
				grammarGroupStatus.setKey(rediskey);
				exampaperGroupStatusDao.update(grammarGroupStatus);
			}else{
				ExampaperGroupStatus grammarGroupStatus=new ExampaperGroupStatus();
				grammarGroupStatus.setUserId(member.getId());
				grammarGroupStatus.setProgress(progress);
				grammarGroupStatus.setWrong(wrong);
//				grammarGroupStatus.setGrammarGroupId(grammarGroupId);
				grammarGroupStatus.setCostTime(overTime);	
				grammarGroupStatus.setAccuracy(f);
				grammarGroupStatus.setContentStatus(JSON.toJSONString(config).toString());
				grammarGroupStatus.setKey(rediskey);
				exampaperGroupStatusDao.save(grammarGroupStatus);
			}
			t.setPersonTimes(t.getPersonTimes()+1);
			exampaperGroupDao.update(t);
		}
		exampaperQuestionsDao.queryIDsByExampaperGroupId(exampaperGroupId);
		
	}
	
}
