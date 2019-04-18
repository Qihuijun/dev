package com.course.cases;

import com.course.config.testConfig;
import com.course.model.User;
import com.course.model.getUserListCase;
import com.course.utils.DataBaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class getUserListTest {
    @Test(dependsOnGroups = "loginTrue",description = "获取性别为男的用户列表接口测试")
    public void getUserList() throws IOException {
        SqlSession session= DataBaseUtil.getSqlSession();
//        记得这里是将model中的addUserCase实例化，最好是将测试用例类名称和model类名称不要一直，否则引用的是测试用例类
        getUserListCase getuserlist=  session.selectOne("getUserListCase","男");
        System.out.println(getuserlist.toString());
        System.out.println(testConfig.getUserListUrl);
//        发送请求，获取结果
        JSONArray resultJson=getResult(getuserlist);
        System.out.println(resultJson.toString());
//        验证结果与期望结果信息
        List<User> userList=session.selectList(getuserlist.getExpected(),getuserlist);
        for (User u:userList){
            System.out.println("获取的user:"+u.toString());
        }
        JSONArray userListJson=new JSONArray(userList);
        Assert.assertEquals(userListJson.length(),resultJson.length());
        for (int i=0;i<resultJson.length();i++){
            JSONObject expect= (JSONObject) resultJson.get(i);
            JSONObject actual= (JSONObject) userListJson.get(i);
            Assert.assertEquals(expect.toString(),actual.toString());
        }
    }

    private JSONArray getResult(getUserListCase getuserlist) throws IOException {
//        创建请求对象
        HttpPost post=new HttpPost(testConfig.getUserListUrl);
//        设置参数
        JSONObject param=new JSONObject();
        param.put("id",getuserlist.getId());
        param.put("username",getuserlist.getUsername());
        param.put("sex",getuserlist.getSex());
        param.put("age",getuserlist.getAge());
        param.put("expected",getuserlist.getExpected());
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
       System.out.println(result);
//        返回结果
//        将result放到Json数组中

        JSONArray jsonArray = new JSONArray(result);
        return jsonArray;
    }
}
