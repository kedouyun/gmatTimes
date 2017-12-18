package com.app.web.mangerController;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.common.utils.PageUtils;
import com.app.common.utils.Query;
import com.app.common.utils.Result;
import com.app.sys.controller.AbstractController;
import com.app.sys.vo.PageInfo;
import com.app.web.entity.GrammarTypes;
import com.app.web.service.GrammarTypesService;

/**
 * @author liangliang
 * @Description: TODO()
 * @date 2017-11-17 19:49:20
 */
@Controller
@RequestMapping("/manger/grammartypes")
public class GrammarTypesController extends AbstractController{

	@Autowired
	private GrammarTypesService grammarTypesService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list.do")
	public String list(@RequestParam Map<String, Object> params,ModelMap model){
		//查询列表数据
        Query query = new Query(params);

		List<GrammarTypes> grammarTypesList = grammarTypesService.queryList(query);
		int total = grammarTypesService.queryTotal(query);
		
		PageInfo pageInfo=new PageInfo(query.getPage()+"", query.getLimit()+"");
		pageInfo.setList(grammarTypesList);
		pageInfo.getPage(total, query.getLimit());
		model.addAttribute("pageInfo", pageInfo);
		
		model.addAttribute("params", params);
		return "/manger/grammarTypes/list";
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/edit.do")
	public String info(Long id,ModelMap model){
		GrammarTypes grammarTypes = grammarTypesService.queryObject(id);
		model.addAttribute("grammarTypes", grammarTypes);
		return "/manger/grammarTypes/edit";
	}
	
	@RequestMapping("/add.do")
	public String add(ModelMap model){
		return "/manger/grammarTypes/add";
	}
	
	@RequestMapping("/search")
	public Result search(){
		List<GrammarTypes> grammarTypes = grammarTypesService.search();
		return Result.ok().put("grammarTypes", grammarTypes); 
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save.do")
	public String save( GrammarTypes grammarTypes){
		grammarTypesService.save(grammarTypes);
		return seccess;
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update.do")
	public String update( GrammarTypes grammarTypes){
		grammarTypesService.update(grammarTypes);
		
		return seccess;
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete.do")
	public Result delete(Long[] id){
		grammarTypesService.deleteBatch(id);
		return Result.ok();
	}
	
}
