package com.app.web.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.app.common.utils.RandomUtils;
import com.app.common.utils.RedisUtils;
import com.app.common.utils.Result;
import com.app.web.base.AbstractWebController;
import com.app.web.entity.Exampaper;
import com.app.web.entity.ExampaperGroup;
import com.app.web.entity.ExampaperGroupStatus;
import com.app.web.entity.ExampaperQuestions;
import com.app.web.entity.GrammarGroupStatus;
import com.app.web.entity.Questions;
import com.app.web.service.ExampaperGroupService;
import com.app.web.service.ExampaperGroupStatusService;
import com.app.web.service.ExampaperQuestionsService;
import com.app.web.service.ExampaperService;
import com.app.web.service.QuestionsService;
import com.app.web.vo.ExemConfig;
import com.app.web.vo.ExemVo;

@Controller("webExam")
@RequestMapping("/exam")
public class ExamController extends AbstractWebController{

	@Autowired
	private ExampaperService exampaperService;
	
	@Autowired
	private ExampaperGroupService exampaperGroupService;
	@Autowired
	private ExampaperQuestionsService exampaperQuestionsService;
	@Autowired
	private QuestionsService questionsService;
	@Autowired
	private RedisUtils redisUtils;
	
	@Autowired
	private ExampaperGroupStatusService exampaperGroupStatusService;
	
	
	//模考练习 
	@RequestMapping
	public String list(ModelMap model){
		//查询列表数据
		List<Exampaper> exampaperList = exampaperService.queryListAll();
		model.addAttribute("exampaperList", exampaperList);
		
		if(exampaperList!=null&&exampaperList.size()>0){
			Map<String, Object> params=new HashMap<>();
			params.put("status", 1);//上线条件
			List<ExampaperGroup> queryGroupList = exampaperGroupService.queryList(params);
			model.addAttribute("queryGroupList", queryGroupList);
		}
		return "/web/exam/exam";
	}
	
	@GetMapping("/before/{exampaperGroupId}")
	public String before(ModelMap model,@PathVariable("exampaperGroupId") Long exampaperGroupId){
		//查询列表数据
		ExampaperGroup exampaper= exampaperGroupService.queryObject(exampaperGroupId);
		model.addAttribute("exampaper", exampaper);
		return "/web/exam/before";
	}
	
	@PostMapping("/before/{exampaperGroupId}")
	public String sumbitexam(ModelMap model,@PathVariable("exampaperGroupId") Long exampaperGroupId){
		//查询列表数据
		ExampaperGroup exampaper= exampaperGroupService.queryObject(exampaperGroupId);
		model.addAttribute("exampaper", exampaper);
		
		List<Long> questionIds=exampaperQuestionsService.queryIDsByExampaperGroupId(exampaperGroupId);
		
		String rediskey="g"+RandomUtils.generateIntString(17);
		ExemConfig config=new ExemConfig();
		config.setQuestionIds(questionIds);
		config.setLimitTime(exampaper.getLimitTime()*60);//考试时间限制
		redisUtils.set(rediskey,config);
		return "redirect:/exam/exercise/"+exampaperGroupId+"/"+rediskey;
	}
	//模考请求试题
	@GetMapping("/exercise/{exampaperGroupId}/{rediskey}")
	public String go(ModelMap model,@PathVariable("exampaperGroupId") Long exampaperGroupId,@PathVariable("rediskey") String rediskey){
		ExemConfig config = redisUtils.get(rediskey,ExemConfig.class);
		if(config==null){
			ExampaperGroupStatus exampaperGroupStatus=exampaperGroupStatusService.queryByUserAndKey(getMemberId(),rediskey);
			if(exampaperGroupStatus!=null){
				config=JSON.parseObject(exampaperGroupStatus.getContentStatus(), ExemConfig.class);
			}else{
				List<Long> questionIds=exampaperQuestionsService.queryIDsByExampaperGroupId(exampaperGroupId);
				config=new ExemConfig();
				config.setQuestionIds(questionIds);
			}
		}
		
		ExampaperQuestions exampaperQuestions = chooseNext(config,config.getProgress());
		
		redisUtils.set(rediskey, config);
		
		HashMap<String,Object> parse = JSON.parseObject(exampaperQuestions.getQuestions().getContent(), HashMap.class);
		
		model.addAttribute("questions", exampaperQuestions.getQuestions());
		
		model.addAttribute("rediskey", rediskey);
		model.addAttribute("exampaperGroupId", exampaperGroupId);
		model.addAttribute("quest", parse);
		model.addAttribute("config", config);//当前试题的约束信息和集合状态信息
		model.addAttribute("questionsNum", config.getQuestionIds().size());//共计多少题
		
		model.addAttribute("exampaperQuestions", exampaperQuestions);
		return "/web/exam/examing";
	}
	//提交保存模拟试题
	@PostMapping("/exercise/{exampaperGroupId}/{rediskey}")
	public String goPost(ModelMap model,ExemVo exemVo,@PathVariable("exampaperGroupId") Long exampaperGroupId,@PathVariable("rediskey") String rediskey){
		ExemConfig config = redisUtils.get(rediskey,ExemConfig.class);
		if(config==null){
			ExampaperGroupStatus exampaperGroupStatus=exampaperGroupStatusService.queryByUserAndKey(getMemberId(),rediskey);
			if(exampaperGroupStatus!=null){
				config=JSON.parseObject(exampaperGroupStatus.getContentStatus(), ExemConfig.class);
			}else{
				List<Long> questionIds=exampaperQuestionsService.queryIDsByExampaperGroupId(exampaperGroupId);
				config=new ExemConfig();
				config.setQuestionIds(questionIds);
			}
		}
		
		Map<Long, ExemVo> answer = config.getAnswer();
		ExemVo vo=new ExemVo();
		
		ExampaperQuestions Exampaperquestions = null;
		try {
			Exampaperquestions = exampaperQuestionsService.queryObject(config.getQuestionIds().get(config.getProgress()));
		} catch (Exception e) {
			return "redirect:/exam";
		}
		
		Questions questions=Exampaperquestions.getQuestions();
				
		vo.setAnswer(questions.getAnswer());
		vo.setOverTime(exemVo.getOverTime());
		vo.setUserAnswer(exemVo.getAnswer());
		vo.setScore(questions.getScore());
		
		if(questions.getAnswer().equalsIgnoreCase(exemVo.getAnswer())){
			vo.setStatus(true);
		}else{
			vo.setStatus(false);
		}
				
		answer.put(config.getQuestionIds().get(config.getProgress()), vo);
		config.setAnswer(answer);
		
		config.setProgress(config.getProgress()+1);
		
		if(config.getQuestionIds().size()<=config.getProgress()){
			exampaperQuestionsService.saveOrUpdateStatus(config,exampaperGroupId,getLoginMember(),rediskey);
			redisUtils.set(rediskey, config);
			return "redirect:/exam/exercise/result/"+exampaperGroupId+"/"+rediskey;
		}
		redisUtils.set(rediskey, config);
		return "redirect:/exam/exercise/"+exampaperGroupId+"/"+rediskey;
	}
	
