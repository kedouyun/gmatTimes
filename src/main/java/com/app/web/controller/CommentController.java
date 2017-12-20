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

import com.alibaba.fastjson.JSON;
import com.app.common.utils.Query;
import com.app.common.utils.RedisUtils;
import com.app.common.utils.Result;
import com.app.sys.vo.PageInfo;
import com.app.web.base.AbstractWebController;
import com.app.web.config.ErrorCode;
import com.app.web.entity.Comment;
import com.app.web.entity.CommentFaver;
import com.app.web.entity.ExampaperQuestions;
import com.app.web.entity.Questions;
import com.app.web.service.CommentFaverService;
import com.app.web.service.CommentService;
import com.app.web.service.ExampaperQuestionsService;
import com.app.web.service.GrammarGroupService;
import com.app.web.service.GrammarGroupStatusService;
import com.app.web.service.GrammarTitleService;
import com.app.web.service.GrammarTypesService;
import com.app.web.service.MemberService;
import com.app.web.service.MessageService;
import com.app.web.service.QuestionsService;

/**
 * @author liangliang
 * @Description: TODO(评论)
 * @date 2017-11-19 21:25:29
 */
@Controller("webPracticeResult")
@RequestMapping("/comment")
public class CommentController extends AbstractWebController{

	@Autowired
	private MemberService memberService;
	@Autowired
	private GrammarGroupService grammarGroupService;
	@Autowired
	private GrammarTitleService grammarTitleService;
	
	@Autowired
	private GrammarTypesService grammarTypesService;
	@Autowired
	private QuestionsService questionsService;
	@Autowired
	private GrammarGroupStatusService grammarGroupStatusService;
	@Autowired
	private RedisUtils redisUtils;
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private ExampaperQuestionsService exampaperQuestionsService;
	
	@Autowired
	private CommentFaverService commentFaverService;//点赞
	
	//模拟考试跳转到试题评论页
	@GetMapping("/exam/{exampaperQuestionsId}")
	public String question(@PathVariable("exampaperQuestionsId") Long exampaperQuestionsId){
		ExampaperQuestions queryObject = exampaperQuestionsService.queryObject(exampaperQuestionsId);
		return "redirect:/comment/gmat/"+queryObject.getQuestionsId();
	}
	
	//试题评论列表
	@GetMapping("/gmat/{questionId}")
	public String question(ModelMap model,@RequestParam Map<String, Object> params,@PathVariable("questionId") Long questionId){
		Questions questions = questionsService.queryObject(questionId);
		HashMap parse = JSON.parseObject(questions.getContent(), HashMap.class);
		model.addAttribute("quest", parse);
		model.addAttribute("questionId", questionId);
		
		Query query = new Query(params);
		Map<String, Object> map=new HashMap<>();
		map.put("status", 1);//上架
		map.put("memberId",getMemberId());//上架
		List<Comment> commentList = commentService.queryWebList(map);
		int queryTotal = commentService.queryWebTotal(map);
		
		model.addAttribute("commentList", commentList);
		
		PageInfo pageInfo=new PageInfo(query.getPage()+"", query.getLimit()+"");
		pageInfo.setList(commentList);
		pageInfo.getPage(queryTotal, query.getLimit());
		model.addAttribute("pageInfo", pageInfo);
		
		return "/web/gmat/questComment";
	}
	//保存评论
	@ResponseBody
	@PostMapping("/gmat/save")
	public Result saveComment(Comment comment){
		if(getLoginMember()==null){
			return Result.error(ErrorCode.SYS_ERROR_CODE_10007);
		}
		comment.setMemberId(getLoginMember().getId());
		commentService.save(comment);
		Comment queryObject = commentService.queryObject(comment.getId());
		
		return Result.ok().put("comment",queryObject);
	}
	
	//点赞
	@ResponseBody
	@PostMapping("/gmat/faver")
	public Result faver(CommentFaver commentFaver){
		if(getLoginMember()==null){
			return Result.error(ErrorCode.SYS_ERROR_CODE_10007);
		}
		commentFaver.setMemberId(getLoginMember().getId());
		commentFaverService.save(commentFaver);
		return Result.ok();
	}
	
}
