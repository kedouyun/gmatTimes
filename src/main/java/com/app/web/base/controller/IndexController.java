package com.app.web.base.controller;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONObject;
import com.app.common.utils.RedisUtils;
import com.app.common.utils.Result;
import com.app.web.base.AbstractWebController;
import com.app.web.entity.Activity;
import com.app.web.entity.Article;
import com.app.web.entity.Member;
import com.app.web.entity.SysDictionary;
import com.app.web.service.ActivityService;
import com.app.web.service.ArticleService;
import com.app.web.service.MemberService;
import com.app.web.service.SysDictionaryService;
import com.app.web.service.impl.MailService;
import com.app.web.vo.ValidateData;


/**
 * @author liangliang
 * @Description: TODO()
 * @date 2017-11-17 20:06:36
 */
@Controller
@RequestMapping
public class IndexController extends AbstractWebController{
	
	@Autowired
	MailService mailService;
	
	@Autowired
	private MemberService memberService;
	@Autowired
	private RedisUtils redisUtils;
	
	@Autowired
	private ActivityService activityService;
	
	
	@Autowired
	private SysDictionaryService sysDictionaryService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/index")
	public String index(ModelMap model){
		Activity articleList = activityService.queryWebFirst();
		model.addAttribute("activity", articleList);
		return "/web/index";
	}
	
	@RequestMapping("/activity/{activityId}")
	public String activity(ModelMap model,@PathVariable Long activityId){
		Activity articleList = activityService.queryObject(activityId);
		model.addAttribute("activity", articleList);
		return "/web/activity";
	}
	
	@RequestMapping("/home")
	public String home(){
		return "/web/home";
	}
}
