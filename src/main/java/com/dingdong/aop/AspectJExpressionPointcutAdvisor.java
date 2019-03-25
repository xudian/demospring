package com.dingdong.aop;

import org.aopalliance.aop.Advice;

/**
 * @Title: AspectJExpressionPointcutAdvisor
 * @Description:
 * @Author xu
 * @Date 2019/3/21 15:47
 * @Version 1.0
 * @Copyright 2018 All Rights Reserved
 */
public class AspectJExpressionPointcutAdvisor implements Advisor {

    private AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();

    private Advice advice;

    private String expression;

    public Advice getAdvice() {
        return advice;
    }

    public AspectJExpressionPointcut getPointcut() {
        return pointcut;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.pointcut.setExpression(expression);
    }
}
