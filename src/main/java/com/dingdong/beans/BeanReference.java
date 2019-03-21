package com.dingdong.beans;

/**
 * @Title: BeanReference
 * @Description:
 * @Author xu
 * @Date 2019/3/20 16:50
 * @Version 1.0
 * @Copyright 2018 All Rights Reserved
 */
public class BeanReference {

    private String name;

    private Object value;

    public BeanReference(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
