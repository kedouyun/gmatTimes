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
import com.app.web.entity.Exampaper;
import com.app.web.entity.ExampaperGroup;
import com.app.web.service.ExampaperGroupService;
import com.app.web.service.ExampaperService;
/**
 * @author liangliang
 * @Description: TODO(试卷组)
 * @date 2017-12-03 16:08:46
 */
@Controller
@RequestMapping("/manger/exampaperGroup")
public class ExampaperGroupController extends AbstractController{

	@Autowired
	private ExampaperGroupService exampaperGroupService;
	
	@Autowired
	private ExampaperService exampaperService;
	/**
	 * 列表
	 */
	@RequestMapping("/list.do")
	public String list(@RequestParam Map<String, Object> params,ModelMap model){
		//查询列表数据
        Query query = new Query(params);

		List<ExampaperGroup> exampaperGroupList = exampaperGroupService.queryList(query);
		int total = exampaperGroupService.queryTotal(query);
		
		PageInfo pageInfo=new PageInfo(query.getPage()+"", query.getLimit()+"");
		pageInfo.setList(exampaperGroupList);
		pageInfo.getPage(total, query.getLimit());
		model.addAttribute("pageInfo", pageInfo);
		
		model.addAttribute("params", params);	
		
		return "/manger/exampaperGroup/list";
	}
	
	
	/**
	 * 修改
	 */
	@RequestMapping("/edit.do")
	public String edit(Long id,ModelMap model){
		ExampaperGroup exampaperGroup = exampaperGroupService.queryObject(id);
		model.addAttribute("exampaperGroup", exampaperGroup);	
		
		List<Exampaper>	exampaperList=exampaperService.queryListAll();
		model.addAttribute("exampaperList", exampaperList);
		
		
		return "/manger/exampaperGroup/edit";
	}
	
	/**
	 * 新增
	 */
	@RequestMapping("/add.do")
	public String add(ModelMap model){
		
		List<Exampaper>	exampaperList=exampaperService.queryListAll();
		model.addAttribute("exampaperList", exampaperList);
		return "/manger/exampaperGroup/add";
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save.do")
	public String save( ExampaperGroup exampaperGroup){
		exampaperGroupService.save(exampaperGroup);
		
		return seccess;
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public String update( ExampaperGroup exampaperGroup){
		exampaperGroupService.update(exampaperGroup);
		return seccess;
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public Result delete(Long[] id){
		exampaperGroupService.deleteBatch(id);
		
		return Result.ok();
	}
	
}
