package com.dingdong.aop;

/**
 * @Title: ClassFilter
 * @Description:
 * @Author xu
 * @Date 2019/3/21 14:57
 * @Version 1.0
 * @Copyright 2018 All Rights Reserved
 */
public interface ClassFilter {

    boolean matcher(Class targetClass);
}
