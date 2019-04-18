package com.course.controler;

import com.course.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@Api(value = "v1",description = "这是我的第一个版本的demo")
@RequestMapping(value = "v1")
public class Demo {
//    首先获取一个执行sql语句的对象
    @Autowired  //启动加载
    private SqlSessionTemplate template;
//    查询
    @RequestMapping(value = "/getUserCount",method = RequestMethod.GET)
    @ApiOperation(value = "可以获取到用户数",httpMethod = "GET")
    public int getUserCount(){
       return template.selectOne("getUserCount");
    }
//    新增
    @RequestMapping(value = "/addUserInfo",method = RequestMethod.POST)
    @ApiOperation(value = "增加用户信息",httpMethod = "POST")
    public int addUserInfo(@RequestBody User user){
        int result = template.insert("addUserInfo",user);
        return result;
    }
//    修改
    @RequestMapping(value = "/modifyUserInfo",method = RequestMethod.POST)
    @ApiOperation(value = "修改用户信息",httpMethod = "POST")
    public int modifyUserInfo(@RequestBody User user){
       int result= template.update("modifyUserInfo",user);
        return result;
    }
    //    删除
    @RequestMapping(value = "/deleteUserInfo",method = RequestMethod.GET)
    @ApiOperation(value = "删除用户信息",httpMethod = "GET")
    public int deleteUserInfo(@RequestParam int id){
        int result = template.delete("deleteUserInfo",id);
        return result;
    }
//    查询
    @RequestMapping(value = "/selectUser",method = RequestMethod.GET)
    @ApiOperation(value = "查询用户信息",httpMethod = "GET")
    public List<User> selectUserInfo(@RequestParam int id,User user){
        List<User> list = template.selectList("selectUserInfo", user);
        return list;
    }

}
