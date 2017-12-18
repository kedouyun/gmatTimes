package com.app.web.base.controller;

import java.io.IOException;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONObject;
import com.app.common.utils.CaptchaUtil;
import com.app.common.utils.RedisUtils;
import com.app.web.base.AbstractWebController;
import com.app.web.entity.Member;
import com.app.web.service.MemberService;
import com.app.web.service.impl.MailService;


/**
 * @author liangliang
 * @Description: TODO()
 * @date 2017-11-17 20:06:36
 */
@Controller
@RequestMapping
public class LoginController extends AbstractWebController{
	
	@Autowired
	MailService mailService;
	
	@Autowired
	private MemberService memberService;
	@Autowired
	private RedisUtils redisUtils;

	@RequestMapping("/user/login")
	public String login(ModelMap model){
		model.addAttribute("flag", "login");
		return "/web/member/login";
	}
	@RequestMapping("/user/check.jpg")  
    public void createCode() throws IOException  {  
        // 通知浏览器不要缓存  
        response.setHeader("Expires", "-1");  
        response.setHeader("Cache-Control", "no-cache");  
        response.setHeader("Pragma", "-1");  
        CaptchaUtil util = CaptchaUtil.Instance();  
        // 将验证码输入到session中，用来验证  
        String code = util.getString();  
        request.getSession().setAttribute("code", code);  
        // 输出打web页面  
        ImageIO.write(util.getImage(), "jpg", response.getOutputStream());  
    } 
	
	@RequestMapping("/user/loginAction")
	public String loginAction(ModelMap model,@RequestParam(required=true) String email,@RequestParam(required=true) String password){
		
		Member member = memberService.queryByEmail(email);
		if(member!=null){
			if(member.getPassword().endsWith(password)){
				session.setAttribute("member", member);
				return "/web/index";
			}else{
				model.addAttribute("mess", "输入密码不正确");
			}
		}else{
			model.addAttribute("mess", "输入邮箱不正确");
		}
		return "/web/member/login";
	}
	
	
	@RequestMapping("/gmat")
	public String gmat(){
		return "/web/gmat";
	}
	//忘记密码
	@GetMapping("/user/forgot")
	public String forgot(){
		return "/web/member/forgot";
	}
	
	@PostMapping("/user/forgot")
	public String forgotAction(String email){
		if(StringUtils.isNotBlank(email)){
			this.sendValidateEmail(email);
		}
		return "/web/forgot";
	}
	
	@GetMapping("/user/newpassword/{token}")
	public String newpassword(@PathVariable("token") String token, ModelMap model){
		model.addAttribute("token", token);
		return "web/member/forgot";
	}
	
	@PostMapping("/user/newpassword/{token}")
	public String newpassword(@PathVariable("token") String token,  String password){
		String email = redisUtils.get(token);
		if(StringUtils.isBlank(password)){
			return "web/member/forgot";
		}
		if(StringUtils.isNotBlank(email)){
			Member	member=memberService.queryByEmail(email);
			member.setPassword(password);
			memberService.update(member);
		}
		
		return "web/member/forgot";
	}
	
	@Async
	private void sendValidateEmail(String email){
	String token = UUID.randomUUID().toString();
	redisUtils.set(token, email);
	logger.error("用户找回密码，准备发送邮件：User:" + email + ", Token: " + token);
		mailService.userPasswordforgot(email, token);
	}
}
