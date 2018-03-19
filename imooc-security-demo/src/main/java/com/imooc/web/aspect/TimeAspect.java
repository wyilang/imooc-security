package com.imooc.web.aspect;

import com.sun.codemodel.internal.JForEach;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @program: imooc-security
 * @description:记录服务处理时间的切面(spring AOP)
 * @author: Neo.Wang
 * @create: 2018-03-11 19:01
 **/
@Aspect
@Component
public class TimeAspect {
    @Around("execution(* com.imooc.web.controller.UserController.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("time aspect start");
        //获取调用方法的参数
        Object[] args = proceedingJoinPoint.getArgs();
        for (Object arg : args){
            System.out.println("agr is" + arg);
        }
        long startTime = new Date().getTime();
        //返回值其实就是对应调用方法里面的返回值
        Object object = proceedingJoinPoint.proceed();
        System.out.println("time aspect 耗时：" + (new Date().getTime() - startTime));
        System.out.println("time aspect end");
        return object;
    }
}
