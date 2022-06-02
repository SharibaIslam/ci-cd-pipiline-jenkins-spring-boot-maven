package com.example.attendanceautomationspring.dataProvider;

import com.example.attendanceautomationspring.utility.UTIL;

import java.io.IOException;
import java.util.Properties;

import static com.example.attendanceautomationspring.testClasses.TestCaseForGetToken.finalToken;
import static com.example.attendanceautomationspring.testClasses.TestCaseForGetToken.cookie;

public class GetHeaderCookie {


    UTIL util=new UTIL();
    Properties prop = util.readPropData();
    String user_name= prop.getProperty("user_name");
    String password_prop= prop.getProperty("password");

    public GetHeaderCookie() throws IOException {
    }

    public String csrf_token=finalToken;
    public String login=user_name;
    public String password=password_prop;
    public String redirect="";
    public String headerCookie=cookie;





}
