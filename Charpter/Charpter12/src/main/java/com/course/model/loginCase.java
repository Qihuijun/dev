package com.course.model;

import lombok.Data;

@Data
public class loginCase {
    private  int id;
    private String username;
    private String password;
    private String expected;
}
