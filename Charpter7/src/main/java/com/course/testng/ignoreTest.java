package com.course.testng;

import org.testng.annotations.Test;

public class ignoreTest {
//    测试用例默认显示
    @Test
    public void ignore1(){
        System.out.println("ignore1执行！");
    }
//    测试用例不显示
    @Test(enabled = false)
    public void ignore2(){
        System.out.println("ignore2执行！");
    }
//    测试用例显示
    @Test(enabled =true)
    public void ignore3(){
        System.out.println("ignore3执行！");
    }
}
