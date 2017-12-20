package com.app.config.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author heguoliang
 * @Description: TODO(api interceptor)
 * @date 2017-9-27 14:41
 */
@Component
public class ApiInterceptor extends HandlerInterceptorAdapter {
	@Value("${system_url}")
   String system_url;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //接口方法如果没有Login注解，则不需要校验token
        Login annotation;
        if(handler instanceof HandlerMethod) {
            annotation = ((HandlerMethod) handler).getMethodAnnotation(Login.class);
            if(annotation!=null){
            	 if(request.getSession().getAttribute("member")==null){
            		 response.sendRedirect(system_url+"/user/login");
            		 return false;
            	 }
            }
        
        }else{
            return true;
        }

        if(annotation == null){
            return true;
        }

//        //获取token
//        String token = request.getHeader(jwtUtils.getHeader());
//        if(StringUtils.isBlank(token)){
//            token = request.getParameter(jwtUtils.getHeader());
//        }
//
//        //校验token
//        if(StringUtils.isBlank(token)){
//            throw new SbedException(jwtUtils.getHeader() + "不能为空", HttpStatus.UNAUTHORIZED.value());
//        }
//        Claims claims = jwtUtils.getClaimByToken(token);
//        if(claims == null || jwtUtils.isTokenExpired(claims.getExpiration())){
//            throw new SbedException(jwtUtils.getHeader() + "已经失效", HttpStatus.UNAUTHORIZED.value());
//        }

        return true;
    }

}
