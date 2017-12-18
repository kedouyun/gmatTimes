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
import com.app.web.service.ExampaperService;
/**
 * @author liangliang
 * @Description: TODO(试卷管理)
 * @date 2017-12-03 14:45:13
 */
@Controller
@RequestMapping("/manger/exampaper")
public class ExampaperController extends AbstractController{

	@Autowired
	private ExampaperService exampaperService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list.do")
	public String list(@RequestParam Map<String, Object> params,ModelMap model){
		//查询列表数据
        Query query = new Query(params);

		List<Exampaper> exampaperList = exampaperService.queryList(query);
		int total = exampaperService.queryTotal(query);
		
		PageInfo pageInfo=new PageInfo(query.getPage()+"", query.getLimit()+"");
		pageInfo.setList(exampaperList);
		pageInfo.getPage(total, query.getLimit());
		model.addAttribute("pageInfo", pageInfo);
		
		model.addAttribute("params", params);
		
		return "/manger/exampaper/list";
	}
	
	
	/**
	 * 修改
	 */
	@RequestMapping("/edit.do")
	public String edit(Long id,ModelMap model){
		Exampaper exampaper = exampaperService.queryObject(id);
		model.addAttribute("exampaper", exampaper);
		return "/manger/exampaper/edit";
	}
	
	/**
	 * 新增
	 */
	@RequestMapping("/add.do")
	public String add(ModelMap model){
		return "/manger/exampaper/add";
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save.do")
	public String save(Exampaper exampaper){
		exampaperService.save(exampaper);
		return seccess;
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public String update( Exampaper exampaper){
		exampaperService.update(exampaper);
		return seccess;
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public Result delete( Long[] id){
		exampaperService.deleteBatch(id);
		
		return Result.ok();
	}
	
}
