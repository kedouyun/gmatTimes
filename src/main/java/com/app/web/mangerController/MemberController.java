package com.app.web.mangerController;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.common.utils.PageUtils;
import com.app.common.utils.Query;
import com.app.common.utils.Result;
import com.app.sys.controller.AbstractController;
import com.app.sys.vo.PageInfo;
import com.app.web.entity.Member;
import com.app.web.service.MemberService;

/**
 * @author liangliang
 * @Description: TODO(前端用户)
 * @date 2017-11-19 21:02:02
 */
@Controller
@RequestMapping("/manger/member")
public class MemberController extends AbstractController{

	@Autowired
	private MemberService memberService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list.do")
	public String list(@RequestParam Map<String, Object> params,ModelMap model){
		//查询列表数据
        Query query = new Query(params);

		List<Member> memberList = memberService.queryList(query);
		int total = memberService.queryTotal(query);
		
		PageInfo pageInfo=new PageInfo(query.getPage()+"", query.getLimit()+"");
		pageInfo.setList(memberList);
		pageInfo.getPage(total, query.getLimit());
		model.addAttribute("pageInfo", pageInfo);
		
		model.addAttribute("params", params);
		
		return "/manger/member/list";
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/edit.do")
	public String edit(Long id,ModelMap model){
		Member member = memberService.queryObject(id);
		model.addAttribute("member", member);
		return "/manger/member/edit";
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save.do")
	public String save(@RequestBody Member member){
		memberService.save(member);
		return seccess;
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public String update( Member member){
		memberService.update(member);
		
		return seccess;
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public Result delete(@RequestBody Long[] ids){
		memberService.deleteBatch(ids);
		
		return Result.ok();
	}
	
}
