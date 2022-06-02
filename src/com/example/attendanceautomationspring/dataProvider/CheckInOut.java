package com.example.attendanceautomationspring.dataProvider;

import com.example.attendanceautomationspring.utility.UTIL;

import java.io.IOException;
import java.util.Properties;

import static com.example.attendanceautomationspring.testClasses.TestClassForGetCookie.headerCookieSecond;

public class CheckInOut {
    UTIL util=new UTIL();
    Properties prop = util.readPropData();
    String emplyeeID_prop= prop.getProperty("emplyeeID_prop");

    public CheckInOut() throws IOException {
    }

    public String jsonrpc="2.0";
    public String method="call";
    public int emplyeeID=Integer.parseInt(emplyeeID_prop) ;
    public String model="hr.employee";
    public String method2="attendance_manual";
    public String headerCookieForchkInOut=headerCookieSecond;

}
