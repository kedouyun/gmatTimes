package com.app.sys.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.common.utils.Result;
import com.app.sys.entity.SysDept;
import com.app.sys.service.SysDeptService;

/**
 * @author heguoliang
 * @Description: TODO(部门管理)
 * @date 2017-6-23 15:07
 */
@RestController
@RequestMapping("/sys/dept")
public class SysDeptController extends AbstractController {

	@Autowired
	private SysDeptService sysDeptService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public List<SysDept> list(){
		Map<String, Object> map = new HashMap<>();
		List<SysDept> deptList = sysDeptService.queryList(map);
		return deptList;
	}

	/**
	 * 选择部门(添加、修改菜单)
	 */
	@RequestMapping("/select")
	public Result select(){
		Map<String, Object> map = new HashMap<>();
		List<SysDept> deptList = sysDeptService.queryList(map);

		//添加一级部门
		SysDept root = new SysDept();
		root.setId(0L);
		root.setName("一级部门");
		root.setParentId(-1L);
		root.setOpen(true);
		deptList.add(root);

		return Result.ok().put("deptList", deptList);
	}

	/**
	 * 上级部门Id(管理员则为0)
	 */
	@RequestMapping("/info")
	public Result info(){
		long deptId = 0;
		return Result.ok().put("deptId", deptId);
	}
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{deptId}")
	public Result info(@PathVariable("deptId") Long deptId){
		SysDept dept = sysDeptService.queryObject(deptId);
		return Result.ok().put("dept", dept);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public Result save(@RequestBody SysDept dept){
		sysDeptService.save(dept);
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody SysDept dept){
		sysDeptService.update(dept);
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public Result delete(long deptId){
		//判断是否有子部门
		List<Long> deptList = sysDeptService.queryDetpIdList(deptId);
		if(deptList.size() > 0){
			return Result.error("请先删除子部门");
		}

		sysDeptService.delete(deptId);

		return Result.ok();
	}
	
}
