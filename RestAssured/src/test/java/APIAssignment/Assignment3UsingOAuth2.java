package APIAssignment;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

public class Assignment3UsingOAuth2 {
  @Test(priority=1)
  public void testBasicAuthentication() 
  {
	  System.out.println("Test for Basic Authentication Base 64");
	  	Response res=given()
		.auth().basic("postman","password")

		 .when().get("https://postman-echo.com/basic-auth");


	  	 res.then().log().body();
  }
  @Test(priority=2)
  public void testDigestAuthentication()
  {
	  System.out.println("Test for Digest Authentication:SHA/MD5");
	  Response res=given()
	  .auth().digest("postman", "password")
	  .when().get("https://postman-echo.com/digest-auth");
	  //log the response
	  res.then().log().body();
	    
  }
  @Test(priority=3)
  public void testBearerToken()
  {
	  System.out.println("Test for Bearer Token API");
	  
	  Response res=given()
	  .header("Authorization","Bearer 12345")
	  
	  .when().get("https://postman-echo.com");
	  
	  res.then().log().body();	  
	  
  }
  @Test
  public void Oauth2Test()
  {
	  //Releted to +Assignment no 3
	  Response res=given()
			  .auth().oauth2("Bearer 18182024")
			  .when().get("https://postman-echo.com");
	  int code =res.getStatusCode();
	  Assert.assertEquals(code, 200);
	  System.out.println("Status code is :"+code);
	  
	  res.then().log().body();	  
  }
}
