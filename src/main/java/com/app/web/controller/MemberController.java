package com.app.web.controller;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.common.utils.RedisUtils;
import com.app.config.login.Login;
import com.app.web.base.AbstractWebController;
import com.app.web.config.AsyncService;
import com.app.web.entity.Member;
import com.app.web.service.MemberService;
import com.app.web.service.impl.MailService;
import com.app.web.utils.ExecuteResult;

/**
 * @author liangliang
 * @Description: TODO(前端用户)
 * @date 2017-11-19 21:25:29
 */
@Controller("webMemberController")
@RequestMapping("/user")
public class MemberController extends AbstractWebController{

	@Autowired
	private MemberService memberService;
	@Autowired
	MailService mailService;
	@Autowired
	AsyncService asyncService;
	
	@Autowired
	private RedisUtils redisUtils;
	/**
	 * 信息
	 */
	@RequestMapping("/my/{path}")
	@Login
	public String center(@PathVariable("path")String path){
		return "/web/member/"+path;
	}
	
	//个人中心提交头像，性别保存
	@Login
	@PostMapping("/saveUserCent")
	@ResponseBody
	public ExecuteResult<Integer> saveUserCent(String headImage,Integer sex){
		ExecuteResult<Integer> result=new ExecuteResult<Integer>();
		if(StringUtils.isNoneBlank(headImage)&&(sex!=null)){
			Member member = getLoginMember();
			member.setHeadImage(headImage);
			member.setSex(sex);
			memberService.update(member);
			result.setCode("0000");
			result.setErrorMessage("保存成功");
		}else{
			result.setCode("2000");
			result.setErrorMessage("数据有误");
		}
		return result;
	}
		//用户保存考试日期和分数
		@Login
		@PostMapping("/saveUserTarget")
		@ResponseBody
		public ExecuteResult<Integer> saveUserTarget(Integer YYYY,Integer MM,Integer DD,String score){
			ExecuteResult<Integer> result=new ExecuteResult<Integer>();
			if(null!=YYYY&&null!=MM&&null!=DD&&null!=score){
				Calendar instance = Calendar.getInstance();
				instance.set(YYYY, MM-1, DD);
				
				Member member = getLoginMember();
				member.setExamDate(instance.getTime());
				member.setExamTarget(score);
				memberService.update(member);
				result.setCode("0000");
				result.setErrorMessage("保存成功");
			}else{
				result.setCode("2000");
				result.setErrorMessage("数据有误");
			}
			return result;
		}
	//更新密码
	@Login
	@PostMapping("/password")
	@ResponseBody
	public ExecuteResult<Integer> savePassword(String oldpassword,String newpassword,String re_newpassword){
		ExecuteResult<Integer> result=null;
		if(StringUtils.isNoneBlank(oldpassword)&&StringUtils.isNoneBlank(newpassword)&&StringUtils.isNoneBlank(re_newpassword)){
			 result=memberService.updatePassword(getLoginMember(),oldpassword,newpassword,re_newpassword);
		}else{
			result=new ExecuteResult<Integer>();
			result.setCode("2000");
			result.setErrorMessage("数据有误");
			return result;
		}
		return result;
	}
	//修改邮箱
	@Login
	@PostMapping("/email")
	@ResponseBody
	public ExecuteResult<Integer> saveEmail(String code,String email){
		ExecuteResult<Integer> result=new ExecuteResult<Integer>();
		String verCode=(String) session.getAttribute("verCode");
		if(!code.equalsIgnoreCase(verCode)){
			result.setCode("2000");
			result.setErrorMessage("验证码有误");
			return result;
		}
		if(StringUtils.isNoneBlank(code)&&StringUtils.isNoneBlank(email)){
			Member queryByEmail = memberService.queryByEmail(email);
			
			if(null==queryByEmail){
				Member loginMember = getLoginMember();
				loginMember.setEmail(email);
				asyncService.sendUpdateEmail(loginMember);
				result.setCode("0000");
				result.setErrorMessage("已发送邮箱");
			}else{
				result.setCode("2001");
				result.setErrorMessage("该邮箱已绑定");
			}
		}else{
			result.setCode("2000");
			result.setErrorMessage("数据有误");
			return result;
		}
		return result;
	}

	
	
	//激活修改的邮箱
	@RequestMapping("/actionemail/{token}")
	public String loginAction(ModelMap model,@PathVariable("token")  String token){
		Member member = redisUtils.get(token,Member.class);
		if(member!=null){
			memberService.update(member);
			redisUtils.delete(token);
			model.addAttribute("message", "邮箱验证成功 !");
		}else{
			model.addAttribute("message", "该邮件已过期!");
		}
		return "/web/member/successful";
	}
}
