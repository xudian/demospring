package com.dingdong.service.impl;

import com.dingdong.service.SecondService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: SecondServiceImpl
 * @Description:
 * @Author xu
 * @Date 2019/3/25 11:21
 * @Version 1.0
 * @Copyright 2018 All Rights Reserved
 */
public class SecondServiceImpl implements SecondService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void sayWelcome(String text) {
        logger.info("SecondServiceImpl 输出文本信息为:{}",text);
    }
}
