package com.dingdong.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: SecondService
 * @Description:
 * @Author xu
 * @Date 2019/3/20 17:45
 * @Version 1.0
 * @Copyright 2018 All Rights Reserved
 */
public class SecondService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public void sayWelcome(String text){
        logger.info("输入的文本信息为:{}",text);
    }
}
