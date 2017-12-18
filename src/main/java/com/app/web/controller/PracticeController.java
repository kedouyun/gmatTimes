package com.app.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.app.common.utils.RandomUtils;
import com.app.common.utils.RedisUtils;
import com.app.common.utils.Result;
import com.app.web.base.AbstractWebController;
import com.app.web.entity.GrammarGroup;
import com.app.web.entity.GrammarGroupStatus;
import com.app.web.entity.GrammarTitle;
import com.app.web.entity.GrammarTypes;
import com.app.web.entity.Questions;
import com.app.web.service.GrammarGroupService;
import com.app.web.service.GrammarGroupStatusService;
import com.app.web.service.GrammarTitleService;
import com.app.web.service.GrammarTypesService;
import com.app.web.service.MemberService;
import com.app.web.service.QuestionsService;
import com.app.web.vo.ExemConfig;
import com.app.web.vo.ExemVo;

/**
 * @author liangliang
 * @Description: TODO(前端用户)
 * @date 2017-11-19 21:25:29
 */
@Controller("webPracticeController")
@RequestMapping("/gmat")
public class PracticeController extends AbstractWebController{

	@Autowired
	private MemberService memberService;
	@Autowired
	private GrammarGroupService grammarGroupService;
	@Autowired
	private GrammarTitleService grammarTitleService;
	
	@Autowired
	private GrammarTypesService grammarTypesService;
	@Autowired
	private QuestionsService questionsService;
	@Autowired
	private GrammarGroupStatusService grammarGroupStatusService;
	@Autowired
	private RedisUtils redisUtils;
	
	@RequestMapping("/practice/{grammarTypesId}/{grammarTitleId}/{grammarGroupId}")
	public String practice(ModelMap model,@PathVariable("grammarTypesId") Long grammarTypesId,@PathVariable("grammarTypesId") Long grammarTitleId,@PathVariable("grammarGroupId") Long grammarGroupId){
		//对大类的查询
		List<GrammarTypes> grammarTypesList=grammarTypesService.queryListAll();
		model.addAttribute("grammarTypesList", grammarTypesList);
		if(grammarTypesId==null){
			if(grammarTypesList.size()>0)
				grammarTypesId=grammarTypesList.get(0).getId();
		}
		//字段类型
		List<GrammarTitle> grammarTitleList=grammarTitleService.queryByGrammarTypesId(grammarTypesId);
		model.addAttribute("grammarTitleList", grammarTitleList);
		
		if(grammarTitleId==null){
			if(grammarTitleList.size()>0){
				grammarTitleId=grammarTitleList.get(0).getId();
			}
		}
		//
		List<GrammarGroup> grammarGroupList=grammarGroupService.queryByGrammarTitleId(grammarTitleId,getMemberId());
		model.addAttribute("grammarGroupList", grammarGroupList);
		
//		if(grammarGroupId==null){
//			if(grammarGroupList.size()>0){
//				grammarGroupId=grammarGroupList.get(0).getId();
//			}
//		}
//		List<Questions> questionsList=questionsService.queryByGrammarGroupId(grammarGroupId);
//		model.addAttribute("questionsList", questionsList);
//		
		model.addAttribute("typesId", grammarTypesId);
		model.addAttribute("titleId", grammarTitleId);
		model.addAttribute("groupId", grammarGroupId);
		return "/web/gmat/practice";
	}
	
	@RequestMapping("/practice")
	public String practice2(ModelMap model,Long grammarTypesId,Long grammarTitleId,Long grammarGroupId){
		return practice(model, grammarTypesId,grammarTitleId,grammarGroupId);
	}
	
	@RequestMapping("/practice/{grammarTypesId}")
	public String practice3(ModelMap model,@PathVariable("grammarTypesId") Long grammarTypesId,Long grammarTitleId,Long grammarGroupId){
		return practice(model, grammarTypesId,grammarTitleId,grammarGroupId);
	}
	
	
	@RequestMapping("/practice/{grammarTypesId}/{grammarTitleId}")
	public String practice4(ModelMap model,@PathVariable("grammarTypesId") Long grammarTypesId,@PathVariable("grammarTitleId") Long grammarTitleId,Long grammarGroupId){
		return practice(model, grammarTypesId,grammarTitleId,grammarGroupId);
	}
	

