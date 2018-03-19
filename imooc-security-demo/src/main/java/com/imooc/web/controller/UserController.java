package com.imooc.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.imooc.dto.User;
import com.imooc.dto.UserQueryCondition;
import com.imooc.exception.UserNotExistException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: imooc-security
 * @description:
 * @author: Neo.Wang
 * @create: 2018-03-10 16:36
 **/
@RestController
@RequestMapping("/user")
public class UserController {
    //@AuthenticationPrincipal获取登录信息里面的principal的部分
    @GetMapping("/me")
    public Object getCurrentUser(@AuthenticationPrincipal UserDetails userDetails){
        return userDetails;
        //Authentication authentication
        //return authentication;
        //获取登录信息,也可以像上面一样直接把Authentication定义在参数里由Spring自动去获取
        //return SecurityContextHolder.getContext().getAuthentication();
    }
    //@RequestMapping(value = "/user",method = RequestMethod.GET)
    @GetMapping
    //json返回视图显示的注解：1.使用接口来申明多个视图；2.在值对象的get方法上指定视图；3.在controller方法上指定视图
    @JsonView(User.UserSimpleView.class)
    //swagger的方法注解
    @ApiOperation(value = "用户查询服务")
    //单个传参数方式：@RequestParam(name = "username",required = false,defaultValue = "tom") String name
    //@PageableDefault此注解是spring自带的分页功能使用Spring-data操作数据库可以使用
    public List<User> query(UserQueryCondition condition, @PageableDefault(page = 2,size = 10,sort = "age.asc") Pageable pageable){
        System.out.println(ReflectionToStringBuilder.toString(condition, ToStringStyle.MULTI_LINE_STYLE));
        System.out.println(pageable.getPageSize());
        System.out.println(pageable.getPageNumber());
        System.out.println(pageable.getSort());
        List<User> users = new ArrayList<User>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }

    //id可以匹配正则表达式
    //@RequestMapping(value = "/user/{id:\\d+}",method = RequestMethod.GET)
    @GetMapping("/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    //@PathVariable String id
    //@ApiParam swagger对方法里参数说明的注解
    public User getInfo(@ApiParam(value = "用户ID") @PathVariable(name = "id") String idxx){
        //throw new RuntimeException("user not exist");
        //自定义异常类
        //throw new UserNotExistException(idxx);
        System.out.println("进入getInfo服务");
        User user = new User();
        user.setUsername("tom");
        user.setPassword("123456");
        return user;
    }

    @PostMapping
    public User create(@Valid @RequestBody User user, BindingResult errors){
        if(errors.hasErrors()){
            errors.getAllErrors().stream().forEach(error -> System.out.println(error.getDefaultMessage()));
        }
        System.out.println(ReflectionToStringBuilder.toString(user, ToStringStyle.MULTI_LINE_STYLE));
        user.setId("1");
        return user;
    }

    @PutMapping("/{id:\\d+}")
    public User update(@Valid @RequestBody User user, BindingResult errors){
        if(errors.hasErrors()){
            errors.getAllErrors().stream().forEach(error -> {
                //FieldError fieldError = (FieldError) error;
                //System.out.println(fieldError.getField() + " " + error.getDefaultMessage());
                System.out.println(error.getDefaultMessage());
            });
        }
        System.out.println(ReflectionToStringBuilder.toString(user, ToStringStyle.MULTI_LINE_STYLE));
        user.setId("1");
        return user;
    }

    @DeleteMapping("/{id:\\d+}")
    public void delete(@PathVariable String id){
        System.out.println(id);
    }
}
