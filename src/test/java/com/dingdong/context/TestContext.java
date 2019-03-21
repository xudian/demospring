package com.dingdong.context;

import com.dingdong.base.BaseTest;
import com.dingdong.service.FirstService;
import org.junit.Test;

/**
 * @Title: TestContext
 * @Description:
 * @Author xu
 * @Date 2019/3/21 09:53
 * @Version 1.0
 * @Copyright 2018 All Rights Reserved
 */
public class TestContext extends BaseTest {

    @Test
    public void test() {
        try {
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
            FirstService firstService = (FirstService)applicationContext.getBean("service");
            firstService.sayHello();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