	@RequestMapping("/pre/{grammarGroupId}")
	public String pre(ModelMap model,@PathVariable("grammarGroupId")Long grammarGroupId){
		
		GrammarGroup queryObject = grammarGroupService.queryObject(grammarGroupId);
		
		if(getMemberId()!=null){
			GrammarGroupStatus grammarGroupStatus=grammarGroupStatusService.queryStatus(queryObject.getId(),getMemberId());
			model.addAttribute("grammarGroupStatus", grammarGroupStatus);
			if(null!=grammarGroupStatus){
				String secound=grammarGroupStatus.getCostTime()+" s";
				if(grammarGroupStatus.getCostTime()>60){
					secound=(grammarGroupStatus.getCostTime()/60)+" min"+(grammarGroupStatus.getCostTime()%60)+" s";
				}
				model.addAttribute("secound", secound);
			}
		}
		
		model.addAttribute("grammarGroup", queryObject);
		
		HashMap map = new HashMap();
		map.put("grammaticalGroupId", grammarGroupId);
		int queryTotal = questionsService.queryTotal(map);
		model.addAttribute("total", queryTotal);
		
		return "/web/gmat/pre";
	}
	
	@RequestMapping("/pre/practice")
	public String practice(ModelMap model,Long grammarGroupId,@RequestParam(defaultValue="0") String showAnswer){
		List<Long> questionIds=questionsService.queryIDsByGrammarGroupId(grammarGroupId);
		
		session.setAttribute("questionIds", questionIds);
		String rediskey="g"+RandomUtils.generateIntString(17);
		ExemConfig config=new ExemConfig();
		
		if(null!=showAnswer&&showAnswer.equals("1")){//是否显示答案
			config.setShowAnswer("1");
		}
		
		config.setQuestionIds(questionIds);
		redisUtils.set(rediskey,config);
		
		return "redirect:/gmat/pre/practice/"+grammarGroupId+"/"+rediskey+"/0";
	}
	
	@GetMapping("/pre/practice/{grammarGroupId}/{rediskey}/{arrId}")
	public String practiceQuestion(ModelMap model,@PathVariable("grammarGroupId") Long grammarGroupId,@PathVariable("rediskey") String rediskey,@PathVariable("arrId") Integer arrId){
		ExemConfig config = redisUtils.get(rediskey,ExemConfig.class);
		if(config==null){
			//优选查询上次的状态，如果没有
			GrammarGroupStatus grammarGroupStatus=grammarGroupStatusService.queryByUserAndKey(getMemberId(),rediskey);
			if(grammarGroupStatus!=null){
				config=JSON.parseObject(grammarGroupStatus.getContentStatus(), ExemConfig.class);
			}else{
				List<Long> questionIds=questionsService.queryIDsByGrammarGroupId(grammarGroupId);
				config=new ExemConfig();
				config.setQuestionIds(questionIds);
			}
			redisUtils.set(rediskey, config);
		}
//		if(config.getQuestionIds().size()<=arrId){
//			System.out.println(config.getQuestionIds().size());
//		}else{
//			System.out.println(config.getQuestionIds().size());
//		}
		
//		Questions questions = questionsService.queryObject(config.getQuestionIds().get(arrId));
//		if(questions==null){
//			chooseNext(questions,config,arrId);
//		}
		Questions questions = chooseNext(config,arrId);
//		model.addAttribute("nextId", config.getQuestionIds().get(arrId+1)==null?0:config.getQuestionIds().get(arrId+1));
		
		HashMap parse = JSON.parseObject(questions.getContent(), HashMap.class);
		
		model.addAttribute("questions", questions);
		model.addAttribute("questionsNum", config.getQuestionIds().size());//共计多少题
		
		model.addAttribute("rediskey", rediskey);
		model.addAttribute("grammarGroupId", grammarGroupId);
		model.addAttribute("arrId", arrId);//题号
		model.addAttribute("config", config);//进页面的配置信息
		
		model.addAttribute("quest", parse);
		
		return "/web/gmat/exem";
	}
	private Questions chooseNext(ExemConfig config, Integer arrId) {
		List<Long> questionIds = config.getQuestionIds();
		Questions questions = questionsService.queryObject(questionIds.get(arrId));
		 if(questions==null){
			// Map<Long, ExemVo> answer = config.getAnswer();
			 chooseNext(config,arrId++);
		 }
		 return questions;
	}

