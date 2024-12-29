package Assignment;

import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.generic.DriverUtil;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;


public class AssignmentNo3 {
  @Test
  public void DragandDrop() 
  {
	  
		//create a driver session
		  AppiumDriver driver=DriverUtil.initDriverSession();
		  
		  
		  //views
		  driver.findElement(AppiumBy.accessibilityId("Views")).click();
		  
		  
		  
		  //drag n drop
		  
		  driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		  
		  //dot 3
		  WebElement ele=driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_3"));
		  
		  //dragGesture
		  
		  driver.executeScript("mobile: dragGesture",ImmutableMap.of(
				  
				  "elementId",((RemoteWebElement)ele).getId(),
				  "endX",742,
				  "endY",1113
				  
				  ));
		  
		  //msg
		  DriverUtil.getScreenshot(driver, "dnd");
		  String text=driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_result_text")).getText();
		  System.out.println("After action result message is: "+text);
		  
		  
		  
		  
		  
	  
	  
  }
}
