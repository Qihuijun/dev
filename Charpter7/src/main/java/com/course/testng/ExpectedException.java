package com.course.testng;

import org.testng.annotations.Test;
//在期望结果为某个异常的时候，需要用到异常测试；eg.传入非法参数，程序抛出异常
public class ExpectedException {
//    这个测试异常会报错
    @Test(expectedExceptions  =RuntimeException.class)
    public void runTimeExceptionFailed(){
        System.out.println("这是一个失败的异常测试");
    }
//    这是一个成功的异常测试
    @Test(expectedExceptions =RuntimeException.class)
    public void runTimeExceptionSucceed(){
        System.out.println("这是我的异常测试");
        throw new RuntimeException();
    }


}
