package com.dingdong.context;

import com.dingdong.beans.BeanDefinition;
import com.dingdong.beans.factory.AbstractBeanFactory;
import com.dingdong.beans.factory.AutowireCapableBeanFactory;
import com.dingdong.beans.io.ResourceLoader;
import com.dingdong.beans.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * @Title: ClassPathXmlApplicationContext
 * @Description:
 * @Author xu
 * @Date 2019/3/21 09:24
 * @Version 1.0
 * @Copyright 2018 All Rights Reserved
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

    private String configLocation;

    public ClassPathXmlApplicationContext(AbstractBeanFactory abstractBeanFactory, String configLocation) throws Exception {
        super(abstractBeanFactory);
        this.configLocation = configLocation;
        fresh();
    }

    public ClassPathXmlApplicationContext(String configLocation) throws Exception {
        this(new AutowireCapableBeanFactory(),configLocation);
    }

    @Override
    public void loadBeanDefinitions() throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions(configLocation);
        if (!xmlBeanDefinitionReader.getRegistry().isEmpty()) {
            for (Map.Entry<String, BeanDefinition> entry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
                beanFactory.registerBeanDefinition(entry.getKey(),entry.getValue());
            }
        }

    }
}
