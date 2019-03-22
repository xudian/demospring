package com.dingdong.aop;

/**
 * @Title: PointcutAdvisor
 * @Description:
 * @Author xu
 * @Date 2019/3/21 15:02
 * @Version 1.0
 * @Copyright 2018 All Rights Reserved
 */
public interface PointcutAdvisor extends Advisor  {

    Pointcut getPointCut();
}
