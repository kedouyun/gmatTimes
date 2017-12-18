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
import com.app.web.entity.SysDictionaryType;
import com.app.web.service.SysDictionaryTypeService;
/**
 * @author liangliang
 * @Description: TODO(字典描述)
 * @date 2017-12-08 14:26:23
 */
@Controller
@RequestMapping("/manger/sysDictionaryType")
public class SysDictionaryTypeController extends AbstractController{

	@Autowired
	private SysDictionaryTypeService sysDictionaryTypeService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list.do")
	public String list(@RequestParam Map<String, Object> params,ModelMap model){
		//查询列表数据
        Query query = new Query(params);

		List<SysDictionaryType> sysDictionaryTypeList = sysDictionaryTypeService.queryList(query);
		int total = sysDictionaryTypeService.queryTotal(query);
		
		PageInfo pageInfo=new PageInfo(query.getPage()+"", query.getLimit()+"");
		pageInfo.setList(sysDictionaryTypeList);
		pageInfo.getPage(total, query.getLimit());
		model.addAttribute("pageInfo", pageInfo);
		
		model.addAttribute("params", params);	
		
		return "/manger/sysDictionaryType/list";
	}
	
	
	/**
	 * 修改
	 */
	@RequestMapping("/edit.do")
	public String edit(Integer id,ModelMap model){
		SysDictionaryType sysDictionaryType = sysDictionaryTypeService.queryObject(id);
		model.addAttribute("sysDictionaryType", sysDictionaryType);	
		return "/manger/sysDictionaryType/edit";
	}
	
	/**
	 * 新增
	 */
	@RequestMapping("/add.do")
	public String add(ModelMap model){
		return "/manger/sysDictionaryType/add";
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save.do")
	public String save( SysDictionaryType sysDictionaryType){
		sysDictionaryTypeService.save(sysDictionaryType);
		
		return seccess;
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update.do")
	public String update( SysDictionaryType sysDictionaryType){
		sysDictionaryTypeService.update(sysDictionaryType);
		return seccess;
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete.do")
	public Result delete( Integer[] id){
		sysDictionaryTypeService.deleteBatch(id);
		return Result.ok();
	}
	
}
