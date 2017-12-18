package com.app.web.controller;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.common.utils.Query;
import com.app.sys.vo.PageInfo;
import com.app.web.base.AbstractWebController;
import com.app.web.entity.Article;
import com.app.web.entity.SysDictionary;
import com.app.web.service.ArticleService;
import com.app.web.service.SysDictionaryService;
/**
 * 学习文章介绍
 * @author Administrator
 *
 */
@Controller("webLearnResult")
@RequestMapping("/learn")
public class LearnController extends AbstractWebController{
	@Autowired
	private ArticleService articleService;
	@Autowired
	private SysDictionaryService sysDictionaryService;
	
	@RequestMapping("/{type}/all")
	public String list(@RequestParam Map<String, Object> params,@PathVariable("type") String type,ModelMap model){
		//查询列表数据
		List<SysDictionary> list=sysDictionaryService.queryByTypeId(2);
		model.addAttribute("typelist", list);//文章类型
		
		Query query = new Query(params);
		query.put("status", 1);//上线条件
		if(StringUtils.isNoneBlank(type)){
			query.put("type", type);
		}else{
			if(list!=null&&list.size()>0){
				query.put("type", list.get(0).getCode());
			}else{
				query.put("type", "guide");
			}
		}
		List<Article> articleList = articleService.queryList(query);
		int total = articleService.queryTotal(query);
		
		PageInfo pageInfo=new PageInfo(query.getPage()+"", query.getLimit()+"");
		pageInfo.setList(articleList);
		pageInfo.getPage(total, query.getLimit());
		model.addAttribute("pageInfo", pageInfo);
		
		model.addAttribute("params", params);	
		
		model.addAttribute("path", "xx");	
		
		return "/web/learn/all";
	}
	@RequestMapping("/detail/{id}")
	public String detail(@PathVariable("id") Long id,ModelMap model){
		
		Article article = articleService.queryObject(id);
		article.setTimes(article.getTimes()+1);
		articleService.update(article);
		model.addAttribute("article", article);
		
		return "/web/learn/detail";
	}
	
}
