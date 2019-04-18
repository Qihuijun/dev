package com.course.model;

import lombok.Data;

@Data
public class User {
    private int id;
    private String userName;
    private String password;
    private  String sex;
    private  int age;
    private  String permission;
    private  String isDelete;

//    转换成json格式
    @Override
    public String toString(){
        return (
                "id:"+id+","+
                "userName:"+userName+","+
                "password:"+password+","+
                "sex:"+sex+","+
                "age:"+age+","+
                "permission:"+permission+","+
                "isDelete:"+isDelete+","
                );
    }
}
