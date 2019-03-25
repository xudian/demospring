package com.dingdong.aop;

/**
 * @Title: ProxyFactory
 * @Description:
 * @Author xu
 * @Date 2019/3/25 15:07
 * @Version 1.0
 * @Copyright 2018 All Rights Reserved
 */
public class ProxyFactory extends AdvisedSupport implements AopProxy {

    @Override
    public Object getProxy() {
        return createAopProxy().getProxy();
    }

    protected final AopProxy createAopProxy() {
//        return new Cglib2AopProxy(this);
        return new JdkDynamicAopProxy(this);
    }
}
