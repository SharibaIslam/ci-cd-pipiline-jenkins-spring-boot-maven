package com.example.attendanceautomationspring.testClasses;

import com.example.attendanceautomationspring.dataProvider.CheckInOut;
import com.example.attendanceautomationspring.dataProvider.MultipleDataForCheckInCheckOut;
import com.example.attendanceautomationspring.model.User;
import com.example.attendanceautomationspring.utility.APIPath;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import javax.jws.soap.SOAPBinding;
import java.io.IOException;
import java.util.*;

public class TestClassForCheckInOut {


    @Test(priority = 2,alwaysRun = true, enabled = true,dataProvider= "employee-id",dataProviderClass = MultipleDataForCheckInCheckOut.class)
    public void setCheckInOut(int id) throws IOException {
        CheckInOut checkInOut=new CheckInOut();

        //array
        List<Integer> value1=Arrays.asList(id);
        List<Object> total=Arrays.asList(value1,"hr_attendance.hr_attendance_action_my_attendances");
        //second child
        Map<String, String> input = Collections.emptyMap();
        //first child
        HashMap<String, Object> queryParam2 = new HashMap<String, Object>();
        queryParam2.put("args",total);
        queryParam2.put("model",checkInOut.model);
        queryParam2.put("method",checkInOut.method2);
        queryParam2.put("kwargs",input);

        //final body
        HashMap<String, Object> body = new HashMap<String, Object>();
        body.put("jsonrpc",checkInOut.jsonrpc);
        body.put("method",checkInOut.method);
        body.put("params",queryParam2);


        RestAssured.baseURI= APIPath.hostURL2;

//body declare
        RequestSpecification httpRequest =RestAssured.given().contentType(ContentType.JSON);
        //response
       httpRequest
                .header("Content-Type", "application/json")
                .header("Cookie",checkInOut.headerCookieForchkInOut)
                .when()
                .body(body)
                .header("Content-Type", "application/json")
                .post("/web/dataset/call_kw/hr.employee/attendance_manual")
                .then().log().all()
                .assertThat()
                .statusCode(200);
    }
}
