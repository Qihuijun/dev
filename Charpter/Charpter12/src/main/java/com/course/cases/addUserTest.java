package com.course.cases;

import com.course.config.testConfig;
import com.course.model.User;
import com.course.model.addUserCase;
import com.course.utils.DataBaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


public class addUserTest {
    @Test(dependsOnGroups = "loginTrue",description = "添加用户接口测试")
    public void addUser() throws IOException, InterruptedException {
        SqlSession session= DataBaseUtil.getSqlSession();
//        记得这里是将model中的addUserCase实例化，最好是将测试用例类名称和model类名称不要一直，否则引用的是测试用例类
        addUserCase adduserCase=session.selectOne("addUserCase",1);
        System.out.println(adduserCase.toString());
        System.out.println(testConfig.addUserUrl);
        //    发请求，获取结果
        String result=getResult(adduserCase);
        Thread.sleep(1000);
//    验证返回结果
        User user=session.selectOne("adduser",adduserCase);
        System.out.println("user信息："+user.toString());
        Assert.assertEquals(adduserCase.getExpected(),result);

    }

    private String getResult(addUserCase addUserCase) throws IOException {
//        创建一个post请求对象
        HttpPost post = new HttpPost(testConfig.addUserUrl);
//        设置参数
        JSONObject param= new JSONObject();
        param.put("username",addUserCase.getUsername());
        param.put("password",addUserCase.getPassword());
        param.put("sex",addUserCase.getSex());
        param.put("age",addUserCase.getAge());
        param.put("permission",addUserCase.getPermission());
        param.put("isDelete",addUserCase.getIsDelete());
//        设置头部信息
        post.setHeader("content-type","application/json");
//        设置cookies信息
        testConfig.defaultHttpClient.setCookieStore(testConfig.store);
//        将参数放到实体中并将参数实体添加到方法中
        StringEntity entity= new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
//        声明一个result变量,存放返回结果
        String result;
        //        声明一个响应变量
        HttpResponse response ;
//        执行响应
        response=testConfig.defaultHttpClient.execute(post);
//       先获取响应实体response.getEntity()，再将响应结果转换成字符串并返回
       result= EntityUtils.toString(response.getEntity(),"utf-8");
       System.out.println("返回结果信息："+result);
        return result;
    }
}
