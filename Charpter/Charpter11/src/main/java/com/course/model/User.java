package com.course.model;

import lombok.Data;
//@Data注释一定需要加，否则不能与数据库的数据想通
@Data
public class User {
    private int id;
    private String username;
    private int age;
    private String sex;

}
