package com.imooc.security.core.properties;

/**
 * @program: imooc-security
 * @description:
 * @author: Neo.Wang
 * @create: 2018-03-18 14:07
 **/
public class BrowserProperties {
    //默认登录页
    private String loginPage = "/imooc-singIn.html";

    //跳转方式
    private LoginType loginType = LoginType.JSON;

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    public LoginType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }
}
