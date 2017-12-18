package com.app.web.mangerController;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.common.utils.Query;
import com.app.common.utils.Result;
import com.app.sys.controller.AbstractController;
import com.app.sys.vo.PageInfo;
import com.app.web.entity.ExampaperQuestions;
import com.app.web.service.ExampaperQuestionsService;
/**
 * @author liangliang
 * @Description: TODO(考试组试题)
 * @date 2017-12-05 10:26:49
 */
@Controller
@RequestMapping("/manger/exampaperQuestions")
public class ExampaperQuestionsController extends AbstractController{

	@Autowired
	private ExampaperQuestionsService exampaperQuestionsService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list.do")
	public String list(@RequestParam Map<String, Object> params,ModelMap model){
		//查询列表数据
        Query query = new Query(params);

		List<ExampaperQuestions> exampaperQuestionsList = exampaperQuestionsService.queryList(query);
		int total = exampaperQuestionsService.queryTotal(query);
		
		PageInfo pageInfo=new PageInfo(query.getPage()+"", query.getLimit()+"");
		pageInfo.setList(exampaperQuestionsList);
		pageInfo.getPage(total, query.getLimit());
		model.addAttribute("pageInfo", pageInfo);
		
		model.addAttribute("params", params);	
		
		return "/manger/exampaperQuestions/list";
	}
	
	
	/**
	 * 修改
	 */
	@RequestMapping("/edit.do")
	public String edit(Long id,ModelMap model){
		ExampaperQuestions exampaperQuestions = exampaperQuestionsService.queryObject(id);
		model.addAttribute("exampaperQuestions", exampaperQuestions);	
		return "/manger/exampaperQuestions/edit";
	}
	
	/**
	 * 新增
	 */
	@RequestMapping("/add.do")
	public String add(ModelMap model){
		return "/manger/exampaperQuestions/add";
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save.do")
	public String save(@RequestBody ExampaperQuestions exampaperQuestions){
		exampaperQuestionsService.save(exampaperQuestions);
		
		return seccess;
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update.do")
	public String update( ExampaperQuestions exampaperQuestions){
		exampaperQuestionsService.update(exampaperQuestions);
		return seccess;
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete.do")
	public Result delete(Long[] id){
		exampaperQuestionsService.deleteBatch(id);
		
		return Result.ok();
	}
	
}
