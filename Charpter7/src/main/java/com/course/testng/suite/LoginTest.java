package com.course.testng.suite;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
    @Test
    public void loginSuccess(){
        System.out.println("登录成功！");
    }
    @Test
    public void loginFail(){
        System.out.println("登录失败！");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("beforeClass运行啦！");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("afterClass运行啦！");
    }
}
