package com.course.cases;

import com.course.config.testConfig;
import com.course.model.InterfaceName;
import com.course.model.loginCase;
import com.course.utils.DataBaseUtil;
import com.course.utils.configFile;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class loginTest {

    @BeforeTest(groups = "loginTrue",description = "测试准备工作,获取httpclient对象")
    public void BeforTest(){
        testConfig.getUserInfoUrl= configFile.getUrl(InterfaceName.GETUSERINFO);
        testConfig.addUserUrl= configFile.getUrl(InterfaceName.ADDUSER);
        testConfig.getUserListUrl= configFile.getUrl(InterfaceName.GETUSERLIST);
        testConfig.updateUserInfoUrl= configFile.getUrl(InterfaceName.UPDATEUSERINFO);
        testConfig.loginUrl= configFile.getUrl(InterfaceName.Login);
        testConfig.defaultHttpClient=new DefaultHttpClient();
    }
    @Test(groups = "loginTrue",description = "用户登录成功接口测试")
    public void loginTrue() throws IOException {
        SqlSession session= DataBaseUtil.getSqlSession();
//        取数据库中id=1的数据
        loginCase loginCase=session.selectOne("loginCase",1);
        System.out.println(loginCase.toString());
        System.out.println(testConfig.loginUrl);
//        发请求，获取结果
        String result=getResult(loginCase);
        Assert.assertEquals(loginCase.getExpected(),result);
    }

    private String getResult(loginCase loginCase) throws IOException {
//        创建Post请求对象
        HttpPost post =new HttpPost(testConfig.addUserUrl);
//        设置参数
        JSONObject param=new JSONObject();
        param.put("username",loginCase.getUsername());
        param.put("password",loginCase.getPassword());
//        设置头部信息
        post.setHeader("content-Type","application/json");
//        将参数放入方法中
        StringEntity entity= new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
//        执行请求
        HttpResponse response=testConfig.defaultHttpClient.execute(post);
//       获取响应信息,用实体组件将实体信息转换为字符串
        String result=EntityUtils.toString(response.getEntity());
        System.out.println(result);
//        获取响应信息的cookies信息
        testConfig.store=testConfig.defaultHttpClient.getCookieStore();
        return result;

    }

    //    一个请求方法
    @Test(groups = "loginFalse",description = "用户登录失败接口测试")
    public void loginFalse() throws IOException {
        SqlSession session=DataBaseUtil.getSqlSession();
        //        取数据库中id=1的数据
        loginCase loginCase=session.selectOne("loginCase",1);
        System.out.println(loginCase.toString());
        System.out.println(testConfig.loginUrl);
        //        发请求，获取结果
        String result=getResult(loginCase);
        Assert.assertEquals(loginCase.getExpected(),result);
    }

}
