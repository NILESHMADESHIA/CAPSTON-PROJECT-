package Assignment;

import java.time.Duration;

import org.testng.annotations.Test;

import com.generic.DriverUtil;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class AssignmentNo2 {
  @Test
  public void ApplicationStatus() throws InterruptedException 
  {
	//create a driver session
	  AppiumDriver driver=DriverUtil.initDriverSession();
	  
	  
	  //get the package name
	  String packageName=((AndroidDriver)driver).getCurrentPackage();
	  System.out.println("Application Package name is: "+packageName);
	  //get the current status of application
	  System.out.println("Current App status is: "+((AndroidDriver)driver).queryAppState(packageName));
	  
	  //terminate app
	 // ((AndroidDriver)driver).terminateApp(packageName);
	  
	 // System.out.println("After terminate status is: "+((AndroidDriver)driver).queryAppState(packageName));
	  
	  Thread.sleep(1500);
	  //activate App
	   
	  ((AndroidDriver)driver).activateApp(packageName);
	  System.out.println("After activate status is: "+((AndroidDriver)driver).queryAppState(packageName));

	  //uninstall app- removeApp()
	  ((AndroidDriver)driver).removeApp(packageName);
	  System.out.println("After unistalled status is: "+((AndroidDriver)driver).queryAppState(packageName));

	  
	  //install
	  
	  String path=System.getProperty("user.dir")+"//src//test//resources//ApiDemos-debug.apk";
	  ((AndroidDriver)driver).installApp(path);
	  
	  System.out.println("After install status is: "+((AndroidDriver)driver).queryAppState(packageName));

	//Need to activate App So Output show
	   
	  ((AndroidDriver)driver).activateApp(packageName);
	  System.out.println("After activate status is: "+((AndroidDriver)driver).queryAppState(packageName));

	  //run app in background
	  ((AndroidDriver)driver).runAppInBackground(Duration.ofMillis(5000));
	  System.out.println("After Background executions status is: "+((AndroidDriver)driver).queryAppState(packageName));

	  
	  
	  
  }
}
