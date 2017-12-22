package com.app.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.common.utils.Query;
import com.app.common.utils.Result;
import com.app.sys.vo.PageInfo;
import com.app.web.base.AbstractWebController;
import com.app.web.config.ErrorCode;
import com.app.web.entity.Bbs;
import com.app.web.entity.BbsFaver;
import com.app.web.service.BbsFaverService;
import com.app.web.service.BbsService;

@Controller("webThroughController")
@RequestMapping("/through")
public class ThroughController  extends AbstractWebController{
	@Autowired
	BbsService  bbsService;
	@Autowired
	BbsFaverService  bbsFaverService;
	//机经评论列表
	@GetMapping("/list")
	public String question(ModelMap model,@RequestParam Map<String, Object> params){
		Query query = new Query(params);
		Map<String, Object> map=new HashMap<>();
		map.put("status", 1);//上架
		map.put("memberId",getMemberId());//上架
		List<Bbs> commentList = bbsService.queryIndexList(map);
		int queryTotal = bbsService.queryIndexTotal(map);
		
		model.addAttribute("commentList", commentList);
		
		PageInfo pageInfo=new PageInfo(query.getPage()+"", query.getLimit()+"");
		pageInfo.setList(commentList);
		pageInfo.getPage(queryTotal, query.getLimit());
		model.addAttribute("pageInfo", pageInfo);
		
		return "/web/through/list";
	}
	
	@GetMapping("/detailList/{id}")
	public String detailList(ModelMap model,@RequestParam Map<String, Object> params,@PathVariable("id") Long id){
		Bbs queryObject = bbsService.queryWebById(id,getMemberId());
		model.addAttribute("bbs", queryObject);
		
		
		Query query = new Query(params);
		Map<String, Object> map=new HashMap<>();
		map.put("status", 1);//上架
		map.put("memberId",getMemberId());//上架
		map.put("parentId",id);//上架
		List<Bbs> commentList = bbsService.queryWebList(map);
		int queryTotal = bbsService.queryWebTotal(map);
		
		model.addAttribute("commentList", commentList);
		
		PageInfo pageInfo=new PageInfo(query.getPage()+"", query.getLimit()+"");
		pageInfo.setList(commentList);
		pageInfo.getPage(queryTotal, query.getLimit());
		model.addAttribute("pageInfo", pageInfo);
		
		return "/web/through/detail";
	}
	//保存评论
	@ResponseBody
	@PostMapping("/jijigng/save")
	public Result saveComment(Bbs comment){
		if(getLoginMember()==null){
			return Result.error(ErrorCode.SYS_ERROR_CODE_10007);
		}
		comment.setMemberId(getLoginMember().getId());
		bbsService.save(comment);
		Bbs queryObject = bbsService.queryObject(comment.getId());
		
		return Result.ok().put("comment",queryObject);
	}
	
	//点赞
	@ResponseBody
	@PostMapping("/jijigng/faver")
	public Result faver(BbsFaver bbsFaver){
		if(getLoginMember()==null){
			return Result.error(ErrorCode.SYS_ERROR_CODE_10007);
		}
		bbsFaver.setMemberId(getLoginMember().getId());
		bbsFaverService.save(bbsFaver);
		return Result.ok();
	}
}
