package com.dingdong.context;

import com.dingdong.beans.factory.AbstractBeanFactory;

/**
 * @Title: AbstractApplicationContext
 * @Description:
 * @Author xu
 * @Date 2019/3/21 09:17
 * @Version 1.0
 * @Copyright 2018 All Rights Reserved
 */
public abstract class AbstractApplicationContext implements ApplicationContext {

    protected AbstractBeanFactory beanFactory;

    public AbstractApplicationContext(AbstractBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public void refresh() throws Exception {}

    public Object getBean(String beanName) {
        return beanFactory.getBean(beanName);
    }
}
