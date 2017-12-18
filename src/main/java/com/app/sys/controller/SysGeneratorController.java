package com.app.sys.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.app.common.utils.PageUtils;
import com.app.common.utils.Query;
import com.app.common.utils.Result;
import com.app.sys.service.SysGeneratorService;
import com.app.sys.vo.PageInfo;

/**
 * @author heguoliang
 * @Description: TODO(代码生成器)
 * @date 2017-6-23 15:07
 */
@Controller
@RequestMapping("/sys/generator")
public class SysGeneratorController extends AbstractController{

	@Autowired
	private SysGeneratorService sysGeneratorService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list.do")
	public String list(@RequestParam Map<String, Object> params,ModelMap model){
		//查询列表数据
		Query query = new Query(params);
		List<Map<String, Object>> list = sysGeneratorService.queryList(query);
		int total = sysGeneratorService.queryTotal(query);
		
		PageInfo pageInfo=new PageInfo(query.getPage()+"", query.getLimit()+"");
		pageInfo.setList(list);
		pageInfo.getPage(total, query.getLimit());
		model.addAttribute("pageInfo", pageInfo);
		
		model.addAttribute("params", params);
		
		return "/manger/generator/list";
	}
	
	/**
	 * 生成代码
	 */
	@RequestMapping("/code.do")
	public void code(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String[] tableNames = new String[]{};
		String tables = request.getParameter("tables");
		tableNames =tables.split(",");
		
		byte[] data = sysGeneratorService.generatorCode(tableNames);
		
		response.reset();  
        response.setHeader("Content-Disposition", "attachment; filename=\"sbed-generate-code.zip\"");
        response.addHeader("Content-Length", "" + data.length);  
        response.setContentType("application/octet-stream; charset=UTF-8");  
  
        IOUtils.write(data, response.getOutputStream());  
	}

}
