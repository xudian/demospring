package com.dingdong.aop;

/**
 * @Title: AbstractAopProxy
 * @Description:
 * @Author xu
 * @Date 2019/3/25 15:04
 * @Version 1.0
 * @Copyright 2018 All Rights Reserved
 */
public abstract class AbstractAopProxy implements AopProxy {

    protected AdvisedSupport advised;

    public AbstractAopProxy(AdvisedSupport advised) {
        this.advised = advised;
    }
}
