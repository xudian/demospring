package com.dingdong.aop;

import com.dingdong.base.BaseTest;
import com.dingdong.context.ClassPathXmlApplicationContext;
import com.dingdong.interceptor.TargetInterceptor;
import com.dingdong.service.FirstService;
import com.dingdong.service.HelloService;
import org.junit.Test;

/**
 * @Title: TestInterceptor
 * @Description:
 * @Author xu
 * @Date 2019/3/21 11:37
 * @Version 1.0
 * @Copyright 2018 All Rights Reserved
 */
public class TestInterceptor extends BaseTest {

    @Test
    public void test() throws Exception{
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        HelloService helloService = (HelloService)applicationContext.getBean("helloService");

        // FirstService in Aop
        // 1、设置被代理对象(Joinpoint)
        AdvisedSupport advised = new AdvisedSupport();
        TargetSource targetSource = new TargetSource(helloService,HelloService.class);
        advised.setTargetSource(targetSource);

        // 2、设置拦截器(Advice)
        TargetInterceptor interceptor = new TargetInterceptor();
        advised.setMethodInterceptor(interceptor);

        String expression = "execution(* com.dingdong.service..*.*(..))";
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(expression);

        advised.setMethodMatcher(pointcut.getMethodMatcher());

        // 3、创建代理(Proxy)
        JdkDynamicAopProxy proxy = new JdkDynamicAopProxy(advised);
        HelloService helloServiceProxy = (HelloService) proxy.getProxy();
        logger.info("proxyName:{}", helloService.getClass().getSimpleName());
        helloServiceProxy.sayHello();
    }


    @Test
    public void testPointcut() throws Exception {
        String expression = "execution(* com.dingdong.service..*.*(..))";
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(expression);
        boolean matches = pointcut.getMethodMatcher().matches(FirstService.class.getDeclaredMethod("sayHello"),FirstService.class);
        logger.info("matches:{}",matches);
    }

    @Test
    public void testProxy() {
        try {
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
            HelloService helloService = (HelloService) applicationContext.getBean("helloService");
            helloService.sayHello();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
