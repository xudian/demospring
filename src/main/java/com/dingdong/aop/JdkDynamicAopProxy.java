package com.dingdong.aop;

import org.aopalliance.intercept.MethodInterceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Title: JdkDynamicAopProxy
 * @Description: 基于jdk的动态代理
 * @Author xu
 * @Date 2019/3/21 11:26
 * @Version 1.0
 * @Copyright 2018 All Rights Reserved
 */
public class JdkDynamicAopProxy extends AbstractAopProxy implements InvocationHandler {

    public JdkDynamicAopProxy(AdvisedSupport advised) {
        super(advised);
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(getClass().getClassLoader(),advised.getTargetSource().getTargetClass().getInterfaces(),this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MethodInterceptor methodInterceptor = advised.getMethodInterceptor();
        if (advised != null && advised.getMethodMatcher().matches(method,advised.getTargetSource().getTargetClass())) {
            return methodInterceptor.invoke(new ReflectiveMethodInvocation(advised.getTargetSource().getTarget(),method,args));
        }
        return method.invoke(advised.getTargetSource().getTarget(),args);
    }
}
