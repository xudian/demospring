package com.dingdong.aop;

import java.lang.reflect.Method;

/**
 * @Title: MethodMatcher
 * @Description:
 * @Author xu
 * @Date 2019/3/21 14:58
 * @Version 1.0
 * @Copyright 2018 All Rights Reserved
 */
public interface MethodMatcher {

    boolean matches(Method method, Class targetClass);
}
