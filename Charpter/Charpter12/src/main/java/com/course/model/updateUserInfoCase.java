package com.course.model;

import lombok.Data;

@Data
public class updateUserInfoCase {
    private int id;
    private  int userId;
    private  String userName;
    private String sex;
    private  int age;
    private  String permission;
    private String isDelete;
    private String expected;
}
