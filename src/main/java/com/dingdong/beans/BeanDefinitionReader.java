package com.dingdong.beans;

/**
 * @Title: BeanDefinitionReader
 * @Description:
 * @Author xu
 * @Date 2019/3/20 13:54
 * @Version 1.0
 * @Copyright 2018 All Rights Reserved
 */
public interface BeanDefinitionReader {

    void loadBeanDefinitions(String location) throws Exception;
}
