package com.imooc.web.async;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;

/**
 * @program: imooc-security
 * @description:
 * @author: Neo.Wang
 * @create: 2018-03-11 21:45
 **/
@RestController
public class AsyncController {
    @Autowired
    private MockQueue mockQueue;
    @Autowired
    private DeferredResultHolder deferredResultHolder;
    private Logger logger = LoggerFactory.getLogger(getClass());
    @GetMapping("/order")
    public DeferredResult<String> order() throws Exception {
        logger.info("主线程开始");
        String orderNum = RandomStringUtils.randomNumeric(8);
        mockQueue.setPlaceOrder(orderNum);
        //DeferredResult将线程的处理结果放到里面由我们写的程序控制返回，控制器可以从不同的线程异步产生返回值，可以实现两个完全不相干的线程间的通信。
        DeferredResult<String> result = new DeferredResult<String>();
        deferredResultHolder.getMap().put(orderNum,result);
        //runnable线程的简单事例
//        Callable<String> result = new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                logger.info("副线程开始");
//                Thread.sleep(1000);
//                logger.info("副线程返回");
//                return "success";
//            }
//        };
        logger.info("主线程返回");
        return result;
    }
}