	//请求试题
	@GetMapping("/exercise/result/{exampaperGroupId}/{rediskey}")
	public String result(ModelMap model,@PathVariable("exampaperGroupId") Long exampaperGroupId,@PathVariable("rediskey") String rediskey){
		ExemConfig config = redisUtils.get(rediskey,ExemConfig.class);
		model.addAttribute("config", config);
		model.addAttribute("minute", config.getMinute());
		model.addAttribute("second", config.getSecond());
		model.addAttribute("progress", config.getProgress());
		model.addAttribute("questionTotal", config.getQuestionIds().size());
		model.addAttribute("answerTotal", config.getAnswer().size());
		model.addAttribute("wrongTotal", config.getWrong());
		model.addAttribute("rightTotal", config.getAnswer().size()-config.getWrong());
		model.addAttribute("groupkey", rediskey);
		return "/web/exam/examResult";
	}
	
	private ExampaperQuestions chooseNext(ExemConfig config, Integer arrId) {
		List<Long> exampaperQuestionIds = config.getQuestionIds();
		Long long1=0L;
		try {
			 long1 = exampaperQuestionIds.get(arrId);
		} catch (Exception e) {
			try {
				response.sendRedirect(request.getContextPath()+"/exam");
			} catch (IOException e1) {
			}
		}
		ExampaperQuestions questions = exampaperQuestionsService.queryObject(long1);
		
		if(questions==null){
			// Map<Long, ExemVo> answer = config.getAnswer();
			 chooseNext(config,arrId++);
		 }
		config.setProgress(arrId);
		 return questions;
	}
	
	//请求结束考试
	@PostMapping("/exercise/selfresult/{exampaperGroupId}/{rediskey}")
	public String selfresult(ModelMap model,@PathVariable("exampaperGroupId") Long exampaperGroupId,@PathVariable("rediskey") String rediskey){
		ExemConfig config = redisUtils.get(rediskey,ExemConfig.class);
		
		if(config==null||null==config.getAnswer()||0==config.getAnswer().size()){
			return "redirect:/exam";
		}
		if(config.getQuestionIds().size()>0){
			exampaperQuestionsService.saveOrUpdateStatus(config,exampaperGroupId,getLoginMember(),rediskey);
			redisUtils.set(rediskey, config);
			
			return "redirect:/exam/exercise/result/"+exampaperGroupId+"/"+rediskey;
		}
		return "/web/gmat/exemResult";
	}
		
		
	//查看试题答案解析
	@ResponseBody
	@GetMapping("/exercise/detailQuestion/{rediskey}/{question_id}")
	public Result detailQuestion(@PathVariable("rediskey") String rediskey,@PathVariable("question_id") Long exampaperQuestions_id){
		ExemConfig config = redisUtils.get(rediskey,ExemConfig.class);
		Map<Long, ExemVo> answer = config.getAnswer();
		ExemVo exemVo = answer.get(exampaperQuestions_id);
		if(exemVo==null){
			return  Result.error();
		}
		
		ExampaperQuestions exampaperQuestions = exampaperQuestionsService.queryObject(exampaperQuestions_id);
		
		HashMap parse = JSON.parseObject(exampaperQuestions.getQuestions().getContent(), HashMap.class);
		
		return  Result.ok().put("parse", parse).put("exemVo",exemVo);
	}
}
