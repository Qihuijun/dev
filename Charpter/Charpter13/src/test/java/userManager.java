import com.course.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;

@Log4j2
@RestController
@Api(value = "v1",description = "用户信息系统管理接口测试")//api中的value是对RequestMapping中value的描述
@RequestMapping(value = "v1")
public class userManager {
    @Autowired//自动启动数据库对象
    private SqlSessionTemplate template;
//    登录接口测试
    @ApiOperation(value = "登录接口测试",httpMethod = "POST")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Boolean login(HttpServletResponse response, @RequestBody User user){
        int i=template.selectOne("login",user);
        Cookie cookie=new Cookie("login","true");
        response.addCookie(cookie);
        log.info("查询到的结果是"+i);
        if(i==1){
            log.info("登录的用户数："+user.getUsername());
            return true;
        }
        return false;
    }
    @ApiOperation(value = "添加用户接口",httpMethod = "POST")
    @RequestMapping(value = "/adduser",method = RequestMethod.POST)
    public boolean addUser(HttpServletRequest request, @RequestBody User user){
        Boolean x=verifyCookies(request);
        int result=0;
        if(x!=null){
            result= template.insert("addUser",user);
        }
        if (result>0){
            log.info("添加用户的数量是："+result);
            return true;
        }
        return false;
    }

    @ApiOperation(value = "获取用户信息接口",httpMethod = "POST")
    @RequestMapping(value = "/getUserInfo",method = RequestMethod.POST)
    public List<User> getUserInfo(HttpServletRequest request, @RequestBody User user){
        Boolean x=verifyCookies(request);
        if (x==true){
            List<User> users=template.selectList("getUserInfo",user);
            log.info("getUserInfo获取的用户数量是"+users.size());
            return users;
        }else {
            return null;
        }
    }
    @ApiOperation(value = "更新/删除用户信息接口",httpMethod = "POST")
    @RequestMapping(value = "/updateUserInfo",method = RequestMethod.POST)
    public int updateUserInfo(HttpServletRequest request, @RequestBody User user){
        Boolean x=verifyCookies(request);
        int i=0;
        if(x==true){
        i=template.update("updateUserInfo",user);
        }
        log.info("更新用户信息数是："+i);
        return i;
    }
//    验证cookies信息方法
    private Boolean verifyCookies(HttpServletRequest request) {
        Cookie[] cookies=request.getCookies();
        if (Objects.isNull(cookies)){
            log.info("cookies为空");
            return  false;
        }
        for (Cookie cookie:cookies){
            if (cookie.getName().equals("login")
                    &&(cookie.getValue().equals("true"))){
                log.info("cookies验证通过");
                return true;
            }
        }
        return false;
    }
}
