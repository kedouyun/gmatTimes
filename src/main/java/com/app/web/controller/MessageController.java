package com.app.web.controller;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.common.utils.Query;
import com.app.config.login.Login;
import com.app.sys.vo.PageInfo;
import com.app.web.base.AbstractWebController;
import com.app.web.entity.Article;
import com.app.web.entity.Message;
import com.app.web.entity.SysDictionary;
import com.app.web.service.MessageService;

@Controller("webMessageController")
@RequestMapping("/message")
public class MessageController extends AbstractWebController{
	@Autowired
	MessageService messageService;
	
	@Login
	@RequestMapping("/list")
	public String list(@RequestParam Map<String, Object> params,ModelMap model){
		
		Query query = new Query(params);
		query.put("memberId", getMemberId());
		List<Message> articleList = messageService.queryList(query);
		int total = messageService.queryTotal(query);
		PageInfo pageInfo=new PageInfo(query.getPage()+"", query.getLimit()+"");
		pageInfo.setList(articleList);
		pageInfo.getPage(total, query.getLimit());
		model.addAttribute("pageInfo", pageInfo);
		
		model.addAttribute("params", params);	
		
		messageService.updateReaded(getMemberId());
		
		return "/web/message/list";
	}
}
