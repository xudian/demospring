package com.dingdong.beans.io;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Title: UrlResource
 * @Description:
 * @Author xu
 * @Date 2019/3/20 14:01
 * @Version 1.0
 * @Copyright 2018 All Rights Reserved
 */
public class UrlResource implements Resource {

    private final URL url;

    public UrlResource(URL url) {
        this.url = url;
    }

    public InputStream getInputStream() throws Exception {
        URLConnection urlConnection = url.openConnection();
        urlConnection.connect();
        return urlConnection.getInputStream();
    }
}
