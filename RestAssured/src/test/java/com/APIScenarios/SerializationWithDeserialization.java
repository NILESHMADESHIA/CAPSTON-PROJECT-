package com.APIScenarios;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.testPoja.AuthenticPojo;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;
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
 * Serialization: POJO---->JSON
 * De-serialization: JSON--->POJO
 * 
 */

public class SerializationWithDeserialization {
  @Test
  public void testSerialization() throws JsonProcessingException
  {
	  AuthenticPojo  data=new AuthenticPojo ();
	  data.setUsername("nilesh");
	  data.setPassword("password123");
	  
	  ObjectMapper obj=new ObjectMapper();
	  
	 String json= obj.writerWithDefaultPrettyPrinter().writeValueAsString(data);
	  
	 System.out.println(json);
	  
  }
  @Test
  public void testDeserialization() throws JsonMappingException, JsonProcessingException
  {
	  String json="{\n"
	  		+ "  \"username\" : \"admin\",\n"
	  		+ "  \"password\" : \"password123\"\n"
	  		+ "}";
	  
	  ObjectMapper obj=new ObjectMapper();
	  AuthenticPojo auth=obj.readValue(json,AuthenticPojo.class);
	  
	  System.out.println(auth.getUsername());
	  System.out.println(auth.getPassword());
	  
	  
	  
  }
  
  
}
