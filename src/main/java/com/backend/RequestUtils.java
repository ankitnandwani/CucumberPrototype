package com.backend;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Map;

public class RequestUtils {

    public Response sendGetWithQueryParams(String url, Map<String, ?> headers, Map<String, ?> params){
        return RestAssured.given().headers(headers).log().all().queryParams(params).get(url);
    }

    public Response sendGetWithPathParams(String url, Map<String, ?> headers, Map<String, ?> params){
        return RestAssured.given().headers(headers).log().all().pathParams(params).get(url);
    }

    public Response sendGet(String url, Map<String, ?> headers){
        return RestAssured.given().headers(headers).log().all().get(url);
    }

    public Response sendPostWithBodyAndPath(String url, Map<String, ?> headers, Map<String, ?> params, String body){
        return RestAssured.given().headers(headers).log().all().pathParams(params).body(body).post(url);
    }

    public Response sendPostWithBodyPathAndQuery(String url, Map<String, ?> headers, Map<String, ?> pathPrams, Map<String, ?> qParams, String body){
        return RestAssured.given().headers(headers).log().all().pathParams(pathPrams).queryParams(qParams).body(body).post(url);
    }
}
