package com.dingdong.beans;

/**
 * @Title: BeanPostProcessor
 * @Description:
 * @Author xu
 * @Date 2019/3/22 10:06
 * @Version 1.0
 * @Copyright 2018 All Rights Reserved
 */
public interface BeanPostProcessor {

    Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception;

    Object postProcessAfterInitialization(Object bean, String beanName) throws Exception;
}
