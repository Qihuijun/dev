package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
public class MyCookieForPost {
    private String url;
    private ResourceBundle bundle;
    //    用来存储cookies的变量
    private CookieStore store;

    @BeforeTest
    public void beforeTest(){
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
    public  void testPostWithCookies() throws IOException {
        String uri=bundle.getString("post.with.cookies");
        String testUrl=this.url+uri;
//        申明client对象，用来进行方法的执行
        DefaultHttpClient client=new DefaultHttpClient();
//        申明一个Post方法
        HttpPost post=new HttpPost(testUrl);

        //        设置请求头信息
        post.setHeader("content-type","application/json");
//        设置cookies信息
        client.setCookieStore(this.store);
//        添加参数
        JSONObject param=new JSONObject();
        param.put("name","huhansan");
        param.put("age","20");
//        将参数信息添加到方法中
        StringEntity entity=new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
//        声明一个对象来进行响应结果存储
        String result;
//        执行post请求
       HttpResponse response= client.execute(post);
        System.out.println(response.getStatusLine());
//        获取响应结果
        result=EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
//        处理结果，判断返回结果是否符合预期结果
//        将返回的响应结果字符串转化为json对象
        JSONObject resultJson=new JSONObject(result);

//        获取到结果值
        String success= (String) resultJson.get("huhansan2");
        String status= (String) resultJson.get("status");
//        具体判断返回值
        Assert.assertEquals("success",success);
        Assert.assertEquals("1",status);



    }

}
