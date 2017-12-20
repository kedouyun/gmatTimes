package com.app.web.controller;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.common.utils.RandomNum;
import com.app.common.utils.Result;
import com.app.sys.controller.AbstractController;

@Controller("web_upload")
@RequestMapping("/webupload")
public class Upload extends AbstractController{
	
	@Value("${system_url}")  
	private String system_url;
	
	@Value("${upload_address}")  
	private String upload_address;
	
	@ResponseBody
	@RequestMapping(value="/file")
	public Result uploadImge(String image) throws IllegalStateException, IOException  {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMM");
		
		SimpleDateFormat df1 = new SimpleDateFormat("MMddHHmmss");
		String dateTimeformat=df1.format(new Date());
		String fileName =  dateTimeformat+RandomNum.genRandomNum(10)+".jpg";
		String ymd = simpleDateFormat.format(new Date());
		String filePath ="/articleImage/" + ymd + "/"+fileName;
		System.out.println(upload_address+filePath);
		com.app.common.utils.Base64Utils.GenerateImage(image,upload_address+filePath);
		System.out.println("xxxxxxxxxxxxxxxx");
		return Result.ok().put("url", system_url+"/images"+filePath).put("filePath", "/images"+filePath);
	}
}
