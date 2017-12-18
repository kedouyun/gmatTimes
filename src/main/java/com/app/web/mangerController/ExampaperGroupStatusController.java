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
import com.app.web.entity.ExampaperGroupStatus;
import com.app.web.service.ExampaperGroupStatusService;
/**
 * @author liangliang
 * @Description: TODO(模拟考试状态)
 * @date 2017-12-18 15:15:31
 */
@Controller
@RequestMapping("/gm/exampapergroupstatus")
public class ExampaperGroupStatusController extends AbstractController{

	@Autowired
	private ExampaperGroupStatusService exampaperGroupStatusService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list.do")
	public String list(@RequestParam Map<String, Object> params,ModelMap model){
		//查询列表数据
        Query query = new Query(params);

		List<ExampaperGroupStatus> exampaperGroupStatusList = exampaperGroupStatusService.queryList(query);
		int total = exampaperGroupStatusService.queryTotal(query);
		
		PageInfo pageInfo=new PageInfo(query.getPage()+"", query.getLimit()+"");
		pageInfo.setList(exampaperGroupStatusList);
		pageInfo.getPage(total, query.getLimit());
		model.addAttribute("pageInfo", pageInfo);
		
		model.addAttribute("params", params);	
		
		return "/manger/exampaperGroupStatus/list";
	}
	
	
	/**
	 * 修改
	 */
	@RequestMapping("/edit.do")
	public String edit(Long id,ModelMap model){
		ExampaperGroupStatus exampaperGroupStatus = exampaperGroupStatusService.queryObject(id);
		model.addAttribute("exampaperGroupStatus", exampaperGroupStatus);	
		return "/manger/exampaperGroupStatus/edit";
	}
	
	/**
	 * 新增
	 */
	@RequestMapping("/add.do")
	public String add(ModelMap model){
		return "/manger/exampaperGroupStatus/add";
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save.do")
	public String save(@RequestBody ExampaperGroupStatus exampaperGroupStatus){
		exampaperGroupStatusService.save(exampaperGroupStatus);
		
		return seccess;
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update.do")
	public String update( ExampaperGroupStatus exampaperGroupStatus){
		exampaperGroupStatusService.update(exampaperGroupStatus);
		return seccess;
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete.do")
	public Result delete( Long[] id){
		exampaperGroupStatusService.deleteBatch(id);
		
		return Result.ok();
	}
	
}
