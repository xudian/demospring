package com.dingdong.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: PropertyValues
 * @Description:
 * @Author xu
 * @Date 2019/3/20 12:55
 * @Version 1.0
 * @Copyright 2018 All Rights Reserved
 */
public class PropertyValues {

    private final List<PropertyValue> propertyValueList = new ArrayList<PropertyValue>();

    public List<PropertyValue> getPropertyValueList() {
        return propertyValueList;
    }

    public void addPropertyValue(PropertyValue pv) {
        this.propertyValueList.add(pv);
    }
}
