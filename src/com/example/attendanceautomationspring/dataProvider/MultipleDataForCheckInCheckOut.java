package com.example.attendanceautomationspring.dataProvider;

import com.example.attendanceautomationspring.utility.UTIL;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.Properties;


public class MultipleDataForCheckInCheckOut {
    UTIL util=new UTIL();
    Properties prop = util.readPropData();
    String emplyeeID_prop= prop.getProperty("emplyeeID_prop");
    String emplyeeID_prop2= prop.getProperty("emplyeeID_prop2");
    String emplyeeID_pro3= prop.getProperty("emplyeeID_prop3");

    public int emplyeeID1=Integer.parseInt(emplyeeID_prop) ;
    public int emplyeeID2=Integer.parseInt(emplyeeID_prop2) ;
    public int emplyeeID3=Integer.parseInt(emplyeeID_pro3) ;

    public MultipleDataForCheckInCheckOut() throws IOException {
    }

    @DataProvider(name="employee-id")
    Object[][] employeeId() {
        return new Object[][]{
                {emplyeeID1},
                {emplyeeID2},
                {emplyeeID3}
        };
    }
}
