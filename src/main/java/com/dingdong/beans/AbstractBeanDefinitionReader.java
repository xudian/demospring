package com.dingdong.beans;

import com.dingdong.beans.io.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title: AbstractBeanDefinitionReader
 * @Description:
 * @Author xu
 * @Date 2019/3/20 13:55
 * @Version 1.0
 * @Copyright 2018 All Rights Reserved
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    private Map<String, BeanDefinition> registry;

    private ResourceLoader resourceLoader;


    protected AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
        this.registry = new HashMap<String, BeanDefinition>();
        this.resourceLoader = resourceLoader;
    }


    public Map<String, BeanDefinition> getRegistry() {
        return registry;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
