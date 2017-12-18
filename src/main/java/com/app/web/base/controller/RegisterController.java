package com.app.web.base.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.UUID;

import javax.servlet.http.Cookie;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.app.common.utils.RedisUtils;
import com.app.common.utils.Result;
import com.app.common.utils.VerifyCodeUtils;
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
public class RegisterController extends AbstractWebController{
	
	@Autowired
	MailService mailService;
	
	@Autowired
	private MemberService memberService;
	@Autowired
	private RedisUtils redisUtils;
	
	@RequestMapping("/user/register")
	public String register(ModelMap model,String error){
		model.addAttribute("flag", "register");
		model.addAttribute("error", error);
		return "/web/member/register";
	}
	
	@PostMapping("/user/registerAction")
	public String registerAction(Member member,@RequestParam(required=true) String code,ModelMap model){
		String verCode=(String) session.getAttribute("verCode");
		if(code==null||!code.equalsIgnoreCase(verCode)){
			return "redirect:/user/register?error=-101";
		}
		if(StringUtils.isNotBlank(member.getEmail())){
					this.sendValidateEmail(member);
		}
		return "/web/regestEmail";
	}
	
	@Async
	private void sendValidateEmail(Member member){
	String token = UUID.randomUUID().toString();
	redisUtils.set(token, member);
	logger.error("用户注册，准备发送邮件：User:" + JSONObject.toJSONString(member) + ", Token: " + token);
		mailService.userValidate(member, token);
	}
	
	@RequestMapping("/activation/{token}")
	public String loginAction(@PathVariable("token")  String token,ModelMap model){
		Member member = redisUtils.get(token,Member.class);
		if(member!=null){
			model.addAttribute("member", member);
			return "/web/member/signup";
		}
		return "redirect:/user/register";
	}
	
	@RequestMapping("/activation/register")
	public String register(@RequestParam(required=true) String email,@RequestParam(required=true) String name,@RequestParam(required=true) String password, ModelMap model){
		
		Member member = new Member();
		member.setName(name);
		member.setPassword(password);
		member.setEmail(email);
		member.setStatus(0);
		memberService.save(member);
		System.out.println(JSON.toJSONString(member));
		Cookie cookie;
		try {
			cookie = new Cookie("member",URLEncoder.encode( JSON.toJSONString(member),"utf-8"));
			cookie.setPath("/");
			cookie.setMaxAge(60*60*24);
			response.addCookie(cookie);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	
		return "redirect:/index";
	}
	
	@ResponseBody
	@RequestMapping("/user/ajaxvalidateform")
	public Result ajaxvalidateform(ValidateData validateData){
		
		if(org.apache.commons.lang.StringUtils.isBlank(validateData.getFlag())){
			return Result.error("数据有误");
		}
		
		Member member=null;
		if(validateData.getFlag().equals("email")){
			 member=memberService.queryByEmail(validateData.getContent());
		}else if(validateData.getFlag().equals("mobile")){
			 member=memberService.queryByMobile(validateData.getContent());
		}
		if(member==null){
			return Result.ok();
		}else{
			return Result.error(101,validateData.getFlag());
		}
	}
	/**
	 * 获取验证码
	 * @param request
	 * @throws Exception 
	 */
	@RequestMapping(value ="/get_registerCheckNum")
	public void  get_registerCheckNum() throws Exception{
		response.setHeader("Pragma", "No-cache"); 
        response.setHeader("Cache-Control", "no-cache"); 
        response.setDateHeader("Expires", 0); 
        response.setContentType("image/jpeg"); 
           
        //生成随机字串 
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4); 
        //存入会话session 
         session = request.getSession(true); 
        //删除以前的
        session.removeAttribute("verCode");
        session.setAttribute("verCode", verifyCode.toLowerCase()); 
        //生成图片 
        int w = 100, h = 30; 
        VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);
	}
}
