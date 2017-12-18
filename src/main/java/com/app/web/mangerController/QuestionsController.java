package com.app.web.mangerController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.app.common.utils.PageUtils;
import com.app.common.utils.Query;
import com.app.common.utils.Result;
import com.app.sys.controller.AbstractController;
import com.app.sys.vo.PageInfo;
import com.app.web.entity.ExampaperQuestions;
import com.app.web.entity.GrammarGroup;
import com.app.web.entity.GrammarTitle;
import com.app.web.entity.GrammarTypes;
import com.app.web.entity.Questions;
import com.app.web.service.ExampaperQuestionsService;
import com.app.web.service.GrammarGroupService;
import com.app.web.service.GrammarTitleService;
import com.app.web.service.GrammarTypesService;
import com.app.web.service.QuestionsService;

/**
 * @author liangliang
 * @Description: TODO()
 * @date 2017-11-17 20:06:36
 */
@Controller
@RequestMapping("/manger/questions")
public class QuestionsController extends AbstractController{

	@Autowired
	private QuestionsService questionsService;
	@Autowired
	private GrammarTypesService grammarTypesService;
	@Autowired
	private GrammarTitleService grammarTitleService;
	
	@Autowired
	private GrammarGroupService grammarGroupService;
	
	@Autowired
	private ExampaperQuestionsService exampaperQuestionsService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list.do")
	public String list(@RequestParam Map<String, Object> params,ModelMap model){
		//查询列表数据
        Query query = new Query(params);

		List<Questions> questionsList = questionsService.queryList(query);
		int total = questionsService.queryTotal(query);
		
		PageInfo pageInfo=new PageInfo(query.getPage()+"", query.getLimit()+"");
		pageInfo.setList(questionsList);
		pageInfo.getPage(total, query.getLimit());
		model.addAttribute("pageInfo", pageInfo);
		
		model.addAttribute("params", params);	
		
		List<GrammarTypes> grammarTypes = grammarTypesService.search();
		model.addAttribute("grammarTypes", grammarTypes);
		
		if(grammarTypes!=null&&grammarTypes.size()>0&&("".equals(params.get("grammarTypesId")))){
			List<GrammarTitle> grammarTitle = grammarTitleService.search(grammarTypes.get(0).getId());
			model.addAttribute("grammarTitle", grammarTitle);
		}
		if(params.get("grammarTypesId")!=null&&(!"".equals(params.get("grammarTypesId")))){
			List<GrammarTitle> grammarTitle = grammarTitleService.search(Long.parseLong(params.get("grammarTypesId").toString()));
			model.addAttribute("grammarTitle", grammarTitle);
			
			List<GrammarGroup> gammarGroupList = grammarGroupService.queryByGrammarTypesId(Long.parseLong(params.get("grammarTypesId").toString()));
			model.addAttribute("gammarGroupList", gammarGroupList);
		}
		
		
		return "/manger/questions/list";
	}
	
	/**
	 * 我的试卷组合题
	 */
	
	@RequestMapping("/myschoose.do")
	public String myschoose(@RequestParam Map<String, Object> params,ModelMap model){
		//查询列表数据
		Query query = new Query(params);
		
		List<Questions> questionsList = questionsService.myqueryList(query);
		int total = questionsService.myqueryTotal(query);
		
		PageInfo pageInfo=new PageInfo(query.getPage()+"", query.getLimit()+"");
		pageInfo.setList(questionsList);
		pageInfo.getPage(total, query.getLimit());
		model.addAttribute("pageInfo", pageInfo);
		
		model.addAttribute("params", params);	
		
		List<GrammarTypes> grammarTypes = grammarTypesService.search();
		model.addAttribute("grammarTypes", grammarTypes);
		
		if(grammarTypes!=null&&grammarTypes.size()>0&&("".equals(params.get("grammarTypesId")))){
			List<GrammarTitle> grammarTitle = grammarTitleService.search(grammarTypes.get(0).getId());
			model.addAttribute("grammarTitle", grammarTitle);
		}
		if(params.get("grammarTypesId")!=null&&(!"".equals(params.get("grammarTypesId")))){
			List<GrammarTitle> grammarTitle = grammarTitleService.search(Long.parseLong(params.get("grammarTypesId").toString()));
			model.addAttribute("grammarTitle", grammarTitle);
			
			List<GrammarGroup> gammarGroupList = grammarGroupService.queryByGrammarTypesId(Long.parseLong(params.get("grammarTypesId").toString()));
			model.addAttribute("gammarGroupList", gammarGroupList);
		}
		return "/manger/questions/myschoose";		
	}
	
