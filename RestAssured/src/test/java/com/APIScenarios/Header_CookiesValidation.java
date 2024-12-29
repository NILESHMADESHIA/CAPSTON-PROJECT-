package com.APIScenarios;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


/*
 * given()-prerequisite
 * ------------------------------
 * header,cookies,request payload,authorization,path parameters,query parmeters
 * 
 * when()- Request
 * -----------------------------
 * GET,POST,PUT,PATCH,DELETE
 * 
 * then()- validation 
 * ---------------------------
 * status code,message,response time,payload,headers,cookies
 * 
 * 
 * 
 */

public class Header_CookiesValidation {
  @Test(priority=1)
  public void testHeaders()
  {
	  Response res=given()
			  
			  .when().get("https://www.google.com");
			  
			  //get the headers 
			  res.then().log().headers();
			  
			  //validate Content-Type: text/html; charset=ISO-8859-1
			  
			  String expHeader="text/html; charset=ISO-8859-1";
			  String actHeader=res.getHeader("Content-Type");
			  
			  Assert.assertEquals(actHeader,expHeader,"Test Fail....Headers not matched");
			  System.out.println("Test Pass..Headers matched");	  
	  
  }
  @Test(priority=2)
  public void testCookies()
  {
	  
	  Response res=given()
	  .when().get("https://www.google.com");
	  
	  //get all the cookies in console
	  res.then().log().cookies();
	  
	  //single cookie data
	  String actCookie=res.getCookie("AEC");
	  
	  String exp="AZ6Zc-WZeQu7dGoN285TQQQFr6loOQdu6p";
	  
	  //as cookies are dynamic cookies should not be equal
	  //test should pass when two cookies are not same
	  
	  Assert.assertFalse(actCookie.contains(exp),"Test Fail....as exp cookie is a part of actual");
	  System.out.println("Test Pass...As expected cookie is not a part of actual");
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
  }
  
  
  
  
  
  
  
  
}
