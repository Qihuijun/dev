package com.course.testng;


import org.testng.annotations.*;

import java.security.PublicKey;

public class BasicAnnotation {
//最基本的注解，把方法标记为测试的一部分
    @Test
    public void testcase1(){
        System.out.println("hello world!");
    }
    @Test
    public void testcase2(){
        System.out.println("你好！");
    }
    @BeforeMethod
    public  void beforeMethod(){
        System.out.println("方法之前运行");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("方法之后运行");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("类之前运行");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("类之后运行");
    }
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("组件之前运行");
    }
    @AfterSuite
    public  void afterSuite(){
        System.out.println("组件之后运行");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("beforeTest之前运行");
    }
    @AfterTest
    public  void afterTest(){
        System.out.println("afterTest之后运行");
    }
}
