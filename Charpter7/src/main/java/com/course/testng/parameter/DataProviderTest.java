package com.course.testng.parameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.security.Provider;
import java.util.List;
import java.util.Objects;

//参数化测试
public class DataProviderTest {
    @Test(dataProvider = "data")
    public void testDataProvider(String name,int age){
            System.out.println("name="+name+"; age="+age);
    }
    @DataProvider(name = "data")
    public Object[][] providerData(){
        Object[][] o =new Object[][]{
                {"lisi",11}
        };
        return o;
    }
    @Test(dataProvider="dataMethod")
    public void test1(String name,int age){
        System.out.println("test1方法"+"name="+name+"; age="+age);
    }
    @Test(dataProvider="dataMethod")
    public void test2(String name,int age){
        System.out.println("test2方法"+"name="+name+"; age="+age);
    }
    @DataProvider(name="dataMethod")
    public Object[][] providerMethod(Method method){
        Object[][] result=null;
        if(method.getName().equals("test1")){
            result = new Object[][]{
                    {"zhangsan", 22},
                    {"lisi",25}
            };
        }else if (method.getName().equals("test2")){
            result =new Object[][]{
                    {"wangwu",40},
                    {"chenliu",60}
            };
        }
        return result;
    }

}
