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
import com.app.web.entity.Activity;
import com.app.web.entity.SysDictionary;
import com.app.web.service.ActivityService;
import com.app.web.service.SysDictionaryService;
/**
 * @author liangliang
 * @Description: TODO(练习文章)
 * @date 2017-12-08 15:02:44
 */
@Controller()
@RequestMapping("/manger/activity")
public class ActivityController extends AbstractController{

	@Autowired
	private ActivityService activityService;
	@Autowired
	private SysDictionaryService sysDictionaryService;
	/**
	 * 列表
	 */
	@RequestMapping("/list.do")
	public String list(@RequestParam Map<String, Object> params,ModelMap model){
		//查询列表数据
        Query query = new Query(params);

		List<Activity> articleList = activityService.queryList(query);
		int total = activityService.queryTotal(query);
		
		PageInfo pageInfo=new PageInfo(query.getPage()+"", query.getLimit()+"");
		pageInfo.setList(articleList);
		pageInfo.getPage(total, query.getLimit());
		model.addAttribute("pageInfo", pageInfo);
		
		model.addAttribute("params", params);	
		
		return "/manger/activity/list";
	}
	
	
	/**
	 * 修改
	 */
	@RequestMapping("/edit.do")
	public String edit(Long id,ModelMap model){
		Activity article = activityService.queryObject(id);
		model.addAttribute("article", article);	
		
		List<SysDictionary> list=sysDictionaryService.queryByTypeId(2);
		model.addAttribute("typelist", list);
		
		return "/manger/activity/edit";
	}
	
	/**
	 * 新增
	 */
	@RequestMapping("/add.do")
	public String add(ModelMap model){
		List<SysDictionary> list=sysDictionaryService.queryByTypeId(2);
		model.addAttribute("typelist", list);
		return "/manger/activity/add";
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save.do")
	public String save( Activity article){
		activityService.save(article);
		return seccess;
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update.do")
	public String update( Activity article){
		activityService.update(article);
		return seccess;
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete.do")
	public Result delete( Long[] id){
		activityService.deleteBatch(id);
		
		return Result.ok();
	}
	
}
