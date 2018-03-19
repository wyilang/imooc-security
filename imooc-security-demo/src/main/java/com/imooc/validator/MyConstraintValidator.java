package com.imooc.validator;

import com.imooc.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @program: imooc-security
 * @description:
 * @author: Neo.Wang
 * @create: 2018-03-11 15:56
 **/
//接口中泛型的第一个参数代表自定义的校验注解类，第二个参数代表该注解属于什么类型的注解
public class MyConstraintValidator implements ConstraintValidator<MyConstraint,Object> {
    @Autowired
    private HelloService helloService;
    @Override
    public void initialize(MyConstraint constraintAnnotation) {
        System.out.println("my validator init");
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        helloService.greeting("tom");
        System.out.println(value);
        return false;
    }
}
