package com.dingdong.context;

import com.dingdong.beans.BeanPostProcessor;
import com.dingdong.beans.factory.AbstractBeanFactory;

import java.util.List;

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

    public AbstractApplicationContext(AbstractBeanFactory beanFactory) throws Exception {
        this.beanFactory = beanFactory;
    }

    protected abstract void loadBeanDefinitions() throws Exception;

    protected void refresh() throws Exception {
        beanFactory.preInstantiateSingletons();
    }

    protected  void fresh() throws Exception {
        loadBeanDefinitions();
        registerBeanPostProcessors(beanFactory);
        refresh();
    }

    public Object getBean(String beanName) {
        return beanFactory.getBean(beanName);
    }

    protected void registerBeanPostProcessors(AbstractBeanFactory beanFactory) {
        List beanPostProcessors = beanFactory.getBeanByType(BeanPostProcessor.class);
        for (Object beanPostProcessor : beanPostProcessors) {
            beanFactory.addBeanPostProcessor((BeanPostProcessor) beanPostProcessor);
        }
    }
}
