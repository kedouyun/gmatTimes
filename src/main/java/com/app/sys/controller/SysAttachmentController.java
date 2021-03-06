package com.app.sys.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.app.common.exception.SelfException;
import com.app.common.utils.AttachmentUtils;
import com.app.common.utils.FileUtils;
import com.app.common.utils.PageUtils;
import com.app.common.utils.Query;
import com.app.common.utils.Result;
import com.app.sys.entity.SysAttachment;
import com.app.sys.service.SysAttachmentService;

/**
 * @author heguoliang
 * @Description: TODO(附件)
 * @date 2017-7-10 17:07
 */
@RestController
@RequestMapping("/sys/attachment")
public class SysAttachmentController extends AbstractController {

    @Autowired
    private SysAttachmentService sysAttachmentService;

    /**
     * 所有附件列表
     */
    @RequestMapping("/list")
    public Result list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        List<SysAttachment> configList=sysAttachmentService.queryList(query);
        int total=sysAttachmentService.queryTotal(query);
        PageUtils pageUtil=new PageUtils(configList, total, query.getLimit(), query.getPage());
        return Result.ok().put("page", pageUtil);
    }

    /**
     * 附件信息
     */
    @RequestMapping("/info/{id}")
    public Result info(@PathVariable("id") Long id){
        SysAttachment attachment = sysAttachmentService.queryObject(id);
        return Result.ok().put("attachment", attachment);
    }

    /**
     * 上传文件
     */
    @RequestMapping("/upload")
    public Result upload(HttpServletRequest request) {
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

                String path="/"+FileUtils.removePrefix(newFile.getAbsolutePath(), FileUtils.getTempPath()).replace("\\", "/");

                SysAttachment sysAttachment=new SysAttachment();
//                sysAttachment.setUserId(getUserId());
                sysAttachment.setTitle(file.getOriginalFilename());
                sysAttachment.setPath(path);
                sysAttachment.setSuffix(suffix);
                sysAttachment.setMimeType(file.getContentType());
                sysAttachment.setCreateTime(new Date());
                sysAttachmentService.save(sysAttachment);
            }

            return Result.ok();
        } catch (IOException e) {
            throw new SelfException("系统异常");
        }
    }

    /**
     * 下载文件
     */
    @RequestMapping("/download/{id}")
    public void download(@PathVariable("id") Long id, HttpServletResponse response) {
        SysAttachment attachment=sysAttachmentService.queryObject(id);
        if(attachment==null){
            throw new SelfException("文件不存在");
        }

        String path=FileUtils.getTempPath()+attachment.getPath();
        FileUtils.download(path, attachment.getTitle(), response);
    }

    /**
     * 删除配置
     */
    @RequestMapping("/delete")
    public Result delete(@RequestBody Long[] ids){
        sysAttachmentService.deleteBatch(ids);
        return Result.ok();
    }

}
