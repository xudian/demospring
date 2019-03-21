package com.dingdong.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: FirstService
 * @Description:
 * @Author xu
 * @Date 2019/3/20 11:03
 * @Version 1.0
 * @Copyright 2018 All Rights Reserved
 */
public class FirstService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private String text;

    private SecondService secondService;

    public void sayHello() {
        logger.info("hello; first request!");
        logger.info("-----text:{}",text);
        if (secondService != null) {
            secondService.sayWelcome(text);
        } else {
            logger.error("secondService注入失败");
        }
    }


}
