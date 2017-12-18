package com.app.web.service.impl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.app.web.entity.Member;
import com.app.web.service.MemberService;

@Service
public class MailService {
	protected Logger logger = LoggerFactory.getLogger(getClass());
    @Value("${spring.mail.username}")
    private String username;
    @Value("${system_url}")
    private String system_url;
    
    @Autowired
    private JavaMailSender sender;
    
    @Autowired
	private MemberService memberService;
    
    /*发送邮件的方法*/
    public void sendSimple(String to, String title, String content){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(username); //发送者
        message.setTo(to); //接受者
        message.setSubject(title); //发送标题
        message.setText(content);  //发送内容
        sender.send(message);
        System.out.println("邮件发送成功");
    }
    
    public void userValidate(Member member, String token){
    	 MimeMessage mailMessage = sender.createMimeMessage();
    	 try {
    	  MimeMessageHelper helper = new MimeMessageHelper(mailMessage, true, "GBK");
    	  helper.setFrom(username);
    	  helper.setTo(member.getEmail());
    	  helper.setSubject("邮箱激活：");
    	  String url = system_url+"/activation/" + token;
    	  
    	  StringBuffer sb = new StringBuffer();
          sb.append("<div style='text-align:center;width:640px;height:560px;margin: 0 auto;box-shadow: 0 0 4px 0px #ccc;background:#FFF;padding:20px;font-family:'微软雅黑';margin:0 auto;box-shadow:0 0 4px 0px #ccc;background:url() no-repeat;background-position:right bottom;'><a style='display:block;text-align:right;color:#4c91ff;font-size:14px;text-decoration:none;'>进入网站</a><img src='javascript:;'><div style='text-align:left;width:510px;height:270px;margin:0 auto;font-family:'微软雅黑';'><p style='font-size:18px;color:#333;'>您好，<span style='font-weight:600;'><a href='mailto:"+member.getEmail()+"' target='_blank'>"+member.getEmail()+"</a></span>：</p><p class='font-size:12px;color:#333;'>感谢您注册GMATimes，点击下方的按钮完成您的邮箱验证。</p><a href='"+url+"' style='display:block;width:230px;height:46px;line-height:46px;font-size:18px;color:#FFF;margin:40px auto;background:#4c91ff;text-align:center;border-radius:3px;text-decoration:none;' target='_blank'>完成验证</a><p style='line-height:25px;'>GMATimes是专注于出国考试在线科学备考的口碑品牌。<br>通过对教学品质的极致追求，快速实现提分理想。<br>让辅导过程清晰可控！让辅导效果安全可见！</p></div></div>");
          
//    	  String message = String.format("22", link, member.getEmail());
//    	  Context context = new Context();
//        context.setVariable("message", member);
//    	  String   message=  templateEngine.process("emailTemplate", context);
    	  helper.setText(sb.toString(), true);
    	  sender.send(mailMessage);
    	 } catch (MessagingException e) {
    		 logger.error("发送邮件失败：User:" + JSONObject.toJSONString(member) + ", Token: " + token);
    	 }
    }

	public void userPasswordforgot(String email, String token) {
		 MimeMessage mailMessage = sender.createMimeMessage();
		 
		try {
	    	  MimeMessageHelper helper = new MimeMessageHelper(mailMessage, true, "GBK");
	    	  helper.setFrom(username);
	    	  helper.setTo(email);
	    	  helper.setSubject("找回密码：");
	    	  String url = system_url+"/newpassword/" + token;
	    	  Member queryByEmail = memberService.queryByEmail(email); 
	    	  if(queryByEmail==null){
	    		  return;
	    	  }
	    	  StringBuffer sb = new StringBuffer();
	          sb.append("<div style='text-align:center;width:640px;height:560px;margin: 0 auto;box-shadow: 0 0 4px 0px #ccc;background:#FFF;padding:20px;font-family:'微软雅黑';margin:0 auto;box-shadow:0 0 4px 0px #ccc;background:url() no-repeat;background-position:right bottom;'><a style='display:block;text-align:right;color:#4c91ff;font-size:14px;text-decoration:none;'>进入网站</a><img src='javascript:;'><div style='text-align:left;width:510px;height:270px;margin:0 auto;font-family:'微软雅黑';'><p style='font-size:18px;color:#333;'>您好，<span style='font-weight:600;'><a href='mailto:"+email+"' target='_blank'>"+	email+"</a></span>：</p><p class='font-size:12px;color:#333;'>您可以点击下面的按钮重置您的密码。如果您未发起这次重置密码，请忽略此邮件。</p><a href='"+url+"' style='display:block;width:230px;height:46px;line-height:46px;font-size:18px;color:#FFF;margin:40px auto;background:#4c91ff;text-align:center;border-radius:3px;text-decoration:none;' target='_blank'>完成验证</a><p style='line-height:25px;'>GMATimes是专注于出国考试在线科学备考的口碑品牌。<br>通过对教学品质的极致追求，快速实现提分理想。<br>让辅导过程清晰可控！让辅导效果安全可见！</p></div></div>");
	          
	    	  helper.setText(sb.toString(), true);
	    	  sender.send(mailMessage);
	    	  
	    	 } catch (MessagingException e) {
	    		 logger.error("密码找回发送邮件失败：User:" + email + ", Token: " + token);
	    	 }
	}    	 
}