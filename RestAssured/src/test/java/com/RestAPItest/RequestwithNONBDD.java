package com.RestAPItest;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RequestwithNONBDD {
  @Test//(enabled=false)
  public void testSingleObject ()
  {
	  
	  Response res =RestAssured.get("https://api.restful-api.dev/objects/7");
	  System.out.println("Status code is  " +res.getStatusCode());
	  System.out.println("Status line is"+ res.getStatusLine());
	  System.out.println("**********Response in TextFormate*********");
	  System.out.println(res.asString());
	  System.out.println("**********Response in JSONFormate*********");
	  System.out.println(res.asPrettyString());
	  
	  // validation
	  int statuscode=res.getStatusCode();
	  Assert.assertEquals(statuscode, 200);
	  System.out.println("Status code Matched!: status code is"+statuscode );
	  
	  // how to validate any JSON payload
	  //id should be 7
	  String id=res.jsonPath().getString("id");
	  System.out.println("Id is :"+id);
	  Assert.assertEquals(id,"7");
	  System.out.println("Id matched!");
	  //"year : 2019"
	  int year = res.jsonPath().getInt("data.year");
	  Assert.assertEquals(year, 2019);
	  System.out.println("year is matched!");	  
	  
  }
  
  @Test
  public void testForListOfobject()
  {
	  Response res = RestAssured.get("https://api.restful-api.dev/objects");
	  
	  //validation for Status Code
	  int code = res.getStatusCode();
	  	Assert.assertEquals(code, 200);
	  	System.out.println("Status code matched: code is : " + code);
	  	
	  	System.out.println(res.asPrettyString());
	  	
	  	//"color": "Cloudy White",-->3rd Object
	  	String color =res.jsonPath().getString("data[2].color");
	  	Assert.assertEquals(color,"Cloudy White");
	  	System.out.println("Color matched: color is:"+ color);
	  	
	  	//get all ids from response and print it in console 
	  	
	  	List<String> allid=res.jsonPath().getList("id");
	  	System.out.println("Total ids are:"+ allid.size());
	  	
	  	for(String i: allid)
	  	{
	  		System.out.println(i);
	  		if(i.equals("7"))
	  		{
	  			System.out.println("Id is found .....Test Pass");
	  			break;
	  		}
	  	}
	  	
	  	
	  	
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
