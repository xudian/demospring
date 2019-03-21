package com.dingdong.beans.io;

import java.net.URL;

/**
 * @Title: ResourceLoader
 * @Description:
 * @Author xu
 * @Date 2019/3/20 14:06
 * @Version 1.0
 * @Copyright 2018 All Rights Reserved
 */
public class ResourceLoader {

    public Resource getResource(String location) {
        URL resource = this.getClass().getClassLoader().getResource(location);
        return new UrlResource(resource);
    }
}
