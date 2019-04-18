package com.course.model;

import lombok.Data;

@Data
public class getUserListCase {
    private int id;
    private String username;
    private String sex;
    private int age;
    private String expected;
}
