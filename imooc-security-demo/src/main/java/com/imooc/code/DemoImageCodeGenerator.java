package com.imooc.code;

import com.imooc.security.core.validate.code.image.ImageCode;
import com.imooc.security.core.validate.code.ValidateCodeGenerator;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @program: imooc-security
 * @description:
 * @author: Neo.Wang
 * @create: 2018-03-19 22:40
 **/
//@Component("imageCodeGenerator")
public class DemoImageCodeGenerator implements ValidateCodeGenerator{
    @Override
    public ImageCode generate(ServletWebRequest request) {
        System.out.println("自己配置的图形验证码");
        return null;
    }
}
