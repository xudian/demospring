package com.dingdong.aop;

import com.dingdong.beans.BeanPostProcessor;
import com.dingdong.beans.factory.AbstractBeanFactory;
import com.dingdong.beans.factory.BeanFactory;
import org.aopalliance.intercept.MethodInterceptor;

import java.util.List;

/**
 * @Title: AspectJAwareAdvisorAutoProxyCreator
 * @Description:
 * @Author xu
 * @Date 2019/3/22 10:14
 * @Version 1.0
 * @Copyright 2018 All Rights Reserved
 */
public class AspectJAwareAdvisorAutoProxyCreator implements BeanPostProcessor,BeanFactoryAware {

    private AbstractBeanFactory beanFactory;

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = (AbstractBeanFactory) beanFactory;
    }

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception {
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws Exception {
        if (bean instanceof AspectJExpressionPointcutAdvisor) {
            return bean;
        }
        if (bean instanceof MethodInterceptor) {
            return bean;
        }
        List<AspectJExpressionPointcutAdvisor> advisors = beanFactory.getBeanByType(AspectJExpressionPointcutAdvisor.class);
        if (advisors != null && advisors.size() > 0) {
            for (AspectJExpressionPointcutAdvisor advisor :advisors) {
                advisor.setExpression(advisor.getExpression());
                if (advisor.getPointcut().getClassFilter().matcher(bean.getClass())) {
                    AdvisedSupport advisedSupport = new AdvisedSupport();
                    advisedSupport.setMethodMatcher(advisor.getPointcut().getMethodMatcher());
                    advisedSupport.setMethodInterceptor((MethodInterceptor) advisor.getAdvice());
                    TargetSource targetSource = new TargetSource(bean,bean.getClass());
                    advisedSupport.setTargetSource(targetSource);
                    return new JdkDynamicAopProxy(advisedSupport).getProxy();
                }
            }
        }
        return null;
    }

 }
