package com.imooc.security.core.validate.code;


import org.springframework.security.core.AuthenticationException;

/**
 * @program: imooc-security
 * @description: 图片验证的自定义异常
 * @author: Neo.Wang
 * @create: 2018-03-18 21:10
 **/
public class ValidateCodeException extends AuthenticationException {

    private static final long serialVersionUID = -7285211528095468156L;

    public ValidateCodeException(String msg) {
        super(msg);
    }
}
