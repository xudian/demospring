package com.dingdong.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: TargetInterceptor
 * @Description:
 * @Author xu
 * @Date 2019/3/21 11:42
 * @Version 1.0
 * @Copyright 2018 All Rights Reserved
 */
public class TargetInterceptor implements MethodInterceptor {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        long time = System.nanoTime();
        logger.info("Invocation of Method {} start", methodInvocation.getMethod().getName());
        Object proceed = methodInvocation.proceed();
        logger.info("Invocation of Method {} end tasks:{}", methodInvocation.getMethod().getName(),System.nanoTime() - time);
        return proceed;
    }
}
