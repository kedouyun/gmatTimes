package com.app.web.mangerController;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.common.utils.Query;
import com.app.common.utils.Result;
import com.app.sys.controller.AbstractController;
import com.app.sys.vo.PageInfo;
import com.app.web.entity.GrammarTitle;
import com.app.web.entity.GrammarTypes;
import com.app.web.service.GrammarTitleService;
import com.app.web.service.GrammarTypesService;

/**
 * @author liangliang
 * @Description: TODO()
 * @date 2017-11-17 20:06:36
 */
@Controller
@RequestMapping("/manger/grammartitle")
public class GrammarTitleController extends AbstractController{

	@Autowired
	private GrammarTitleService grammarTitleService;
	@Autowired
	private GrammarTypesService grammarTypesService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list.do")
	public String list(@RequestParam Map<String, Object> params,ModelMap model){
		//查询列表数据
        Query query = new Query(params);

		List<GrammarTitle> grammarTitleList = grammarTitleService.queryList(query);
		int total = grammarTitleService.queryTotal(query);
		
		PageInfo pageInfo=new PageInfo(query.getPage()+"", query.getLimit()+"");
		pageInfo.setList(grammarTitleList);
		pageInfo.getPage(total, query.getLimit());
		model.addAttribute("pageInfo", pageInfo);
		
		model.addAttribute("params", params);
		
		return "/manger/grammartitle/list";
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/edit.do")
	public String edit(Long id,ModelMap model){
		GrammarTitle grammarTitle = grammarTitleService.queryObject(id);
		model.addAttribute("grammarTitle", grammarTitle);
		
		List<GrammarTypes> grammarTypes = grammarTypesService.search();
		model.addAttribute("grammarTypes", grammarTypes);
		
		return "/manger/grammartitle/edit";
	}
	
	@RequestMapping("/add.do")
	public String add(ModelMap model){
		List<GrammarTypes> grammarTypes = grammarTypesService.search();
		model.addAttribute("grammarTypes", grammarTypes);
		 return "/manger/grammartitle/add";
	}
	/**
	 * 保存
	 */
	@RequestMapping("/save.do")
	public String save( GrammarTitle grammarTitle){
		grammarTitleService.save(grammarTitle);
		return seccess;
	}
	@ResponseBody
	@RequestMapping("/search/{grammarTypesId}.do")
	public Result search(@PathVariable("grammarTypesId") Long grammarTypesId){
		List<GrammarTitle> grammarTitles = grammarTitleService.search(grammarTypesId);
		return Result.ok().put("grammarTitles", grammarTitles);
	}
	
	
	/**
	 * 修改
	 */
	@RequestMapping("/update.do")
	public String update( GrammarTitle grammarTitle){
		grammarTitleService.update(grammarTitle);
		
		return seccess;
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public Result delete( Long[] id){
		grammarTitleService.deleteBatch(id);
		return Result.ok();
	}
	
}
