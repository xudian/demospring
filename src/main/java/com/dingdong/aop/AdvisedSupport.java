package com.dingdong.aop;

import org.aopalliance.intercept.MethodInterceptor;

/**
 * @Title: AdvisedSupport
 * @Description: 代理相关的元素
 * @Author xu
 * @Date 2019/3/21 11:08
 * @Version 1.0
 * @Copyright 2018 All Rights Reserved
 */
public class AdvisedSupport {

    private TargetSource targetSource;

    private MethodInterceptor methodInterceptor;

    public TargetSource getTargetSource() {
        return targetSource;
    }

    public void setTargetSource(TargetSource targetSource) {
        this.targetSource = targetSource;
    }

    public MethodInterceptor getMethodInterceptor() {
        return methodInterceptor;
    }

    public void setMethodInterceptor(MethodInterceptor methodInterceptor) {
        this.methodInterceptor = methodInterceptor;
    }
}
