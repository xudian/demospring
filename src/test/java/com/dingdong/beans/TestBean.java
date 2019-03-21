package com.dingdong.beans;

import com.dingdong.base.BaseTest;
import com.dingdong.beans.factory.AbstractBeanFactory;
import com.dingdong.beans.factory.AutowireCapableBeanFactory;
import com.dingdong.beans.io.ResourceLoader;
import com.dingdong.beans.xml.XmlBeanDefinitionReader;
import com.dingdong.service.FirstService;
import org.junit.Test;

import java.util.Map;

/**
 * @Title: TestBean
 * @Description:
 * @Author xu
 * @Date 2019/3/20 11:46
 * @Version 1.0
 * @Copyright 2018 All Rights Reserved
 */
public class TestBean extends BaseTest {

    @Test
    public void test() {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        try {
            xmlBeanDefinitionReader.loadBeanDefinitions("spring.xml");

            AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
            if (!xmlBeanDefinitionReader.getRegistry().isEmpty()) {
                for (Map.Entry<String,BeanDefinition> entry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
                    beanFactory.registerBeanDefinition(entry.getKey(),entry.getValue());
                }
            }

            beanFactory.preInstantiateSingletons();
            FirstService firstService = (FirstService) beanFactory.getBean("service");
            firstService.sayHello();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
