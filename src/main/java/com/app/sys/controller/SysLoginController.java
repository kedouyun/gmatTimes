package com.app.sys.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.common.utils.Md5Util;
import com.app.common.utils.Result;
import com.app.sys.entity.SysMenu;
import com.app.sys.entity.SysUser;
import com.app.sys.service.SysMenuService;
import com.app.sys.service.SysUserService;
import com.google.code.kaptcha.Producer;

/**
 * @author heguoliang
 * @Description: TODO(登录相关)
 * @date 2017-6-23 15:07
 */
@RequestMapping
@Controller
public class SysLoginController extends AbstractController {

	@Autowired
	private Producer producer;
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private SysMenuService sysMenuService;

	@GetMapping("/manger/login")
	public String index(){
		return "/manger/admin/login";
	}
	
	@RequestMapping("/captcha.jpg")
	public void captcha(HttpServletResponse response)throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-store, no-cache");
		response.setContentType("image/jpeg");

		//生成文字验证码
		String text = producer.createText();
		//生成图片验证码
		BufferedImage image = producer.createImage(text);
		//保存到shiro session
//		ShiroUtils.setSessionAttribute(Constants.KAPTCHA_SESSION_KEY, text);

		ServletOutputStream out = response.getOutputStream();
		ImageIO.write(image, "jpg", out);
		IOUtils.closeQuietly(out);
	}

	/**
	 * 获取登录错误次数
	 */
	@RequestMapping(value = "/sys/getLoginErrorTimes", method = RequestMethod.GET)
	public Result getLoginErrorTimes(){
		return null;
//		Object errorTimes = ShiroUtils.getSessionAttribute(Constant.LOGIN_ERROR_TIMES);
//		return Result.ok().put("errorTimes", errorTimes);
	}
	
	@RequestMapping(value = "/manger/home.do", method = RequestMethod.GET)
	public String home(ModelMap model){
		List<SysMenu> menuList = sysMenuService.getUserMenuList(getUserId());
//		Set<String> permissions = sysUserService.getUserPermissions(getUserId());
		model.addAttribute("menuList", menuList);
		return "/manger/admin/home";
//		Object errorTimes = ShiroUtils.getSessionAttribute(Constant.LOGIN_ERROR_TIMES);
//		return Result.ok().put("errorTimes", errorTimes);
	}

	/**
	 * 登录
	 */
	@RequestMapping(value = "/manger/login.do", method = RequestMethod.POST)
	@ResponseBody
	public Result login(String username, String password, String captcha)throws IOException {
		
		SysUser user = sysUserService.queryByUserName(username);
		
		if(user==null){
			return Result.error("账号不存在").put("errorTimes", "");
		}else{
			if(!user.getPassword().equals(Md5Util.getMD5Code(password))) {
				return Result.error("密码不正确");
			}
		}
		session.setAttribute("sysUser", user);
		session.setMaxInactiveInterval(60 * 30);
//		Object _login_errors = ShiroUtils.getSessionAttribute(Constant.LOGIN_ERROR_TIMES);
//		if(_login_errors == null){
//			_login_errors = 0;
//		}
//		long errorTimes = Long.valueOf(_login_errors.toString());
//
//		//用户信息
//		SysUser user = sysUserService.queryByUserName(username);
//
//		//账号不存在
//		if(user == null) {
////			ShiroUtils.setSessionAttribute(Constant.LOGIN_ERROR_TIMES, ++errorTimes);
//			return Result.error("账号不存在").put("errorTimes", errorTimes);
//		}

//		//密码错误
//		if(!user.getPassword().equals(new Sha256Hash(password, user.getSalt()).toHex())) {
//			ShiroUtils.setSessionAttribute(Constant.LOGIN_ERROR_TIMES, ++errorTimes);
//			return Result.error("密码不正确").put("errorTimes", errorTimes);
//		}
//
//		//验证码
//		if(errorTimes >= 3){
//			String kaptcha = getKaptcha(Constants.KAPTCHA_SESSION_KEY);
//			if(!captcha.equalsIgnoreCase(kaptcha)){
//				ShiroUtils.setSessionAttribute(Constant.LOGIN_ERROR_TIMES, ++errorTimes);
//				return Result.error("验证码不正确").put("errorTimes", errorTimes);
//			}
//		}
//
//		//账号锁定
//		if(Constant.UserStatus.DISABLE.getValue() == user.getStatus()){
//			ShiroUtils.setSessionAttribute(Constant.LOGIN_ERROR_TIMES, ++errorTimes);
//			return Result.error("账号已被锁定,请联系管理员").put("errorTimes", errorTimes);
//		}

		//生成token，并保存到数据库
//		Map<String, Object> result=sysUserTokenService.createToken(getUserId());
		Result r =Result.ok();
		return r;
	}

	/**
	 * 退出
	 */
	@ResponseBody
	@RequestMapping(value = "/sys/logout", method = RequestMethod.POST)
	public Result logout() {
		session.invalidate();
		
		return Result.ok();
	}

	/**
	 *从session中获取记录的验证码
	 */
	private String getKaptcha(String key) {
		return key;
//		Object kaptcha = ShiroUtils.getSessionAttribute(key);
//		if(kaptcha == null){
//			throw new SbedException("验证码已失效");
//		}
//		ShiroUtils.getSession().removeAttribute(key);
//		return kaptcha.toString();
	}
	
}
