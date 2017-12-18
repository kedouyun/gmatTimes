package com.app.sys.vo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.slf4j.Logger;
import org.springframework.context.annotation.Configuration;
@Configuration  
public class MyTag extends TagSupport{

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String formName;
	
	@SuppressWarnings("unchecked")
	@Override
	public int doStartTag() throws JspException {
		 
		HttpServletRequest request = null;
		try {
			JspWriter out = pageContext.getOut();
			request = (HttpServletRequest) pageContext.getRequest();
			
			out.println("<input type=hidden name=pageNum />");
			
			if(name == null || "".equals(name)) {
//				log.info("name is null");
				name = "pageInfo";
			}
			
			// 分页方法后缀、解决当使用forName属性时、多个分页出错的bug。因为方法名称相同会调用最后一次创建的javascript代码、使前几次创建的方法失效
			String pageMethodSuffix = formName != null && !"".equals(formName) ? formName : "1";
			
			PageInfo pageInfo = (PageInfo) request.getAttribute(name);

			if(pageInfo == null) {
				return EVAL_BODY_INCLUDE;
			}
			List list = pageInfo.getList();
			
			if(list == null || list.size() < 0) {
				return EVAL_BODY_INCLUDE;
			}
			
			int pageNum = pageInfo.getPageNum();
			if(pageNum != 1) {
				int pageSize = pageInfo.getPageSize();
				int pageLast = pageInfo.getPageNum() - 1;
				out.print("<a href='javascript:void(0);' onclick=\"test"+pageMethodSuffix+"('1','"+pageSize +"')\">首页</a>");
				out.print("<a href='javascript:void(0);' onclick=\"test"+pageMethodSuffix+"('"+pageLast+"','"+pageSize +"')\">上一页</a>");
			}
			
			for (int i = pageInfo.getPageBegin(); i <= pageInfo.getPageEnd(); i++) {
				if(pageNum == i) {
					out.println("<a href='javascript:void(0);' onclick=\"test"+pageMethodSuffix+"('"+i+"','"+pageInfo.getPageSize()+"')\"><font color='#FF00FF'>"+i+"</font></a>");
				}else {
					out.println("<a href='javascript:void(0);' onclick=\"test"+pageMethodSuffix+"('"+i+"','"+pageInfo.getPageSize()+"')\">"+i+"</a>");
				}
				
			}
			
			int pageCount = pageInfo.getPageCount();
			if(pageNum != pageCount) {
				int pageSize = pageInfo.getPageSize();
				int pageNext = pageInfo.getPageNum() + 1;
				out.print("<a href='javascript:void(0);' onclick=\"test"+pageMethodSuffix+"('"+pageNext+"','"+pageSize +"')\">下一页</a>");
				out.print("<a href='javascript:void(0);' onclick=\"test"+pageMethodSuffix+"('"+pageCount+"','"+pageSize +"')\">末页</a>");
			}
			//String s = "页码："+pageInfo.getPageNum()+"/"+pageInfo.getPageCount()+"页&nbsp;&nbsp;共"+pageInfo.getRecordCount()+"条&nbsp;&nbsp;";
			out.print("共"+pageInfo.getRecordCount()+"条&nbsp;&nbsp;");
			out.print("每页<input type=text style='height: 16px;font-size:11;width:35px;' size=2 name=pageSize value="+pageInfo.getPageSize()+" onchange='initPageSize();'>条");
			out.println();
			out.println("<script type='text/javascript'>");
			out.println(	"function test"+pageMethodSuffix+"(pn,ps) {");
			if(formName != null && !"".equals(formName)) {
				out.println(	"var f1 = document.forms[\""+formName+"\"];");
			}else {
				out.println(	"var f1 = document.forms[0];");
			}
			out.println(		"f1.pageNum.value=pn;");
			out.println(		"f1.pageSize.value=ps;");
			out.println(		"f1.submit();");
			out.println(	"}");
			
			out.println("function initPageSize() {");
			if(formName != null && !"".equals(formName)) {
				out.println(	"var ff = document.forms[\""+formName+"\"];");
			}else {
				out.println(	"var ff = document.forms[0];");
			}
			out.println("ff.submit();");
			out.println("}");
			out.println("</script>");
			
		} catch (Exception e) {
//			log.error(e.getMessage(), e);
			request.setAttribute("message", e.getMessage());
		}
		
		
		return EVAL_BODY_INCLUDE;
	}
	
	@Override
	public int doEndTag() throws JspException {
		
		return super.doEndTag();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

}
