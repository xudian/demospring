package com.dingdong.beans.factory;

/**
 * @Title: BeanFactory
 * @Description:
 * @Author xu
 * @Date 2019/3/20 11:36
 * @Version 1.0
 * @Copyright 2018 All Rights Reserved
 */
public interface BeanFactory {

    Object getBean(String beanName);

}
