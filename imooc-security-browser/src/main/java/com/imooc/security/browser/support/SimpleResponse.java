package com.imooc.security.browser.support;

/**
 * @program: imooc-security
 * @description: 返回状态的包装类
 * @author: Neo.Wang
 * @create: 2018-03-18 13:56
 **/
public class SimpleResponse {
    private Object content;

    public SimpleResponse(Object content) {
        this.content = content;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
