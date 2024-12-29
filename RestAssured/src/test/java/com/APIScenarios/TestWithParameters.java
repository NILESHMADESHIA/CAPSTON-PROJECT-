package com.APIScenarios;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

/*
 * given()- prerequisite
 * ------------------------
 * header, cookies,request,payload,authorization,path parameters,query parameter
 * 
 * 
 * when()--Request
 * -----------------------
 * GET,POST PUT,PATCH,DELETE
 * 
 * 
 * then()- validation
 * ----------------------
 * status code, massage,response time, payload, headers,cookies
 * 
 * 
 * 
 */

public class TestWithParameters {
  @Test
  public void testQuerryPathParameter()
  {
	  RestAssured.baseURI="https://api.restful-api.dev";
	  
	  Response res=given()
	  .pathParam("path","/objects")
	  .queryParam("id",3)
	  .queryParam("id",5)
	  .queryParam("id",10)
	  
	  //.when().get("https://api.restful-api.dev/{path}");
	  
	  .when().get("{path}");
	  //get the body
	  res.then().log().body();
	  
	  //get the all ids
	  List<String> allId=res.jsonPath().getList("id");
	  
	  for(String i:allId)
	  {
		  System.out.println(i);
	  }
	  
	  
	  
  }
}
