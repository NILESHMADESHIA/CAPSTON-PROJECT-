package com.RestAPItest;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

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


public class RequestWithBDD {
  @Test
  public void testSingleobject() 
  {
	 Response res = given()
	  
			 		.when().get("https://api.restful-api.dev/objects/7");
	  
	 // .then()
	  //.statusCode(200)
	  //.log().body();
	  
	  //to print json body inside console
	 res.then().log().body();
	 
	 //status code =200
	 
	 int code = res.getStatusCode();
	 Assert.assertEquals(code, 200);
	 System.out.println("Status code matched!: code is"+ code);
	 //price:1849:
	 double price=res.jsonPath().getDouble("data.price");
	 Assert.assertEquals(price, 1849.99);
	 System.out.println("Price Matched!:price is :"+price);
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
  }

private Object then() {
	// TODO Auto-generated method stub
	return null;
}
}
