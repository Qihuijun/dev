package com.course.testng.multiThread;

import org.testng.annotations.Test;
import sun.security.krb5.internal.TGSRep;

public class MultiThreadXml {
    @Test
    public void test1(){
        System.out.printf("Thread ID:%s%n", Thread.currentThread().getId());
    }
    @Test
    public void test2(){
        System.out.printf("Thread ID:%s%n", Thread.currentThread().getId());
    }
    @Test
    public void test3(){
        System.out.printf("Thread ID:%s%n", Thread.currentThread().getId());
    }
}
