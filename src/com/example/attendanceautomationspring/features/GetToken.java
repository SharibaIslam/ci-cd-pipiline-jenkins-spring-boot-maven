package com.example.attendanceautomationspring.features;

import com.example.attendanceautomationspring.dataProvider.Token;
import com.example.attendanceautomationspring.utility.APIPath;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class GetToken {

    public  Response getToken() throws IOException {
        RestAssured.baseURI= APIPath.hostURL2;

        Token token=new Token();


        Response response = given()
                .header("Content-Type","text/html")
                .param("Email", token.userName)
                .param("Password",token.pass)
                .when()
                .get("/web/login")
                .then()
                .extract().response();
        return response;
    }
}
