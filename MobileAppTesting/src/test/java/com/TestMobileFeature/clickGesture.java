package com.TestMobileFeature;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.generic.DriverUtil;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class clickGesture {
  @Test
  public void testClickGesture() 
  {
	  //create driver session
	  AppiumDriver driver=DriverUtil.initDriverSession();
	  //view
	  WebElement ele =driver.findElement(AppiumBy.accessibilityId("Views"));
	  //ele.click();
	  
	  //clickGesture
	  driver.executeScript("mobile: clickGesture", ImmutableMap.of(
			  "elementId",((RemoteWebElement)ele).getId()
			  
			  ));
	  System.out.println("Click Gesture is Completed");
	  
	  
  }
}
