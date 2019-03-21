package com.dingdong.beans;

/**
 * @Title: PropertyValue
 * @Description:
 * @Author xu
 * @Date 2019/3/20 12:06
 * @Version 1.0
 * @Copyright 2018 All Rights Reserved
 */
public class PropertyValue {

    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
