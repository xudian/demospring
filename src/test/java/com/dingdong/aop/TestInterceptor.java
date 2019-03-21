package com.dingdong.aop;

import com.dingdong.base.BaseTest;
import com.dingdong.context.ClassPathXmlApplicationContext;
import com.dingdong.interceptor.TargetInterceptor;
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
        helloService.sayHello();

        // FirstService in Aop
        // 1、设置被代理对象(Joinpoint)
        AdvisedSupport advised = new AdvisedSupport();
        TargetSource targetSource = new TargetSource(HelloService.class,helloService);
        advised.setTargetSource(targetSource);

        // 2、设置拦截器(Advice)
        TargetInterceptor interceptor = new TargetInterceptor();
        advised.setMethodInterceptor(interceptor);

        // 3、创建代理(Proxy)
        JdkDynamicAopProxy proxy = new JdkDynamicAopProxy(advised);
        HelloService helloServiceProxy = (HelloService) proxy.getProxy();
        helloServiceProxy.sayHello();
    }
}
