package com.imooc.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

public interface ValidateCodeProcessor {
    //校验码放入session时的前缀
    String SESSION_KEY_PREFIX = "SESSION_KEY_FOR_CODE_";

    //创建校验码
    void create(ServletWebRequest request)throws Exception;
}