	//提交试题
	@PostMapping("/pre/practice/{grammarGroupId}/{rediskey}/{arrId}")
	public String practiceQuestionPost(ModelMap model,ExemVo exemVo,@PathVariable("grammarGroupId") Long grammarGroupId,@PathVariable("rediskey") String rediskey,@PathVariable("arrId") Integer arrId){
		ExemConfig config = redisUtils.get(rediskey,ExemConfig.class);
		
		if(config==null){
			//优选查询上次的状态，如果没有
			GrammarGroupStatus grammarGroupStatus=grammarGroupStatusService.queryByUserAndKey(getMemberId(),rediskey);
			if(grammarGroupStatus!=null){
				config=JSON.parseObject(grammarGroupStatus.getContentStatus(), ExemConfig.class);
			}else{
				List<Long> questionIds=questionsService.queryIDsByGrammarGroupId(grammarGroupId);
				config=new ExemConfig();
				config.setQuestionIds(questionIds);//题库id
			}
		}
		
		Map<Long, ExemVo> answer = config.getAnswer();
		ExemVo vo=new ExemVo();
		Questions queryObject = questionsService.queryObject(config.getQuestionIds().get(arrId));
		
		vo.setAnswer(queryObject.getAnswer());
		vo.setOverTime(exemVo.getOverTime());
		vo.setUserAnswer(exemVo.getAnswer());
		if(queryObject.getAnswer().equalsIgnoreCase(exemVo.getAnswer())){
			vo.setStatus(true);
		}else{
			vo.setStatus(false);
		}
				
		answer.put(config.getQuestionIds().get(arrId), vo);
		config.setAnswer(answer);
		
		if(config.getQuestionIds().size()<=(arrId+1)){
			questionsService.saveOrUpdateStatus(config,grammarGroupId,getLoginMember(),rediskey);
			redisUtils.set(rediskey, config);
			return "redirect:/gmat/practice/result/"+grammarGroupId+"/"+rediskey;
		}
		
		redisUtils.set(rediskey, config);
		return "redirect:/gmat/pre/practice/"+grammarGroupId+"/"+rediskey+"/"+(arrId+1);
	}
	//请求结束考试
	@PostMapping("/practice/selfresult/{grammarGroupId}/{rediskey}")
	public String selfresult(ModelMap model,@PathVariable("grammarGroupId") Long grammarGroupId,@PathVariable("rediskey") String rediskey){
		ExemConfig config = redisUtils.get(rediskey,ExemConfig.class);
		
		if(config==null||null==config.getAnswer()||0==config.getAnswer().size()){
			return "redirect:/gmat/practice";
		}
		if(config.getQuestionIds().size()>0){
			questionsService.saveOrUpdateStatus(config,grammarGroupId,getLoginMember(),rediskey);
			redisUtils.set(rediskey, config);
			
			return "redirect:/gmat/practice/result/"+grammarGroupId+"/"+rediskey;
		}
		return "/web/gmat/exemResult";
	}
	
	//请求试题
	@GetMapping("/practice/result/{grammarGroupId}/{rediskey}")
	public String result(ModelMap model,@PathVariable("grammarGroupId") Long grammarGroupId,@PathVariable("rediskey") String rediskey){
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
		
		return "/web/gmat/exemResult";
	}
	
	
	
	//查看试题答案解析
	@ResponseBody
	@GetMapping("/practice/detailQuestion/{rediskey}/{question_id}")
	public Result detailQuestion(@PathVariable("rediskey") String rediskey,@PathVariable("question_id") Long question_id){
		ExemConfig config = redisUtils.get(rediskey,ExemConfig.class);
		Map<Long, ExemVo> answer = config.getAnswer();
		ExemVo exemVo = answer.get(question_id);
		if(exemVo==null){
			return  Result.error();
		}
		Questions questions = questionsService.queryObject(question_id);
		
		HashMap parse = JSON.parseObject(questions.getContent(), HashMap.class);
		
		return  Result.ok().put("parse", parse).put("exemVo",exemVo);
	}
//	@RequestMapping("/pre/practice/{questionId}")
//	public String practiceQuestion1(ModelMap model,@PathVariable("questionId") Long questionId){
//		
//		
//		Questions questions = questionsService.queryObject(questionId);
//		
	
	
	
//		Long[] questionIds=null;
//		
//		if(null==session.getAttribute("questionIds")){
//			questionIds=questionsService.queryIDsByGrammarGroupId(questions.getGrammaticalGroupId());
//			
//			session.setAttribute("questionIds", questionIds);
//		}else{
//			questionIds=(Long[]) session.getAttribute("questionIds");
//		}
//		
//		for (int i=0;i<questionIds.length; i++) {
//			System.out.println(questionIds[i]+"===="+questionId);
//			if(questionIds[i].equals(questionId)){
//				questionId=questionIds[i];
//				if((i+1)<questionIds.length){
//					questionId=questionIds[i+1];
//				}else{
//					questionId=null;
//				}
//			}
//		}
//		model.addAttribute("questionId", questionId);
//		
//		HashMap parse = JSON.parseObject(questions.getContent(), HashMap.class);
//		
//		model.addAttribute("questions", questions);
//		
//		model.addAttribute("quest", parse);
//		
//		return "/web/gmat/exem";
//	}
}
