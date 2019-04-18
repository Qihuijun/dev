package com.course.utils;

import com.course.model.InterfaceName;

import java.util.Locale;
import java.util.ResourceBundle;

public class configFile {
    private static ResourceBundle bundle=ResourceBundle.getBundle("application", Locale.CHINA);
//    静态方法不用new对象就可以直接用了；
    public static String getUrl(InterfaceName name){
        String address=bundle.getString("test.url");

        String uri="";
/*最终获取的地址*/
        String testUrl;
        if(name==InterfaceName.GETUSERINFO){
            uri=bundle.getString("getUserInfo.uri");
        }
        if (name==InterfaceName.GETUSERLIST){
            uri=bundle.getString("getUserList.uri");
        }
        if (name==InterfaceName.Login){
            uri=bundle.getString("login.uri");
        }
        if (name==InterfaceName.ADDUSER){
            uri=bundle.getString("addUser.uri");
        }
        if (name==InterfaceName.UPDATEUSERINFO){
            uri=bundle.getString("updateUserInfo.uri");
        }
        testUrl=address+uri;
        return testUrl;
    }
}
