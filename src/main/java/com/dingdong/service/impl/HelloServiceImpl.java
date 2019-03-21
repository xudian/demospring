package com.dingdong.service.impl;

import com.dingdong.service.HelloService;
import com.dingdong.service.SecondService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: HelloServiceImpl
 * @Description:
 * @Author xu
 * @Date 2019/3/21 11:50
 * @Version 1.0
 * @Copyright 2018 All Rights Reserved
 */
public class HelloServiceImpl implements HelloService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private String text;

    private SecondService secondService;

    public void sayHello() {

        logger.info("helloService first request!");
        logger.info("helloService.text:{}",text);
        if (secondService != null) {
            secondService.sayWelcome(text);
        } else {
            logger.error("secondService注入HelloService失败");
        }

    }
}
