package com.app.sys.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.common.exception.SelfException;
import com.app.common.utils.PageUtils;
import com.app.common.utils.Query;
import com.app.common.utils.Result;
import com.app.common.validator.UpdateGroup;
import com.app.common.validator.ValidatorUtils;
import com.app.sys.entity.SysRole;
import com.app.sys.entity.SysUser;
import com.app.sys.service.SysRoleService;
import com.app.sys.service.SysUserRoleService;
import com.app.sys.service.SysUserService;
import com.app.sys.vo.PageInfo;

/**
 * @author heguoliang
 * @Description: TODO(系统用户)
 * @date 2017-6-23 15:07
 */
@Controller
@RequestMapping("/sys/user")
public class SysUserController extends AbstractController {

	@Autowired
	private SysUserService sysUserService;

	@Autowired
	private SysUserRoleService sysUserRoleService;
	@Autowired
	private SysRoleService sysRoleService;
	
	/**
	 * 所有用户列表
	 */
	@RequestMapping("/list.do")
	public String list(@RequestParam Map<String, Object> params,ModelMap model){
		//查询列表数据
		Query query = new Query(params);
		List<SysUser> userList = sysUserService.queryList(query);
		int total = sysUserService.queryTotal(query);
//		PageUtils pageUtil = new PageUtils(userList, total, query.getLimit(), query.getPage());
		PageInfo pageInfo=new PageInfo(query.getPage()+"", query.getLimit()+"");
		pageInfo.setList(userList);
		pageInfo.getPage(total, query.getLimit());
		model.addAttribute("pageInfo", pageInfo);
		
		model.addAttribute("params", params);
		
		return "/manger/user/list";
	}
	
	/**
	 * 获取登录的用户信息
	 */
	@ResponseBody
	@RequestMapping("/info.do")
	public Result info(){
		return Result.ok().put("user", getUser());
	}
	
	@RequestMapping("/add.do")
	public String add(ModelMap model){
		
		SysUser user = sysUserService.queryObject(getUserId());
		List<Long> roleIdList = sysUserRoleService.queryRoleIdList(getUserId());
		user.setRoleIdList(roleIdList);
		model.addAttribute("user", user);
		
		Map<String, Object> map = new HashMap<>();
		List<SysRole> list = sysRoleService.queryList(map);
		model.addAttribute("sysRoleUser", list);
		return "/manger/user/add";
	}
	/**
	 * 修改登录用户密码
	 */
	@ResponseBody
	@RequestMapping("/updatePassword.do")
	public Result updatePassword(String password, String newPassword){
		if(StringUtils.isBlank(newPassword)){
			throw new SelfException("新密码不为能空");
		}
		
		//sha256加密
//		password = new Sha256Hash(password, getUser().getSalt()).toHex();
//		//sha256加密
//		newPassword = new Sha256Hash(newPassword, getUser().getSalt()).toHex();
//
//		//更新密码
//		int count = sysUserService.updatePassword(getUser(), password, newPassword);
//		if(count == 0){
//			return Result.error("原密码不正确");
//		}
		
		return Result.ok();
	}
	
	/**
	 * 用户信息
	 */
	@ResponseBody
	@RequestMapping("/info/{userId}")
	public Result info(@PathVariable("userId") Long userId){
		SysUser user = sysUserService.queryObject(userId);
		
		//获取用户所属的角色列表
		List<Long> roleIdList = sysUserRoleService.queryRoleIdList(userId);
		user.setRoleIdList(roleIdList);
		
		return Result.ok().put("user", user);
	}
	@RequestMapping("/edit.do")
	public String edit(Long id,ModelMap model){
		SysUser user = sysUserService.queryObject(id);
		
		//获取用户所属的角色列表
		List<Long> roleIdList = sysUserRoleService.queryRoleIdList(id);
		if(roleIdList!=null){
			user.setRoleIdList(roleIdList);
		}
		
		model.addAttribute("user", user);
		
		Map<String, Object> map = new HashMap<>();
		List<SysRole> list = sysRoleService.queryList(map);
		model.addAttribute("sysRoleUser", list);
		
		return "/manger/user/edit";
	}
	
	/**
	 * 保存用户
	 */
	@RequestMapping("/save.do")
	public String save(SysUser user){
		
		sysUserService.save(user);
		return "/manger/common/closeWindow";
	}
	
	/**
	 * 修改用户
	 */
	@RequestMapping("/update.do")
	public String update( SysUser user){
		ValidatorUtils.validateEntity(user, UpdateGroup.class);
		sysUserService.update(user);
		return seccess;
	}
	
	/**
	 * 删除用户
	 */
	@ResponseBody
	@RequestMapping("/delete.do")
	public Result delete(Long[] id){
		if(ArrayUtils.contains(id, 1L)){
			return Result.error("系统管理员不能删除");
		}
		if(ArrayUtils.contains(id, getUserId())){
			return Result.error("当前用户不能删除");
		}
		sysUserService.deleteBatch(id);
		return Result.ok();
	}

}
