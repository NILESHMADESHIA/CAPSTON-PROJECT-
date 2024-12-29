package APIAssignment;
import org.testng.annotations.Test;

import com.testPoja.AuthenticPojo;
import com.testPoja.BookingDates;
import com.testPoja.BookingDetails;

import org.testng.Assert;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


import org.testng.annotations.Test;

public class Assignmenino1WithRESTAssured {
  @Test(priority =1)
  public void getAllDetails() 
  {
	  Response res =given()
			       .when().get("https://petstore.swagger.io/v2/pet/findByStatus?status=available");
	  //Status Code =200
	  int code = res.getStatusCode();
	  Assert.assertEquals(code, 200);
	  System.out.println("Status Code is :"+code);
	  res.then().log().body();	  
  }
  @Test(priority =2)
  public void addNewDetails()
  {
	  System.out.println("New Details Add");
	  Response res=given()
	  .header("accept"," application/json")
	  .header("Content-Type"," application/json")
	  .body("{\n"
	  		+ "\"id\": 111,\n"
	  		+ "\"category\": {\n"
	  		+ "\"id\": 0,\n"
	  		+ "\"name\": \"string\"\n"
	  		+ "},\n"
	  		+ "\"name\": \"doggie\", \"photoUrls\": [\n"
	  		+ "\"string\"\n"
	  		+ "],\n"
	  		+ "\"tags\": [\n"
	  		+ "{\n"
	  		+ "\"id\": 0,\n"
	  		+ "\"name\": \"string\"\n"
	  		+ "}\n"
	  		+ "],\n"
	  		+ "\"status\": \"available\"\n"
	  		+ "}")
	  .when().post("https://petstore.swagger.io/v2/pet");
	  res.then().log().body();
	  int bookingId =res.jsonPath().getInt("id");
	  System.out.println("Booking ID is :"+bookingId);	  
	  
  }
  @Test(priority =3)
  public void findUpdateDetails() 
  {
	  System.out.println("****Find Updated Details*****");
	  Response res =given()
			  .header("accept","application/json")
			  .when().get("https://petstore.swagger.io/v2/pet/111");
	  		  
	  int code = res.getStatusCode();
	  Assert.assertEquals(code, 200);
	  System.out.println("Status Code is :"+code);
	  res.then().log().body();		  
  }
  @Test(priority =4)
  public void updatingExistingData()
  {
	  System.out.println("Updating Existing Data");
	  BookingDetails data=new BookingDetails();
	  data.setFirstname("string");
	  data.setLastname("doggie");
	  
	  Response res=given()
	  .header("accept"," application/json")
	  .header("Content-Type"," application/json")
	  .body(data)
	  .when().post("https://petstore.swagger.io/v2/pet");
	  int code = res.getStatusCode();
	  Assert.assertEquals(code, 200);
	  System.out.println("Status Code is :"+code);
	  res.then().log().body();
  }
  @Test(priority=5)
  public void deleteBooking()
  {
			  System.out.println("Delete the booing for same id: ");
			  Response res=given()
			  .header("Content-Type","application/json")
			  .when().delete("https://petstore.swagger.io/v2/pet/111");
			
		 	res.then().log().body();
		 	int code=res.getStatusCode();
		 	Assert.assertEquals(code,200);
  }  
}
