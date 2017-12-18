package com.app.web.mangerController;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.app.common.exception.SelfException;
import com.app.common.utils.AttachmentUtils;
import com.app.common.utils.FileUtils;
import com.app.common.utils.Query;
import com.app.common.utils.Result;
import com.app.sys.controller.AbstractController;
import com.app.sys.vo.PageInfo;
import com.app.web.entity.GrammarGroup;
import com.app.web.entity.GrammarTitle;
import com.app.web.entity.GrammarTypes;
import com.app.web.service.GrammarGroupService;
import com.app.web.service.GrammarTitleService;
import com.app.web.service.GrammarTypesService;
import com.app.web.service.QuestionsService;

/**
 * @author liangliang
 * @Description: TODO()
 * @date 2017-11-17 20:06:36
 */
@Controller
@RequestMapping("/manger/grammargroup")
public class GrammarGroupController extends AbstractController{

	@Autowired
	private GrammarGroupService grammarGroupService;
	
	@Autowired
	private QuestionsService questionsService;
	@Autowired
	private GrammarTypesService grammarTypesService;

	@Autowired
	private GrammarTitleService grammarTitleService;
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public String list(@RequestParam Map<String, Object> params,ModelMap model){
		//查询列表数据
        Query query = new Query(params);

		List<GrammarGroup> grammarGroupList = grammarGroupService.queryList(query);
		int total = grammarGroupService.queryTotal(query);
		
		PageInfo pageInfo=new PageInfo(query.getPage()+"", query.getLimit()+"");
		pageInfo.setList(grammarGroupList);
		pageInfo.getPage(total, query.getLimit());
		model.addAttribute("pageInfo", pageInfo);
		
		model.addAttribute("params", params);	
		
		return "/manger/grammargroup/list";
	}
	

	@RequestMapping("/edit.do")
	public String edit(Long id,ModelMap model){
		GrammarGroup grammarGroup = grammarGroupService.queryObject(id);
		model.addAttribute("grammargroup", grammarGroup);
		
		List<GrammarTypes> grammarTypes = grammarTypesService.search();
		model.addAttribute("grammarTypes", grammarTypes);
		
		if(grammarGroup.getGrammarTypesId()!=null){
			List<GrammarTitle> grammarTitle = grammarTitleService.search(grammarGroup.getGrammarTypesId());
			model.addAttribute("grammarTitleList", grammarTitle);
		}
		
		
		return "/manger/grammargroup/edit";
	}
	
	@RequestMapping("/add.do")
	public String add(ModelMap model){
		List<GrammarTypes> grammarTypes = grammarTypesService.search();
		model.addAttribute("grammarTypes", grammarTypes);
		
		return "/manger/grammargroup/add";
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public String save( GrammarGroup grammarGroup){
		grammarGroupService.save(grammarGroup);
		return seccess;
	}
	
	
	@ResponseBody
	@RequestMapping("/search/{grammarTypesId}.do")
	public Result search(@PathVariable("grammarTypesId") Long grammarTypesId){
		List<GrammarGroup> grammarGroup = grammarGroupService.queryByGrammarTypesId(grammarTypesId);
		return Result.ok().put("grammarGroup", grammarGroup);
	}
	
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public String update(GrammarGroup grammarGroup){
		grammarGroupService.update(grammarGroup);
		
		return seccess;
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public Result delete( Long[] id){
		grammarGroupService.deleteBatch(id);
		return Result.ok();
	}
	
	@RequestMapping("/uploadUi.do")
	public String uploadUi(Long id,ModelMap model){
		model.addAttribute("id", id);
		return "/manger/questions/importFile";
	}
	/**
     * 上传文件
     */
	@ResponseBody
    @RequestMapping("/upload.do")
    public Result upload(HttpServletRequest request,Long id) {
        try {
            List<MultipartFile> files=((MultipartHttpServletRequest) request).getFiles("file");
            if(files.isEmpty()){
                throw new SelfException("上传文件不能为空");
            }

            for(MultipartFile file:files){
                String suffix=FileUtils.getSuffix(file.getOriginalFilename());

                String newFileName=AttachmentUtils.newFileName(suffix);
                File newFile=new File(newFileName);
                file.transferTo(newFile);
                String path=FileUtils.getTempPath()+"/"+FileUtils.removePrefix(newFile.getAbsolutePath(), FileUtils.getTempPath()).replace("\\", "/");
                questionsService.importQuestTions(path,id,getUser().getUsername());
            }

            return Result.ok();
        } catch (IOException e) {
            throw new SelfException("系统异常");
        }
    }
}
