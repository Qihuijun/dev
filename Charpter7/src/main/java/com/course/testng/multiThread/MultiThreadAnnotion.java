package com.course.testng.multiThread;

import org.testng.annotations.Test;
//多线程测试
public class MultiThreadAnnotion {
    @Test(invocationCount = 10,threadPoolSize = 3)
    public void test(){
        System.out.println(1);
        System.out.printf("Thread ID:%s%n",Thread.currentThread().getId());
    }
}
