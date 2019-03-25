package com.dingdong.aop;

import com.dingdong.beans.factory.BeanFactory;

/**
 * @Title: BeanFactoryAware
 * @Description:
 * @Author xu
 * @Date 2019/3/22 10:01
 * @Version 1.0
 * @Copyright 2018 All Rights Reserved
 */
public interface BeanFactoryAware {

    void setBeanFactory(BeanFactory beanFactory);
}
