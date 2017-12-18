package com.app.sys.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.app.sys.entity.SysUser;

/**
 * @author heguoliang
 * @Description: TODO(Controller公共组件) 
 * @date 2017-6-23 15:07
 */
public abstract class AbstractController {
	protected HttpServletRequest request;
	protected HttpServletResponse response;
    
    protected HttpSession session;
    
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	protected final String seccess="/manger/common/closeWindow";
	
	protected SysUser getUser() {
		return (SysUser) request.getSession().getAttribute("sysUser");
	}
	protected PrintWriter getJsonWriter() throws IOException {
		response.setContentType("text/json;charset=utf-8");
		return response.getWriter();
	}
	
	 @ModelAttribute
	protected void initAttribute(HttpServletRequest request, HttpServletResponse response){
		this.request=request;
		this.response=response;
		this.session=request.getSession();
	}
    @InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}
	    
	protected Long getUserId()  {
		if(getUser()==null){
			try {
				response.sendRedirect("/manger");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return getUser().getId();
	}

	protected Long getDeptId() {
		return getUser().getDeptId();
	}

}
