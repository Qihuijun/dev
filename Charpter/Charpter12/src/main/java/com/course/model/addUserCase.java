package com.course.model;

import lombok.Data;

@Data
public class addUserCase {
    private int id;
    private String username;
    private String password;
    private  String sex;
    private int age;
    private int permission;
    private int isDelete;
    private String expected;
}
