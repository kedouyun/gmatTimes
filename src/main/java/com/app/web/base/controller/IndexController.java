package com.app.web.base.controller;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONObject;
import com.app.common.utils.RedisUtils;
import com.app.common.utils.Result;
import com.app.web.base.AbstractWebController;
import com.app.web.entity.Member;
import com.app.web.service.MemberService;
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
	/**
	 * 列表
	 */
	@RequestMapping("/index")
	public String index(){
		return "/web/index";
	}
}
