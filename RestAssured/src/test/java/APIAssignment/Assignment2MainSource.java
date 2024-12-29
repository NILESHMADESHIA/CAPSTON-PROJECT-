package APIAssignment;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.testPoja.Assignment2Maindata;
import com.testPoja.Assignment2OtherData;
import com.testPoja.AuthenticPojo;
import com.testPoja.BookingDates;
import com.testPoja.BookingDetails;

import org.testng.Assert;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Assignment2MainSource {
  @Test
  public void creatingNewDetails ()
  {
	  Assignment2OtherData assignment2OtherData=new Assignment2OtherData();
	  assignment2OtherData.setYear("2019");
	  assignment2OtherData.setPrice("1849.99");
	  assignment2OtherData.setCPUmodel("Intel Core i9");
	  assignment2OtherData.setHarddisksize("1 TB");
	  
	  Assignment2Maindata data =new Assignment2Maindata();
	  data.setName("Apple MacBook Pro 16");
	  data.setAssignment2OtherData("assignment2OtherData");
	  System.out.println("Creating New Details");
	  Response res =given()
			  .body(data)
			  .when().post("https://api.restful-api.dev/objects");
      res.then().log().body();
  }
}
