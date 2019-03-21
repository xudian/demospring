package com.dingdong.beans.factory;

import com.dingdong.beans.BeanDefinition;
import com.dingdong.beans.BeanReference;
import com.dingdong.beans.PropertyValue;

import java.lang.reflect.Field;

/**
 * @Title: AutowireCapableBeanFactory
 * @Description:
 * @Author xu
 * @Date 2019/3/20 11:44
 * @Version 1.0
 * @Copyright 2018 All Rights Reserved
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition)  {
        Object bean = null;
        try {
            bean = createBeanInstance(beanDefinition);
            beanDefinition.setBean(bean);
            applyPropertyValues(bean,beanDefinition);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition) throws Exception {
        return beanDefinition.getBeanClass().newInstance();
    }

    protected void applyPropertyValues(Object bean, BeanDefinition mbd) throws Exception {
        if (mbd.getPropertyValues() != null && mbd.getPropertyValues().getPropertyValueList().size() > 0) {
            for (PropertyValue propertyValue : mbd.getPropertyValues().getPropertyValueList()) {
                Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
                declaredField.setAccessible(true);
                Object value = propertyValue.getValue();
                if (value instanceof BeanReference) {
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getName());
                }
                declaredField.set(bean, value);
            }
        }
    }


}
