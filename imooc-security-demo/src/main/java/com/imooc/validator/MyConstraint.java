package com.imooc.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//申明此注解可以注解到什么地方(比如:方法，属性...)
@Target({ElementType.METHOD,ElementType.FIELD})
//注解执行时间(比如:运行时)
@Retention(RetentionPolicy.RUNTIME)
//关于校验的注解，validatedBy申明此自定义注解类的校验逻辑由那个类去执行
@Constraint(validatedBy = MyConstraintValidator.class)
public @interface MyConstraint {
    String message();

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
