package com.app.web.mangerController;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.common.utils.Query;
import com.app.common.utils.Result;
import com.app.sys.controller.AbstractController;
import com.app.sys.vo.PageInfo;
import com.app.web.entity.Comment;
import com.app.web.service.CommentService;
/**
 * @author liangliang
 * @Description: TODO(题库评论表)
 * @date 2017-12-07 16:05:14
 */
@Controller
@RequestMapping("/gm/comment")
public class CommentController extends AbstractController{

	@Autowired
	private CommentService commentService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list.do")
	public String list(@RequestParam Map<String, Object> params,ModelMap model){
		//查询列表数据
        Query query = new Query(params);

		List<Comment> commentList = commentService.queryList(query);
		int total = commentService.queryTotal(query);
		
		PageInfo pageInfo=new PageInfo(query.getPage()+"", query.getLimit()+"");
		pageInfo.setList(commentList);
		pageInfo.getPage(total, query.getLimit());
		model.addAttribute("pageInfo", pageInfo);
		
		model.addAttribute("params", params);	
		
		return "/manger/comment/list";
	}
	
	
	/**
	 * 修改
	 */
	@RequestMapping("/edit.do")
	public String edit(Long id,ModelMap model){
		Comment comment = commentService.queryObject(id);
		model.addAttribute("comment", comment);	
		return "/manger/comment/edit";
	}
	
	/**
	 * 新增
	 */
	@RequestMapping("/add.do")
	public String add(ModelMap model){
		return "/manger/comment/add";
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save.do")
	public String save(@RequestBody Comment comment){
		commentService.save(comment);
		
		return seccess;
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update.do")
	public String update( Comment comment){
		commentService.update(comment);
		return seccess;
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete.do")
	public Result delete( Long[] id){
		commentService.deleteBatch(id);
		
		return Result.ok();
	}
	
}
