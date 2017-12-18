package com.app.sys.controller;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.common.exception.SelfException;
import com.app.common.utils.PageUtils;
import com.app.common.utils.Query;
import com.app.common.utils.Result;
import com.app.sys.entity.SysConfig;
import com.app.sys.service.SysConfigService;

/**
 * @author heguoliang
 * @Description: TODO(系统参数信息)
 * @date 2017-6-23 15:07
 */
@RestController
@RequestMapping("/sys/config")
public class SysConfigController extends AbstractController {
	@Autowired
	private SysConfigService sysConfigService;
	
	/**
	 * 所有参数列表
	 */
	@RequestMapping("/list")
	public Result list(@RequestParam Map<String, Object> params){
		//查询列表数据
		Query query = new Query(params);
		List<SysConfig> configList = sysConfigService.queryList(query);
		int total = sysConfigService.queryTotal(query);
		PageUtils pageUtil = new PageUtils(configList, total, query.getLimit(), query.getPage());
		return Result.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 参数信息
	 */
	@RequestMapping("/info/{id}")
	public Result info(@PathVariable("id") Long id){
		SysConfig config = sysConfigService.queryObject(id);
		return Result.ok().put("config", config);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public Result save(@RequestBody SysConfig config){
		verifyForm(config);
		sysConfigService.save(config);
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody SysConfig config){
		verifyForm(config);
		sysConfigService.update(config);
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public Result delete(@RequestBody Long[] ids){
		sysConfigService.deleteBatch(ids);
		return Result.ok();
	}

	private void verifyForm(SysConfig config){
		if(StringUtils.isBlank(config.getKey())){
			throw new SelfException("参数名不能为空");
		}
		if(StringUtils.isBlank(config.getValue())){
			throw new SelfException("参数值不能为空");
		}

		SysConfig temp=sysConfigService.queryObjectByKey(config.getKey());
		if(config.getId()!=null){
			if(temp!=null && temp.getId().compareTo(config.getId()) != 0){
				throw new SelfException("参数名已经存在");
			}
		}else{
			if(temp!=null){
				throw new SelfException("参数名已经存在");
			}
		}
	}

}
