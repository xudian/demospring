package com.dingdong.beans.factory;

import com.dingdong.beans.BeanDefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Title: AbstractBeanFactory
 * @Description:
 * @Author xu
 * @Date 2019/3/20 11:41
 * @Version 1.0
 * @Copyright 2018 All Rights Reserved
 */
public abstract class AbstractBeanFactory implements BeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

    private final List<String> beanDefinitionNames = new ArrayList<String>();

    public Object getBean(String beanName) {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) {
            throw new IllegalArgumentException("No bean named " + beanName + " is defined");
        }
        Object bean = beanDefinition.getBean();
        if (bean == null) {
            bean = doCreateBean(beanDefinition);
        }
        return bean;
    }

    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        if (!beanDefinitionNames.contains(beanName)) {
            beanDefinitionMap.put(beanName,beanDefinition);
            beanDefinitionNames.add(beanName);
        }
    }

    public void preInstantiateSingletons() throws Exception {
        if (beanDefinitionNames.size() > 0) {
            for (String beanName : beanDefinitionNames) {
                getBean(beanName);
            }
        }
    }

    /**
     * @Description: 初始化bean
     * @params: [beanDefinition]
     * @return: java.lang.Object
     * @date: 2019/3/20 11:44
     */
    protected abstract Object doCreateBean(BeanDefinition beanDefinition);
}
