package com.dingdong.aop;

/**
 * @Title: TargetSource
 * @Description: 被代理的对象
 * @Author xu
 * @Date 2019/3/21 11:11
 * @Version 1.0
 * @Copyright 2018 All Rights Reserved
 */
public class TargetSource {

    private Class<?>[] targetClass;

    private Object target;

    public TargetSource(Object target, Class<?>... targetClass) {
        this.targetClass = targetClass;
        this.target = target;
    }

    public Class<?>[] getTargetClass() {
        return targetClass;
    }

    public Object getTarget() {
        return target;
    }
}
