package com.imooc.web.config;

import com.imooc.web.filter.TimeFilter;
import com.imooc.web.interceptor.TimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: imooc-security
 * @description:配置第三方的filter(使用第三方提供的类，没有@Component注解的时候)
 * @author: Neo.Wang
 * @create: 2018-03-11 18:10
 **/
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{

    @Autowired
    private TimeInterceptor timeInterceptor;

    /*自定义拦截器要起作用，必须要在一个配置类里继承WebMvcConfigurerAdapter，
    通过复写addInterceptors方法，把拦截器加入到配置里
    */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(timeInterceptor);
    }

    //处理异步的拦截器
    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        //处理Callable异步请求的拦截器
        configurer.registerCallableInterceptors();
        //处理DeferredResult异步请求的拦截器
        configurer.registerDeferredResultInterceptors();
    }

    //FilterRegistrationBean注册一个filter的bean类似于xml里面配置的filter标签
    @Bean
    public FilterRegistrationBean timeFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        TimeFilter timeFilter = new TimeFilter();
        registrationBean.setFilter(timeFilter);
        List<String> urls = new ArrayList<String>();
        urls.add("/*");
        registrationBean.setUrlPatterns(urls);
        return registrationBean;
    }

}
