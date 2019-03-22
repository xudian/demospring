package com.dingdong.aop;

import org.aopalliance.aop.Advice;

/**
 * @Title: Advisor
 * @Description:
 * @Author xu
 * @Date 2019/3/21 15:01
 * @Version 1.0
 * @Copyright 2018 All Rights Reserved
 */
public interface Advisor {

    Advice getAdvice();
}
