package com.dingdong.aop;

/**
 * @Title: Pointcut
 * @Description:
 * @Author xu
 * @Date 2019/3/21 14:56
 * @Version 1.0
 * @Copyright 2018 All Rights Reserved
 */
public interface Pointcut {

    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();

}
