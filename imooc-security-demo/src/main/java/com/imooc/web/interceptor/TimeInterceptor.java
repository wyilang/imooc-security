package com.imooc.web.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @program: imooc-security
 * @description:记录服务处理时间的拦截器(由Spring提供  )
 * @author: Neo.Wang
 * @create: 2018-03-11 18:24
 **/
@Component
public class TimeInterceptor implements HandlerInterceptor{

    //控制器方法调用之前会被调用
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle");
        System.out.println(((HandlerMethod)handler).getBean().getClass().getName());
        System.out.println(((HandlerMethod)handler).getMethod().getName());
        request.setAttribute("startTime",new Date().getTime());
        return true;
    }

    //控制器方法处理之后会被调用，如果控制器方法抛出异常则此方法不会被调用
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
        long startTime = (long) request.getAttribute("startTime");
        System.out.println("time interceptor 耗时：" + (new Date().getTime() - startTime));
    }

    //永远会被执行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion ");
        long startTime = (long) request.getAttribute("startTime");
        System.out.println("time interceptor 耗时：" + (new Date().getTime() - startTime));
        System.out.println("ex is:" + ex);
    }
}