	@RequestMapping("/schoose.do")
	public String schoose(@RequestParam Map<String, Object> params,ModelMap model){
		//查询列表数据
		Query query = new Query(params);
		
		List<Questions> questionsList = questionsService.queryList(query);
		int total = questionsService.queryTotal(query);
		
		PageInfo pageInfo=new PageInfo(query.getPage()+"", query.getLimit()+"");
		pageInfo.setList(questionsList);
		pageInfo.getPage(total, query.getLimit());
		model.addAttribute("pageInfo", pageInfo);
		
		model.addAttribute("params", params);	
		
		List<GrammarTypes> grammarTypes = grammarTypesService.search();
		model.addAttribute("grammarTypes", grammarTypes);
		
		if(grammarTypes!=null&&grammarTypes.size()>0&&("".equals(params.get("grammarTypesId")))){
			List<GrammarTitle> grammarTitle = grammarTitleService.search(grammarTypes.get(0).getId());
			model.addAttribute("grammarTitle", grammarTitle);
		}
		if(params.get("grammarTypesId")!=null&&(!"".equals(params.get("grammarTypesId")))){
			List<GrammarTitle> grammarTitle = grammarTitleService.search(Long.parseLong(params.get("grammarTypesId").toString()));
			model.addAttribute("grammarTitle", grammarTitle);
			
			List<GrammarGroup> gammarGroupList = grammarGroupService.queryByGrammarTypesId(Long.parseLong(params.get("grammarTypesId").toString()));
			model.addAttribute("gammarGroupList", gammarGroupList);
		}
		return "/manger/questions/schoose";		
	}
	
	@RequestMapping("/listUi.do")
	public Result listUi(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<Questions> questionsList = questionsService.queryList(query);
		int total = questionsService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(questionsList, total, query.getLimit(), query.getPage());
		
		return Result.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/edit.do")
	public String info(Long id,ModelMap model){
		Questions questions = questionsService.queryObject(id);
		model.addAttribute("questions", questions);
		return "/manger/questions/edit";
	}
	@RequestMapping("/detail.do")
	public String detail(Long id,ModelMap model){
		Questions questions = questionsService.queryObject(id);
		
		HashMap parse = JSON.parseObject(questions.getContent(), HashMap.class);
		model.addAttribute("parse", parse);
		
		model.addAttribute("questions", questions);
		
		return "/manger/questions/detail";
	}
	/**
	 * 保存
	 */
	@RequestMapping("/save.do")
	public Result save( Questions questions){
		questionsService.save(questions);
		
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update.do")
	public String update(@RequestBody Questions questions){
		questionsService.update(questions);
		
		return seccess;
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete.do")
	public Result delete( Long[] id){
		questionsService.deleteBatch(id);
		return Result.ok();
	}
	
	/**
	 * 保存组合试题
	 */
	@ResponseBody
	@RequestMapping("/schooseSave.do")
	public Result schooseSave(Long[] questionsIds,Long exampaperGroupId){
		for (Long questionsId : questionsIds) {
			Map<String, Object> map=new HashMap<>();
			map.put("questionsId", questionsId);
			map.put("exampaperGroupId", exampaperGroupId);
			
			List<ExampaperQuestions> queryList = exampaperQuestionsService.queryList(map);
			if(queryList.size()==0){
				ExampaperQuestions exampaper=new ExampaperQuestions();
				exampaper.setQuestionsId(questionsId);
				exampaper.setExampaperGroupId(exampaperGroupId);
				exampaperQuestionsService.save(exampaper);
			}
		}
		return Result.ok();
	}
	
}
