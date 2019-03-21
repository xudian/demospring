package com.dingdong.beans;

/**
 * @Title: BeanDefinition
 * @Description:
 * @Author xu
 * @Date 2019/3/20 11:35
 * @Version 1.0
 * @Copyright 2018 All Rights Reserved
 */
public class BeanDefinition {

    private Object bean;

    private Class beanClass;

    private String beanName;

    private PropertyValues propertyValues;

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public Class getBeanClass() {
        return beanClass;
    }


    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
        try {
            this.beanClass = Class.forName(beanName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
