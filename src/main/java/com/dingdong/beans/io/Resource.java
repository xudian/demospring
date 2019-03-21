package com.dingdong.beans.io;

import java.io.InputStream;

/**
 * @Title: Resource
 * @Description:
 * @Author xu
 * @Date 2019/3/20 14:00
 * @Version 1.0
 * @Copyright 2018 All Rights Reserved
 */
public interface Resource {

    InputStream getInputStream() throws Exception;
}
