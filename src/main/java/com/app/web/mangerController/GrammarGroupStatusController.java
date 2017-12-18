package com.app.web.mangerController;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.common.utils.PageUtils;
import com.app.common.utils.Query;
import com.app.common.utils.Result;
import com.app.sys.controller.AbstractController;
import com.app.web.entity.GrammarGroupStatus;
import com.app.web.service.GrammarGroupStatusService;

/**
 * @author liangliang
 * @Description: TODO()
 * @date 2017-11-17 20:06:36
 */
@RestController
@RequestMapping("/manger/grammargroupstatus")
public class GrammarGroupStatusController extends AbstractController{

	@Autowired
	private GrammarGroupStatusService grammarGroupStatusService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public Result list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<GrammarGroupStatus> grammarGroupStatusList = grammarGroupStatusService.queryList(query);
		int total = grammarGroupStatusService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(grammarGroupStatusList, total, query.getLimit(), query.getPage());
		
		return Result.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("gm:grammarGroupStatus:info")
	public Result info(@PathVariable("id") Long id){
		GrammarGroupStatus grammarGroupStatus = grammarGroupStatusService.queryObject(id);
		
		return Result.ok().put("grammarGroupStatus", grammarGroupStatus);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("gm:grammarGroupStatus:save")
	public Result save(@RequestBody GrammarGroupStatus grammarGroupStatus){
		grammarGroupStatusService.save(grammarGroupStatus);
		
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("gm:grammarGroupStatus:update")
	public Result update(@RequestBody GrammarGroupStatus grammarGroupStatus){
		grammarGroupStatusService.update(grammarGroupStatus);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("gm:grammarGroupStatus:delete")
	public Result delete(@RequestBody Long[] ids){
		grammarGroupStatusService.deleteBatch(ids);
		
		return Result.ok();
	}
	
}
