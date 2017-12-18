package com.app.web.base;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.app.web.entity.Member;

/**
 * @author heguoliang
 * @Description: TODO(Controller公共组件)
 * @date 2017-6-23 15:07
 */
public abstract class AbstractWebController {
	
	 
	protected HttpServletRequest request;
	protected HttpServletResponse response;
    
    protected HttpSession session;
    
	protected Logger logger = LoggerFactory.getLogger(getClass());
	protected Member getLoginMember() {
		return (Member) request.getSession().getAttribute("member");
	}

	protected void checkLoginMember() {
		if(getMemberId()==null){
			try {
				response.sendRedirect("/user/login");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return;
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
	    
	protected Long getMemberId()  {
		if(getLoginMember()!=null){
			return getLoginMember().getId();
		}
		return null;
	}

}
