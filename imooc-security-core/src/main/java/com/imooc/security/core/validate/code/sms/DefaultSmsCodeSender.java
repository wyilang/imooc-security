package com.imooc.security.core.validate.code.sms;

/**
 * @program: imooc-security
 * @description:
 * @author: Neo.Wang
 * @create: 2018-03-20 21:52
 **/
public class DefaultSmsCodeSender implements SmsCodeSender{
    @Override
    public void send(String mobile, String code) {
        System.out.println("向手机:" + mobile + "发送短信验证码:" + code);
    }
}
