package com.TestMobileFeature;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.generic.DriverUtil;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class TestMobileLocaters {
  @Test
  public void testLocators() throws InterruptedException 
  {
	  //create a driver session
	  AppiumDriver driver = DriverUtil.initDriverSession();
	   
	  //mobile element--Access'ibility id
	  WebElement ele1=driver.findElement(AppiumBy.accessibilityId("Access'ibility"));
	  System.out.println("Text of Element1:"+ele1.getText());
	  ele1.click();
	  
	  
	  //pause
	  Thread.sleep(1500);
	  //come back
	  driver.navigate().back();
	  
	  //Androiduiautomatior
	  WebElement ele2= driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Animation\")"));
	  System.out.println("Text of Element2:"+ele2.getText());
	  ele2.click();
	//pause
	  Thread.sleep(1500);
	  
	  //come back
	  driver.navigate().back();
	  
	  //xpath
	  WebElement ele3 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"App\"]"));
	  System.out.println("Text of Element3:"+ele3.getText());
	  ele3.click();
	//pause
	  Thread.sleep(1500);
	  
	  //come back
	  driver.navigate().back();
	  // class mane
	  WebElement ele4=driver.findElements(AppiumBy.className("android.widget.TextView")).get(5);
	  System.out.println("Text of Elemenet4: "+ele4.getText());
	  ele4.click();
	  
	  //pause
	  Thread.sleep(1500);
	  
	  //come back
	  driver.navigate().back();
	  //resource Id
	  WebElement ele5 =driver.findElements(AppiumBy.id("android:id/text1")).get(6);
	  System.out.println("Text of Elemenet5: "+ele5.getText());
	  ele5.click();
	  
	  //pause
	  Thread.sleep(1500);
	  
	  //come back
	  //driver.navigate().back();
	  driver.findElement(AppiumBy.accessibilityId("MediaPlayer")).click();
	  
	  
  }
}
