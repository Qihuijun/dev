package com.course.testng;

import org.testng.annotations.Test;
//超时测试
public class timeOutTest {
    @Test(timeOut = 3000)
    public void testSucceed() throws InterruptedException {
        Thread.sleep(2000);
    }
    @Test(timeOut = 2000)
    public void testFailed() throws InterruptedException {
        Thread.sleep(3000);
    }
}
