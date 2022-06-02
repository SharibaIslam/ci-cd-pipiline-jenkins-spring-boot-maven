package com.example.attendanceautomationspring.testClasses;

import com.example.attendanceautomationspring.features.CookieGet;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

@Test(priority = 1,alwaysRun = true, enabled = true)
public class TestClassForGetCookie {
    public CookieGet cookieGet=new CookieGet();
    public static String headerCookieSecond;

    public void getCookieHeader() throws IOException {
        Response response=cookieGet.getHeaderCookie();
        ResponseBody body = response.getBody();
        String bodyAsString = body.asString();
        headerCookieSecond = response.getHeader("Set-Cookie");
        System.out.println("name received from Response: " + headerCookieSecond);

        response
                .then().log().all()
                .assertThat()
                .statusCode(200);
        //.body(name,containsString("OTP"));
        Assert.assertNotEquals(headerCookieSecond,"");

    }
}
