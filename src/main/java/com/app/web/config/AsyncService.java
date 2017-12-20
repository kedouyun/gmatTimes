package com.app.web.config;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.app.common.utils.RedisUtils;
import com.app.web.entity.Member;
import com.app.web.service.impl.MailService;

@Component
public class AsyncService {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private RedisUtils redisUtils;
	@Autowired
	private MailService mailService;
	//修改绑定的邮箱
	@Async
	public void sendUpdateEmail(Member member){
		String token = UUID.randomUUID().toString();
		redisUtils.set(token, member);
		logger.error("用户修改邮箱，准备发送邮件：User:" + JSONObject.toJSONString(member) + ", Token: " + token);
		mailService.userChangeEmailValidate(member, token);
	}
	
	@Async
	public void sendValidateEmail(Member member){
		String token = UUID.randomUUID().toString();
		redisUtils.set(token, member);
		logger.error("用户注册，准备发送邮件：User:" + JSONObject.toJSONString(member) + ", Token: " + token);
		mailService.userValidate(member, token);
	}
	
	@Async
	public void sendValidateEmail(String email){
		String token = UUID.randomUUID().toString();
		redisUtils.set(token, email);
		logger.error("用户找回密码，准备发送邮件：User:" + email + ", Token: " + token);
		mailService.userPasswordforgot(email, token);
	}
}
