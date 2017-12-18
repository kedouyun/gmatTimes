package com.app.sys.controller;

import java.util.HashMap;
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
import com.app.common.validator.ValidatorUtils;
import com.app.sys.entity.SysRole;
import com.app.sys.service.SysRoleMenuService;
import com.app.sys.service.SysRoleService;
import com.app.sys.vo.PageInfo;

/**
 * @author heguoliang
 * @Description: TODO(角色管理)
 * @date 2017-6-23 15:07
 */
@Controller
@RequestMapping("/manger/role")
public class SysRoleController extends AbstractController {

	@Autowired
	private SysRoleService sysRoleService;
	@Autowired
	private SysRoleMenuService sysRoleMenuService;
	
	/**
	 * 角色列表
	 */
	@RequestMapping("/list.do")
	public String list(@RequestParam Map<String, Object> params,ModelMap model){
		//查询列表数据
		Query query = new Query(params);
		List<SysRole> list = sysRoleService.queryList(query);
		int total = sysRoleService.queryTotal(query);
		PageInfo pageInfo=new PageInfo(query.getPage()+"", query.getLimit()+"");
		pageInfo.setList(list);
		pageInfo.getPage(total, query.getLimit());
		model.addAttribute("pageInfo", pageInfo);
		
		model.addAttribute("params", params);
		return "/manger/role/list";
	}
	
	/**
	 * 角色列表
	 */
	@RequestMapping("/select")
	public Result select(){
		Map<String, Object> map = new HashMap<>();
		List<SysRole> list = sysRoleService.queryList(map);
		return Result.ok().put("list", list);
	}
	
	/**
	 * 角色信息
	 */
	@RequestMapping("/edit.do")
	public String info(Long id ,ModelMap model){
		SysRole role = sysRoleService.queryObject(id);
		//查询角色对应的菜单
		List<Long> menuIdList = sysRoleMenuService.queryMenuIdList(id);
		role.setMenuIdList(menuIdList);
		model.addAttribute("role", role);
		return "/manger/role/edit";
	}
	
	@RequestMapping("/add.do")
	public String add(Long roleId){
		
		return "/manger/role/add";
	}
	
	@RequestMapping("/search.do")
	public String search(Long roleId){
		
		return "/manger/role/add";
	}
	
	/**
	 * 保存角色
	 */
	@RequestMapping("/save.do")
	public String save(SysRole role){
		ValidatorUtils.validateEntity(role);
		sysRoleService.save(role);
		return seccess;
	}
	
	/**
	 * 修改角色
	 */
	@RequestMapping("/update.do")
	public String update( SysRole role){
		ValidatorUtils.validateEntity(role);
		sysRoleService.update(role);
		return seccess;
	}
	
	/**
	 * 删除角色
	 */
	@ResponseBody
	@RequestMapping("/delete.do")
	public Result delete(@RequestBody Long[] roleIds){
		sysRoleService.deleteBatch(roleIds);
		return Result.ok();
	}
}
