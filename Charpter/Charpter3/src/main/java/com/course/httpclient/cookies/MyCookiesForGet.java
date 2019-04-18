package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForGet {
    private String url;
    private ResourceBundle bundle;
//    用来存储cookies的变量
    private CookieStore store;

    @BeforeTest
    public void befroreTest(){
//        获取application.properties文件
        bundle=ResourceBundle.getBundle("application", Locale.CHINA);
//        取出application.properties需要的url
        url=bundle.getString("test.url");
    }
    @Test
    public void testGetCookies() throws IOException {
        String result;
        String uri=bundle.getString("get.cookies");
//        请求部分
        String testUrl=this.url+uri;
//        创建一个httpclient对象,代替DefaultHttpClient对象
        DefaultHttpClient client=new DefaultHttpClient();
//        新建一个get请求对象，并装载url,创建HttpGet对象，将要请求的URL通过构造方法传入HttpGet对象
        HttpGet get = new HttpGet(testUrl);
//        响应部分，装在url并执行
        HttpResponse response= client.execute(get);
//        通过HttpResponse接口的getEntity方法返回响应消息，并进行相应处理
//        将响应实体化
        result=EntityUtils.toString(response.getEntity(),"utf-8");
//        打印结果
        System.out.println(result);
        int statusCode=response.getStatusLine().getStatusCode();
        System.out.println(statusCode);
        //获取Cookies信息
//        将cookie存储到声明的store中
        this.store = client.getCookieStore();
        List<Cookie> cookieList=store.getCookies();
//        目前只能打印一条cookie信息
//        获取cookie信息
        for (Cookie cookie:cookieList){
            String name =cookie.getName();
            String value=cookie.getValue();
            System.out.println("cookie name="+name+"; cookie value="+value);

        }
    }
    @Test(dependsOnMethods = {"testGetCookies"})
    public void testGetWithCookies() throws IOException {
        String uri =bundle.getString("get.with.cookies");
//        拼链接
        String testUrl=this.url+uri;
//        申明一个client对象
        DefaultHttpClient client = new DefaultHttpClient();
//        声明一个httpget对象并装载地址
        HttpGet get= new HttpGet(testUrl);
//        设置cookies信息
//        store值从testGetCookies中获取的("login","true"),这个问题找了我好久好久
        client.setCookieStore(this.store);
//        设置头信息

//        声明响应对象并执行请求
       HttpResponse response= client.execute(get);
//       获取响应的状态码
        int statusCode=response.getStatusLine().getStatusCode();
        System.out.println(statusCode);
        if(statusCode==200){
            String result = EntityUtils.toString(response.getEntity(),"utf-8");
            System.out.println(result);
        }

    }
}
