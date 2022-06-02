package com.example.attendanceautomationspring.features;

import com.example.attendanceautomationspring.dataProvider.GetHeaderCookie;
import com.example.attendanceautomationspring.utility.APIPath;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

public class CookieGet {

    public Response getHeaderCookie() throws IOException {

        GetHeaderCookie getHeaderCookie=new GetHeaderCookie();
        /*getHeaderCookie.setCsrf_token(getHeaderCookie.getCsrf_token());
        getHeaderCookie.setLogin(getHeaderCookie.getLogin());
        getHeaderCookie.setPassword(getHeaderCookie.getPassword());
        getHeaderCookie.setRedirect(getHeaderCookie.getRedirect());*/

        RestAssured.baseURI= APIPath.hostURL2;

        //body declare
        RequestSpecification httpRequest =RestAssured.given();

        //response
        Response response = httpRequest
                .header("Cookie",getHeaderCookie.headerCookie)
                .when()
                .queryParam("csrf_token",getHeaderCookie.csrf_token)
                .queryParam("login",getHeaderCookie.login)
                .queryParam("password",getHeaderCookie.password)
                .queryParam("redirect",getHeaderCookie.redirect)
                .post("/web/login").prettyPeek().then().extract().response();


        return response;
    }
}
