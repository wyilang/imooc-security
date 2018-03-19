package com.imooc.web.controller;

import com.imooc.exception.UserNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: imooc-security
 * @description:
 * @author: Neo.Wang
 * @create: 2018-03-11 17:34
 **/
//此注解负责处理其他controller抛出的异常
@ControllerAdvice
public class ControllerExceptionHandler {
    //处理所有controller抛出的UserNotExistException异常
    @ExceptionHandler(UserNotExistException.class)
    //返回json
    @ResponseBody
    //返回http请求的状态码
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String,Object> handleUserNotExistException(UserNotExistException uex){
        Map<String,Object> exceptionResult = new HashMap<String, Object>();
        exceptionResult.put("id",uex.getId());
        exceptionResult.put("message",uex.getMessage());
        return exceptionResult;
    }
}
