package com.imooc.security.core.properties;

/**
 * @program: imooc-security
 * @description: 图形验证码的配置类
 * @author: Neo.Wang
 * @create: 2018-03-19 21:12
 **/
public class ImageCodeProperties extends SmsCodeProperties{
    private int width = 67;
    private int height = 23;

    public ImageCodeProperties(){
        setLength(4);
    }
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
