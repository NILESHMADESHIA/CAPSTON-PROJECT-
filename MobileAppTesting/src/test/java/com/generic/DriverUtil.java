package com.generic;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.options.UiAutomator2Options;

public class DriverUtil 
{
	public static void getScreenshot(AppiumDriver driver,String filename)
	{
		File temp= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir")+"//Screenshots//filename"+System.currentTimeMillis()+".png");
		try {
			FileHandler.copy(temp, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public static AppiumDriver driver;
	public static AppiumDriver initDriverSession() 
	{
		UiAutomator2Options options = new UiAutomator2Options();
		
		//app path
		String path = System.getProperty("user.dir")+"//src//test//resources//ApiDemos-debug.apk";
		
		options.setCapability("appium:app", path);
		
		//server address
		try {
			URL url = new URL("http://0.0.0.0:4723");
			//create driver Session
		driver = new AndroidDriver(url,options);
		System.out.println("Session id: "+driver.getSessionId());
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver;
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
}
