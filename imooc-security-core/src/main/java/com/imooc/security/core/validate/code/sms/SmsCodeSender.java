package com.imooc.security.core.validate.code.sms;

/**
 * @program: imooc-security
 * @description:
 * @author: Neo.Wang
 * @create: 2018-03-20 21:50
 **/
public interface SmsCodeSender {
    void send(String mobile,String code);
}
