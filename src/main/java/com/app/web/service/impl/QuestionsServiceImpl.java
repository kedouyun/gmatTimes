package com.app.web.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.app.common.utils.Query;
import com.app.web.dao.GrammarGroupDao;
import com.app.web.dao.GrammarGroupStatusDao;
import com.app.web.dao.QuestionsDao;
import com.app.web.entity.GrammarGroup;
import com.app.web.entity.GrammarGroupStatus;
import com.app.web.entity.Member;
import com.app.web.entity.QuestionContent;
import com.app.web.entity.Questions;
import com.app.web.manger.utils.ExcelUtil;
import com.app.web.service.QuestionsService;
import com.app.web.vo.ExemConfig;
import com.app.web.vo.ExemVo;

@Service("questionsService")
public class QuestionsServiceImpl implements QuestionsService {

	@Autowired
	private QuestionsDao questionsDao;
	@Autowired
	private GrammarGroupStatusDao grammarGroupStatusDao;
	@Autowired
	private GrammarGroupDao grammarGroupDao;
	
	@Override
	public Questions queryObject(Long id){
		return questionsDao.queryObject(id);
	}
	
	@Override
	public List<Questions> queryList(Map<String, Object> map){
		return questionsDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return questionsDao.queryTotal(map);
	}
	
	@Override
	public void save(Questions questions){
		questionsDao.save(questions);
	}
	
	@Override
	public void update(Questions questions){
		questionsDao.update(questions);
	}
	
	@Override
	public void delete(Long id){
		questionsDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		questionsDao.deleteBatch(ids);
	}

	@Override
	public List<Questions> queryByGrammarGroupId(Long grammarGroupId) {
		return questionsDao.queryByGrammarGroupId(grammarGroupId);
	}

