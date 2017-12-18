package com.app.web.mangerController;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.app.common.utils.RandomNum;
import com.app.sys.controller.AbstractController;

@Controller
@RequestMapping("/upload")
public class Upload extends AbstractController{
	
	@Value("${system_url}")  
	private String system_url;
	
	@Value("${upload_address}")  
	private String upload_address;
	
	@RequestMapping(value="/uploadImage.do")
	public void uploadImge(HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException  {
		//需要保存和返回的路径
//		String thePath = null;
		// 创建一个通用的多部分解析器
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
		// 判断 request 是否有文件上传,即多部分请求
		if (multipartResolver.isMultipart(request)) {
			// 转换成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// 取得request中的所有文件名
			Iterator<String> iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				// 取得上传文件
				MultipartFile file = multiRequest.getFile(iter.next());
				response.setContentType("text/plain;charset=UTF-8");
				PrintWriter out = getJsonWriter();   
				if (file != null) {
					// 取得当前上传文件的文件名称
					String myFileName = file.getOriginalFilename();
					// 如果名称不为“”,说明该文件存在，否则说明该文件不存在
					if (myFileName.trim() != "") {
						String fileLastNameType =file.getOriginalFilename().substring(myFileName.indexOf("."));
						//获取文件类型
						String fileType=file.getContentType();
						System.out.println(fileType);
						// 重命名上传后的文件名
							if ( "application/octet-stream".equals(fileType)||"image/pjpeg".equals(fileType)||"image/jpg".equals(fileType)||"image/jpeg".equals(fileType) ||"image/x-png".equals(fileType)||"image/png".equals(fileType) ||"image/gif".equals(fileType)){
								SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
								SimpleDateFormat df1 = new SimpleDateFormat("yyyyMMddHHmmss");
							    String dateformat=df.format(new Date());
							    String dateTimeformat=df1.format(new Date());
							    String fileName=dateTimeformat+RandomNum.genRandomNum(10)+fileLastNameType;
							    String pathString = "uploadImage/"+dateformat+"/"+fileName;
//								String root = request.getSession().getServletContext().getRealPath("/"+pathString);
							    String root = upload_address;
								File filePath = new File(root);
								if(!filePath.exists()) {
									filePath.mkdirs();
								}
								file.transferTo(filePath);
							
						        out.write( "{\"error\":0,\"url\" : \""+pathString+"\"}");
							}else{
								out.write("{\"error\": 1,\"message\" : \"上传图片格式错误！\"}");
							}
						}else{
						out.write("{\"error\":1,\"url\" : : \"图片不能为空\"\"}");
					}
				}
			}

		}
	}
	/**
	 * 删除未保存到数据库的图片
	 * @param request
	 * @param response
	 * @param imagePath
	 * @throws Exception 2015-7-31 下午05:52:16 李亮亮
	 */
	@RequestMapping(value="/deleteImage.do")
	public void deleteImage(HttpServletRequest request,HttpServletResponse response,String imagePath) throws Exception{
		String root = request.getSession().getServletContext().getRealPath("/"+imagePath);
		response.setContentType("text/plain;charset=UTF-8");
		System.out.println(root);
		File file=new File(root);
		file.delete();
		PrintWriter out = getJsonWriter();   
		out.write("{\"error\": 0,\"message\" : \"删除成功\"}");
	}
	//编辑器上传使用该方法
	@RequestMapping(value="/upload.do")
	public void upload(HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException  {
		//需要保存和返回的路径
//		String thePath = null;
		// 创建一个通用的多部分解析器
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
		// 判断 request 是否有文件上传,即多部分请求
		if (multipartResolver.isMultipart(request)) {
			// 转换成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// 取得request中的所有文件名
			Iterator<String> iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				// 取得上传文件
				MultipartFile file = multiRequest.getFile(iter.next());
				response.setContentType("text/plain;charset=UTF-8");
				PrintWriter out = getJsonWriter();   
				if (file != null) {
					// 取得当前上传文件的文件名称
					String myFileName = file.getOriginalFilename();
					// 如果名称不为“”,说明该文件存在，否则说明该文件不存在
					if (myFileName.trim() != "") {
						String fileLastNameType =file.getOriginalFilename().substring(myFileName.indexOf("."));
						//获取文件类型
						String fileType=file.getContentType();
						// 重命名上传后的文件名
						System.out.println(fileType=="image/jpeg");
							if ( "image/pjpeg".equals(fileType)||"image/jpeg".equals(fileType) ||"image/x-png".equals(fileType)||"image/png".equals(fileType) ||"image/gif".equals(fileType)){
								String root = upload_address;
								
								SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMM");
								
								SimpleDateFormat df1 = new SimpleDateFormat("MMddHHmmss");
								  String dateTimeformat=df1.format(new Date());
								String fileName =  dateTimeformat+RandomNum.genRandomNum(10)+".jpg";
								String ymd = simpleDateFormat.format(new Date());
								String filePath =  "/articleImage/" + ymd + "/";
								File baseFile = new File(root +filePath);
								File targetFile = new File(root +filePath, fileName);

								if (!baseFile.exists()) {
									baseFile.mkdirs();
								}
								//保存
								try {
									file.transferTo(targetFile);
								} catch (Exception e) {
									e.printStackTrace();
								}
								
								
								
								
								
								
								
								
//								SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
//							    String dateformat=df.format(new Date());
//							    String fileName= RandomNum.genRandomNum(5)+fileLastNameType;
//							    String pathString = "uploadImage/"+dateformat+"/";
//								String root = request.getSession().getServletContext().getRealPath("/"+pathString);
//								File filePath = new File(root);
//								if(!filePath.exists()) {
//									filePath.mkdirs();
//								}
//								file.transferTo(filePath);
								if(request.getParameter("name")!=null){
									out.write( "{\"error\":0,\"url\" : \"/images"+filePath+fileName+"\"}");
								}else{
									out.write( "{\"error\":0,\"url\" : \""+system_url+"/images"+filePath+fileName+"\"}");
									
								}
							}else{
								out.write("{\"error\": 1,\"message\" : \"上传图片格式错误！\"}");
							}
						}else{
						out.write("{\"error\":1,\"url\" : : \"图片不能为空\"\"}");
					}
				}
			}

		}
	}
}
