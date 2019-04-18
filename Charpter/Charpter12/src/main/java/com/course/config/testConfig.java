package com.course.config;

import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.DefaultHttpClient;

public class testConfig {
//    声明地址对象；
    public static String loginUrl;
    public static String updateUserInfoUrl;
    public static String getUserListUrl;
    public static String getUserInfoUrl;
    public static String addUserUrl;
//    声明对象
    public static DefaultHttpClient defaultHttpClient;
    public static CookieStore store;
}