	@Override
	public List<Long> queryIDsByGrammarGroupId(Long grammarGroupId) {
		return questionsDao.queryIDsByGrammarGroupId(grammarGroupId);
	}
	@Transactional
	@Override
	public void importQuestTions(String filePath, Long id, String username) {
	
//		String strPath = ",webapps,files,question," + username;
//		
//		filePath = System.getProperty("catalina.base") + strPath.replace(',', File.separatorChar) + File.separatorChar
//				+ filePath;
//		Map<String, KnowledgePoint> pointMap = this.getKnowledgePointMapByFieldId(fieldId, null);
		int index = 2;
		try {
			List<Map<String, String>> questionMapList = ExcelUtil.ExcelToList(filePath);
			for (Map<String, String> map : questionMapList) {

				System.out.println(map);
				Questions question = new Questions();
				question.setName(map.get("题目").length() > 10 ? map.get("题目").substring(0, 10) + "..." : map.get("题目"));
				if (map.get("类型").equals("单选题") || map.get("类型").equals("单项选择题"))
					question.setQuestionType(1);
				else if (map.get("类型").equals("阅读题") || map.get("类型").equals("阅读理解"))
					question.setQuestionType(2);
//				else if (map.get("类型").equals("判断题"))
//					question.setQuestionType(3);
//				else if (map.get("类型").equals("填空题"))
//					question.setQuestionType(4);
//				else if (map.get("类型").equals("简答题"))
//					question.setQuestionType(5);
//				else if (map.get("类型").equals("论述题"))
//					question.setQuestionType(6);
//				else if (map.get("类型").equals("分析题"))
//					question.setQuestionType(7);

				question.setAnalysis(map.get("解析"));
				question.setAnswer(map.get("答案"));
				if (question.getQuestionType() == 3) {
					if (map.get("答案").equals("对"))
						question.setAnswer("T");
					if (map.get("答案").equals("错"))
						question.setAnswer("F");
				}

//				KnowledgePoint kp = pointMap.get(map.get("知识类"));
//				if(kp == null)
//					throw new Exception("知识类不存在：" + map.get("知识类"));
//				List<Integer> pointList = new ArrayList<Integer>();
//				pointList.add(kp.getPointId());
//				question.setReferenceName(map.get("出处"));
//				question.setExamingPoint(map.get("知识点"));
//				question.setKeyword(map.get("知识关键点"));
//				question.setPoints(map.get("分值").equals("") ? 0 : Float.parseFloat(map.get("分值")));
				QuestionContent qc = new QuestionContent();

				Iterator<String> it = map.keySet().iterator();
				List<String> keyStr = new ArrayList<String>();
				while (it.hasNext()) {
					String key = it.next();
					if (key.contains("选项"))
						keyStr.add(key.replace("选项", ""));
				}

				Collections.sort(keyStr);
				LinkedHashMap<String, String> choiceList = new LinkedHashMap<String, String>();
				for (int i = 0; i < keyStr.size(); i++) {
					if (!map.get("选项" + keyStr.get(i)).trim().equals(""))
						choiceList.put(keyStr.get(i), map.get("选项" + keyStr.get(i)));
				}
				if (question.getQuestionType() == 1 || question.getQuestionType() == 2){
					qc.setChoiceList(choiceList);
				}
				qc.setTitle(map.get("题目"));
				if(question.getQuestionType()==2){
					qc.setReadingQuestion(map.get("阅读理解问题"));
				}
				String content = JSON.toJSONString(qc);
				
				question.setContent(content);
				question.setCreator(username);
				question.setGrammaticalGroupId(id);
				question.setIsVisible(0);
//				question.setPointList(pointList);
				
				questionsDao.save(question);
				index++;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("第" + index + "行有错误，请检查！" + e.getMessage());
		}
	}

	@Override
	public List<Questions> myqueryList(Query query) {
		return questionsDao.myqueryList(query);
	}

	@Override
	public int myqueryTotal(Query query) {
		return questionsDao.myqueryTotal(query);
	}

	@Override
	public void saveOrUpdateStatus(ExemConfig config, Long grammarGroupId, Member member,String rediskey) {
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
			map.put("grammarGroupId", grammarGroupId);
			
			List<GrammarGroupStatus> queryList = grammarGroupStatusDao.queryList(map);
			float f=(float)(progress-wrong)/(float)progress*100F;
			
			
			GrammarGroup t=grammarGroupDao.queryObject(grammarGroupId);//更新该组的平均分
			if(t.getAvgAccuracy()==0){
				t.setAvgAccuracy(f);
			}else{
				t.setAvgAccuracy((t.getAvgAccuracy()+f)/2F);
			}
			
			if(queryList!=null&&queryList.size()>0){
				GrammarGroupStatus grammarGroupStatus=queryList.get(0);
				grammarGroupStatus.setUserId(member.getId());
				grammarGroupStatus.setProgress(progress);
				grammarGroupStatus.setWrong(wrong);
				grammarGroupStatus.setGrammarGroupId(grammarGroupId);
				grammarGroupStatus.setCostTime(overTime);
				grammarGroupStatus.setAccuracy(f);
				grammarGroupStatus.setContentStatus(JSON.toJSONString(config).toString());
				grammarGroupStatus.setCacheKey(rediskey);
				grammarGroupStatusDao.update(grammarGroupStatus);
			}else{
				GrammarGroupStatus grammarGroupStatus=new GrammarGroupStatus();
				grammarGroupStatus.setUserId(member.getId());
				grammarGroupStatus.setProgress(progress);
				grammarGroupStatus.setWrong(wrong);
				grammarGroupStatus.setGrammarGroupId(grammarGroupId);
				grammarGroupStatus.setCostTime(overTime);	
				grammarGroupStatus.setAccuracy(f);
				grammarGroupStatus.setContentStatus(JSON.toJSONString(config).toString());
				grammarGroupStatus.setCacheKey(rediskey);
				grammarGroupStatusDao.save(grammarGroupStatus);
			}
			t.setPersonTimes(t.getPersonTimes()+1);
			grammarGroupDao.update(t);
		}
		
	}
}
