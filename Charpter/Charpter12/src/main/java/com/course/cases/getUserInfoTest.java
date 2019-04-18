package com.course.cases;

import com.course.config.testConfig;
import com.course.model.getUserInfocase;
import com.course.utils.DataBaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;

public class getUserInfoTest {
    @Test(dependsOnGroups = "loginTrue",description = "获取用户信息接口测试")
    public void getUserInfo() throws IOException, InterruptedException {
        SqlSession session= DataBaseUtil.getSqlSession();
        getUserInfocase getuserinfo;
        getuserinfo=session.selectOne("getUserInfoCase",2);
        System.out.println(getuserinfo.toString());
        System.out.println(testConfig.getUserInfoUrl);
//        请求信息，获取结果
        JSONObject resultJson=getJsonResult(getuserinfo);
//        Thread.sleep(5000);
////        验证
//        User user=session.selectOne(getuserinfo.getExpected(),getuserinfo);
//
//        List userList=new ArrayList();
//        userList.add(user);
//        JSONArray jsonArray=new JSONArray(userList);
//        JSONArray jsonArray1=new JSONArray(resultJson.getString(0));
//        Assert.assertEquals(jsonArray.toString(),jsonArray1.toString());
    }

    private JSONObject getJsonResult(getUserInfocase getuserinfo) throws IOException {
        //        创建请求对象
        HttpPost post=new HttpPost(testConfig.getUserInfoUrl);
//        设置参数
        JSONObject param=new JSONObject();

        param.put("id",getuserinfo.getUserid());
//        设置头信息
        post.setHeader("content-type","application/json");
//        设置cookie信息
        testConfig.defaultHttpClient.setCookieStore(testConfig.store);
//        将参数放入方法中
        StringEntity entity=new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
//        执行请求信息
        HttpResponse response=testConfig.defaultHttpClient.execute(post);
//        获取请求结果，将请求结果实体化
        String result= EntityUtils.toString(response.getEntity(),"utf-8");

//        返回结果
//        将result放到Json数组中
//        List resultList= Arrays.asList(result);
//        JSONArray jsonArray=new JSONArray(resultList);
        JSONObject resultJson=new JSONObject(result);
        System.out.println(resultJson);
        return resultJson;
    }

}
