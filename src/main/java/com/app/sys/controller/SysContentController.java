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

import com.app.common.Constant;
import com.app.common.exception.SelfException;
import com.app.common.utils.PageUtils;
import com.app.common.utils.Query;
import com.app.common.utils.Result;
import com.app.sys.entity.SysContent;
import com.app.sys.service.SysContentService;
import com.app.sys.service.SysContentTaxonomyService;

/**
 * @author heguoliang
 * @Description: TODO(内容管理)
 * @date 2017-08-29 10:44:09
 */
@RestController
@RequestMapping("/sys/content")
public class SysContentController extends AbstractController{

	@Autowired
	private SysContentService sysContentService;

	@Autowired
	private SysContentTaxonomyService sysContentTaxonomyService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public Result list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SysContent> contentList = sysContentService.queryList(query);
		int total = sysContentService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(contentList, total, query.getLimit(), query.getPage());
		
		return Result.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public Result info(@PathVariable("id") Long id){
		SysContent content = sysContentService.queryObject(id);
		//查询角色对应的菜单
		Integer[] types={Constant.TaxonomyType.CATEGORY.getValue(), Constant.TaxonomyType.FEATURE.getValue()};
		Integer[] tagType={Constant.TaxonomyType.TAG.getValue()};
		List<Long> taxonomyIdList = sysContentTaxonomyService.queryTaxonomyIdList(id, types);
		List<String> tagNames = sysContentTaxonomyService.queryTaxonomyNameList(id, tagType);
		content.setTaxonomyIdList(taxonomyIdList);
		content.setTagNames(tagNames.toArray());
		return Result.ok().put("content", content);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public Result save(@RequestBody SysContent content){
		verifyForm(content);
		sysContentService.save(content);
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody SysContent content){
		verifyForm(content);
		sysContentService.update(content);
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public Result delete(@RequestBody Long[] ids){
		sysContentService.deleteBatch(ids);
		
		return Result.ok();
	}

	private void verifyForm(SysContent content){
		if(StringUtils.isBlank(content.getTitle())){
			throw new SelfException("标题不能为空");
		}
		if(StringUtils.isBlank(content.getSlug())){
			throw new SelfException("别名不能为空");
		}
		if(StringUtils.isBlank(content.getText())){
			throw new SelfException("内容不能为空");
		}
	}
	
}
