package com.imooc.service.imp;

import com.imooc.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * @program: imooc-security
 * @description:
 * @author: Neo.Wang
 * @create: 2018-03-11 16:06
 **/
@Service
public class HelloServiceImp implements HelloService{

    @Override
    public String greeting(String name) {
        System.out.println("greeting");
        return "hello" + name;
    }
}
