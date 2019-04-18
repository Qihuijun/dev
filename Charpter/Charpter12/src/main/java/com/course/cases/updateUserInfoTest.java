package com.course.cases;

import com.course.config.testConfig;
import com.course.model.User;
import com.course.model.updateUserInfoCase;
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

public class updateUserInfoTest {
    @Test(dependsOnGroups = "loginTrue",description = "更新性别为男的用户列表接口测试")
    public void updateUserInfo() throws IOException {
        SqlSession session= DataBaseUtil.getSqlSession();
//        记得这里是将model中的addUserCase实例化，最好是将测试用例类名称和model类名称不要一直，否则引用的是测试用例类
        updateUserInfoCase updateUserInfoCase=  session.selectOne("updateUserInfoCase","男");
        System.out.println(updateUserInfoCase.toString());
        System.out.println(testConfig.addUserUrl);
//        请求信息，获取结果
        int result=getResult(updateUserInfoCase);
        User user=session.selectOne(updateUserInfoCase.getExpected(),updateUserInfoCase);
//        验证结果
//        更新数据信息不为空
        Assert.assertNotNull(user);
        Assert.assertNotNull(result);
    }

    private int getResult(updateUserInfoCase updateUserInfoCase) throws IOException {
        //        创建请求对象
        HttpPost post=new HttpPost(testConfig.updateUserInfoUrl);
//        设置参数
        JSONObject param=new JSONObject();
        param.put("id",updateUserInfoCase.getId());
        param.put("userId",updateUserInfoCase.getUserId());
        param.put("userName",updateUserInfoCase.getUserName());
        param.put("sex",updateUserInfoCase.getSex());
        param.put("age",updateUserInfoCase.getAge());
        param.put("permission",updateUserInfoCase.getPermission());
        param.put("isDelete",updateUserInfoCase.getIsDelete());
        param.put("expected",updateUserInfoCase.getExpected());
//        设置头信息
        post.setHeader("content-Type","application/json");
//        设置cookie信息
        testConfig.defaultHttpClient.setCookieStore(testConfig.store);
//        将参数放入方法中
        StringEntity entity=new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
//        执行请求信息
        HttpResponse response=testConfig.defaultHttpClient.execute(post);
//        获取请求结果，将请求结果实体化
        String result= EntityUtils.toString(response.getEntity());
//        返回结果
//        将result强转为int
        return Integer.parseInt(result);
    }

}
