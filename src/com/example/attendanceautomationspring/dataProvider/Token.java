package com.example.attendanceautomationspring.dataProvider;

import com.example.attendanceautomationspring.utility.UTIL;

import java.io.IOException;
import java.util.Properties;

public class Token {
    UTIL util=new UTIL();
    Properties prop = util.readPropData();
    String user_name= prop.getProperty("user_name");
    String password= prop.getProperty("password");

    public Token() throws IOException {
    }

    public String userName=user_name;
    public String pass=password;

}
