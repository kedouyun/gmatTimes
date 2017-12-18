package com.app.config;

import javax.servlet.DispatcherType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.app.common.utils.FileUtils;
import com.app.common.xss.XssFilter;
import com.app.config.login.ApiInterceptor;

/**
 * @author heguoliang
 * @Description: TODO(web配置)
 * @date 2017-6-23 15:07
 */
@Configuration
@EnableAutoConfiguration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private ApiInterceptor apiInterceptor;

    @Value("${sys.swagger.open:#{false}}")
    private boolean swaggerOpen;

	@Value("${upload_address}")  
	private String upload_address;
	
    @Bean
	public LoginInterceptor localInterceptor() {
        return new LoginInterceptor();
    }
    @Bean
    public MangerInterceptor mangerInterceptor() {
    	return new MangerInterceptor();
    }
    
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	 registry.addResourceHandler("/images/**").addResourceLocations("file:"+upload_address);
    	//映射上传文件的地址
        registry.addResourceHandler("/uploadFile/**").addResourceLocations("file:"+FileUtils.getTempPath());
        
        //映射swagger
        if(swaggerOpen){
            registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
            registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        }
        super.addResourceHandlers(registry);
    }
    
//    @AssertFalse 校验false
//    @AssertTrue 校验true
//    @DecimalMax(value=,inclusive=) 小于等于value，
//    inclusive=true,是小于等于
//    @DecimalMin(value=,inclusive=) 与上类似
//    @Max(value=) 小于等于value
//    @Min(value=) 大于等于value
//    @NotNull  检查Null
//    @Past  检查日期
//    @Pattern(regex=,flag=)  正则
//    @Size(min=, max=)  字符串，集合，map限制大小
//    @Valid 对po实体类进行校验
//    @NotNull(message = "用户名称不能为空") 
//    @Max(value = 100, message = "年龄不能大于100岁") 
//    @Min(value= 18 ,message= "必须年满18岁！" )  
//     @AssertTrue(message = "bln4 must is true")
//     
//     @AssertFalse(message = "blnf must is falase")
//    @DecimalMax(value="100",message="decim最大值是100")
//    DecimalMin(value="100",message="decim最小值是100")
//    @NotNull(message = "身份证不能为空") 
//       @Pattern(regexp="^(\\d{18,18}|\\d{15,15}|(\\d{17,17}[x|X]))$", message="身份证格式错误")
    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor(){
     return new MethodValidationPostProcessor();
    }
//    @Bean
//    public FilterRegistrationBean shiroFilterRegistration() {
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setFilter(new DelegatingFilterProxy("shiroFilter"));
//        //该值缺省为false，表示生命周期由SpringApplicationContext管理，设置为true则表示由ServletContainer管理
//        registration.addInitParameter("targetFilterLifecycle", "true");
//        registration.setEnabled(true);
//        registration.setOrder(Integer.MAX_VALUE - 1);
//        registration.addUrlPatterns("/*");
//        return registration;
//    }

    //配置xssFilter
    @Bean
    public FilterRegistrationBean xssFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setDispatcherTypes(DispatcherType.REQUEST);
        registration.setFilter(new XssFilter("/sys/"));
        registration.addUrlPatterns("/*");
        registration.setName("xssFilter");
        registration.setOrder(Integer.MAX_VALUE);
        return registration;
    }

    //添加api interceptor
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(apiInterceptor).addPathPatterns("/**");
        registry.addInterceptor(mangerInterceptor()).addPathPatterns("/**/**.do");
        //registry.addInterceptor(localInterceptor()).addPathPatterns("/**/**");
    }
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/index");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers(registry);
    }
}