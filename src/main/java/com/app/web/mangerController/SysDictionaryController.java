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
import com.app.web.entity.SysDictionary;
import com.app.web.entity.SysDictionaryType;
import com.app.web.service.SysDictionaryService;
import com.app.web.service.SysDictionaryTypeService;
/**
 * @author liangliang
 * @Description: TODO(字典类型)
 * @date 2017-12-08 14:26:23
 */
@Controller
@RequestMapping("/manger/sysDictionary")
public class SysDictionaryController extends AbstractController{

	@Autowired
	private SysDictionaryService sysDictionaryService;
	@Autowired
	private SysDictionaryTypeService sysDictionaryTypeService;
	/**
	 * 列表
	 */
	@RequestMapping("/list.do")
	public String list(@RequestParam Map<String, Object> params,ModelMap model){
		//查询列表数据
        Query query = new Query(params);

		List<SysDictionary> sysDictionaryList = sysDictionaryService.queryList(query);
		int total = sysDictionaryService.queryTotal(query);
		
		PageInfo pageInfo=new PageInfo(query.getPage()+"", query.getLimit()+"");
		pageInfo.setList(sysDictionaryList);
		pageInfo.getPage(total, query.getLimit());
		model.addAttribute("pageInfo", pageInfo);
		
		model.addAttribute("params", params);	
		
		return "/manger/sysDictionary/list";
	}
	
	
	/**
	 * 修改
	 */
	@RequestMapping("/edit.do")
	public String edit(Integer id,ModelMap model){
		SysDictionary sysDictionary = sysDictionaryService.queryObject(id);
		model.addAttribute("sysDictionary", sysDictionary);	
		List<SysDictionaryType> list=sysDictionaryTypeService.queryTotalAll();
		model.addAttribute("typelist", list);
		
		return "/manger/sysDictionary/edit";
	}
	
	/**
	 * 新增
	 */
	@RequestMapping("/add.do")
	public String add(ModelMap model){
		List<SysDictionaryType> list=sysDictionaryTypeService.queryTotalAll();
		model.addAttribute("typelist", list);
		return "/manger/sysDictionary/add";
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save.do")
	public String save(SysDictionary sysDictionary){
		sysDictionaryService.save(sysDictionary);
		
		return seccess;
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update.do")
	public String update( SysDictionary sysDictionary){
		sysDictionaryService.update(sysDictionary);
		return seccess;
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete.do")
	public Result delete( Integer[] id){
		sysDictionaryService.deleteBatch(id);
		
		return Result.ok();
	}
	
}
