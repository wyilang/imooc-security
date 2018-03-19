package com.imooc.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * @program: imooc-security
 * @description:
 * @author: Neo.Wang
 * @create: 2018-03-10 16:57
 **/
public class UserQueryCondition {
    private String username;
    //swagger对属性说明的注解
    @ApiModelProperty(value = "用户年龄起始值")
    private int age;
    @ApiModelProperty(value = "用户年龄终止值")
    private int ageTo;
    private String xxx;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAgeTo() {
        return ageTo;
    }

    public void setAgeTo(int ageTo) {
        this.ageTo = ageTo;
    }

    public String getXxx() {
        return xxx;
    }

    public void setXxx(String xxx) {
        this.xxx = xxx;
    }
}
