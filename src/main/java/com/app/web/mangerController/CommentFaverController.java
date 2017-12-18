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
import com.app.web.entity.CommentFaver;
import com.app.web.service.CommentFaverService;
/**
 * @author liangliang
 * @Description: TODO(评论表点赞记录)
 * @date 2017-12-07 16:05:13
 */
@Controller
@RequestMapping("/gm/commentfaver")
public class CommentFaverController extends AbstractController{

	@Autowired
	private CommentFaverService commentFaverService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list.do")
	public String list(@RequestParam Map<String, Object> params,ModelMap model){
		//查询列表数据
        Query query = new Query(params);

		List<CommentFaver> commentFaverList = commentFaverService.queryList(query);
		int total = commentFaverService.queryTotal(query);
		
		PageInfo pageInfo=new PageInfo(query.getPage()+"", query.getLimit()+"");
		pageInfo.setList(commentFaverList);
		pageInfo.getPage(total, query.getLimit());
		model.addAttribute("pageInfo", pageInfo);
		
		model.addAttribute("params", params);	
		
		return "/manger/commentFaver/list";
	}
	
	
	/**
	 * 修改
	 */
	@RequestMapping("/edit.do")
	public String edit(Long id,ModelMap model){
		CommentFaver commentFaver = commentFaverService.queryObject(id);
		model.addAttribute("commentFaver", commentFaver);	
		return "/manger/commentFaver/edit";
	}
	
	/**
	 * 新增
	 */
	@RequestMapping("/add.do")
	public String add(ModelMap model){
		return "/manger/commentFaver/add";
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save.do")
	public String save(@RequestBody CommentFaver commentFaver){
		commentFaverService.save(commentFaver);
		
		return seccess;
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update.do")
	public String update( CommentFaver commentFaver){
		commentFaverService.update(commentFaver);
		return seccess;
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete.do")
	public Result delete( Long[] memberId){
		commentFaverService.deleteBatch(memberId);
		
		return Result.ok();
	}
	
}
