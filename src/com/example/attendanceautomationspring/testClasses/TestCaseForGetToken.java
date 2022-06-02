package com.example.attendanceautomationspring.testClasses;

import com.example.attendanceautomationspring.features.GetToken;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.lang.model.util.Elements;
import javax.swing.text.Document;
import java.io.IOException;
import java.util.List;

import static io.restassured.path.xml.XmlPath.CompatibilityMode.HTML;

@Test(priority = 0,alwaysRun = true, enabled = true)
public class TestCaseForGetToken {
    public GetToken getToken=new GetToken();
    public static String finalToken;
    public static String cookie;
    public void getTokenTestCase() throws IOException {
        Response response=getToken.getToken();
        cookie = response.getHeader("Set-Cookie");

        ResponseBody body = response.getBody();
        String token = response.htmlPath().getString("html.head.script[0]");
        String a4 = token.replace("var", "");
        String a2 = a4.replace("odoo", "");
        String a23 = a2.replace("=", "");
        String a24 = a23.replace("{", "");
        String a25 = a24.replace("csrf_token:", "");
        String a26 = a25.replace(",", "");
        String a27 = a26.replace("};", "");
        String a28 = a27.replace("\"", "");
        finalToken=a28.trim();
        //jsonPathEvaluator.prettyPrint();
        System.out.println("final token is : " +finalToken);
        System.out.println("header cookie is:" +cookie);
        response
                .then().log().all()
                .assertThat()
                .statusCode(200);
        //.body(name,containsString("OTP"));
       Assert.assertNotEquals(finalToken,"");

    }
}
