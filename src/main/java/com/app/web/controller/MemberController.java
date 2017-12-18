package com.app.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.common.utils.Result;
import com.app.config.login.Login;
import com.app.web.base.AbstractWebController;
import com.app.web.entity.Member;
import com.app.web.service.MemberService;

/**
 * @author liangliang
 * @Description: TODO(前端用户)
 * @date 2017-11-19 21:25:29
 */
@RestController("webMemberController")
@RequestMapping("/user")
public class MemberController extends AbstractWebController{

	@Autowired
	private MemberService memberService;
	
	/**
	 * 信息
	 */
	@RequestMapping("/center")
	@Login
	public String center(){
		return "/web/memberCenter";
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public Result save(@RequestBody Member member){
		memberService.save(member);
		
		return Result.ok();
	}
	
	
}
