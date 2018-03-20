package com.imooc.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.ServletRequest;

/**
 * @program: imooc-security
 * @description:
 * @author: Neo.Wang
 * @create: 2018-03-19 22:13
 **/
public interface ValidateCodeGenerator {
    ValidateCode generate(ServletWebRequest request);
}
