package com.course.server;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


//告诉自己是需要被扫描的类
@RestController
@Api(value = "/",description = "这是我全部的get方法")
public class MyGetMethod {
    @RequestMapping(value = "/get/returwith/cookies1",method = RequestMethod.GET)
    @ApiOperation(value = "通过这个方法可以获取到cookies",httpMethod = "GET")
    public String getCookies(HttpServletResponse response){
//httpServerRequest装请求信息类
//        httpServerResponse装响应信息类
        Cookie cookie = new Cookie("login","true");
        response.addCookie(cookie);
        return "恭喜你获得cookies信息成功！!!!";
    }
//    要求客户携带cookies访问
    @RequestMapping(value = "/get/with/cookies",method = RequestMethod.GET)
    @ApiOperation(value = "必须携带cookies来访问",httpMethod = "GET")
    public  String getWithCookies(HttpServletRequest request){
        Cookie[] cookies=request.getCookies();
        if(Objects.isNull(cookies)){
            return "你必须携带cookies来";
        }
        for (Cookie cookie:cookies){
            if(cookie.getName().equals("login1")&&cookie.getValue().equals("true1")){
                return "恭喜你访问成功";
            }
        }
        return "你必须携带cookies来";
    }
    /** 开发一个需要携带参数才能访问的get请求
    * 第一种实现方式url:key=value&key=value
    * http://localhost:8889/get/with/param?start=1111&end=0
    * 模拟获取商品列表
    */
    @RequestMapping(value = "/get/with/param",method = RequestMethod.GET)
    @ApiOperation(value = "模拟获取商品列表的第一种方法",httpMethod = "GET")
    public Map<String,Integer> getList(@RequestParam Integer start,@RequestParam Integer end){
        Map<String,Integer> myList=new HashMap<>();
        myList.put("鞋",400);
        myList.put("干脆面",1);
        myList.put("衬衫",120);
        return myList;
    }
    /**
     * 第二种实现方式
     * url:ip:port/get/with/param/10/20
     * http://localhost:8889/get/with/param1/10/20
     */
    @RequestMapping(value = "/get/with/param1/{start}/{end}",method = RequestMethod.GET)
    @ApiOperation(value = "模拟获取商品列表的第二种方法",httpMethod = "GET")
    public Map<String,Integer> myGetList(@PathVariable Integer start,@PathVariable Integer end){
        Map<String,Integer> myList= new HashMap<>();
        myList.put("皮鞋",888);
        myList.put("方便面",5);
        myList.put("衬衫",120);
        return myList;

    }


}
