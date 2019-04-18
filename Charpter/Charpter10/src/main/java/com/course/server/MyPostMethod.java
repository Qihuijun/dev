package com.course.server;

import com.course.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(value = "v1",description = "这是我全部的post请求")
@RequestMapping(value = "v1")
public class MyPostMethod {
//    用户登录并获取到cookies，获取到登录列表
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "登录接口，登录后获取cookies信息",httpMethod = "POST")
    public String login(HttpServletResponse response,
                        @RequestParam(value = "userName",required = true) String userName,
                        @RequestParam(value = "passWord",required = true) String passWord){
//        登录参数
        if (userName.equals("zhangshan")&&passWord.equals("123456")){
            Cookie cookie=new Cookie("login","true");
            response.addCookie(cookie);
            return "恭喜你登录成功了！";
        }
        return "你登录的账号密码错误！";
    }
//    登录成功后获取用户列表
    @RequestMapping(value = "/gerUserList",method = RequestMethod.POST)
    @ApiOperation(value = "获取用户列表",httpMethod = "POST")
    public String gerUserList(HttpServletRequest request,
                            @RequestBody User user){
//        获取cookies
        Cookie[] cookies=request.getCookies();
//        验证cookies是否合法
        for (Cookie cookie:cookies){
            if (cookie.getName().equals("login")
                    &&cookie.getValue().equals("true")
                    &&user.getUserName().equals("zhangshan")
                    &&user.getPassWord().equals("123456")){
                User user1 = new User();
                user1.setName("lisi");
                user1.setAge("17");
                user1.setSex("woman");
                return user1.toString();
            }
        }
        return "参数不合法";
    }

}
