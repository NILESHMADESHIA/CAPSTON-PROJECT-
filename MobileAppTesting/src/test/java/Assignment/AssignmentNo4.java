package Assignment;

import org.testng.annotations.Test;

import com.generic.DriverUtil;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;


public class AssignmentNo4 {
  @Test
  public void TakeScreenShot() throws MalformedURLException 
  {
	  // capabilities
	  DesiredCapabilities cap = new DesiredCapabilities();
	  cap.setCapability("platformName", "android");
	  cap.setCapability("appium:automationName","uiautomator2");
	  cap.setCapability("appium:deviceNane", "pixel_5");
	  cap.setCapability("appium:udid", "emulator-5554");
	  // app path
	  String path = System.getProperty("user.dir")+"//src//test//resources//ApiDemos-debug.apk";
	  cap.setCapability("appium:app", path);
	  	  
	  //server Address
	  URL url = new URL("http://0.0.0.0:4723");
	    
	  // create a driver session
	  AppiumDriver driver=new AndroidDriver(url,cap);
	  DriverUtil.getScreenshot(driver, "Scshpt");
	  System.out.println("Session id: "+driver.getSessionId());
	  
  }
}
