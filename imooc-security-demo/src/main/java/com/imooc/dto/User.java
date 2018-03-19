package com.imooc.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.imooc.validator.MyConstraint;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.Past;
import java.util.Date;

/**
 * @program: imooc-security
 * @description:
 * @author: Neo.Wang
 * @create: 2018-03-10 16:40
 **/
public class User {
    public interface UserSimpleView{};
    public interface  UserDetailView extends UserSimpleView{};

    private String id;
    //自定义的校验注解
    //由于自定义注解的message方法没有给default值，所以在此处必须给message赋值
    @MyConstraint(message = "这是一个测试校验")
    private String username;
    //不为空的验证
    @NotBlank(message = "密码不能为空")
    private String password;
    //验证时间必须是一个过去值
    @Past(message = "生日必须是过去的时间")
    private Date birthday;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @JsonView(UserSimpleView.class)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonView(UserDetailView.class)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
