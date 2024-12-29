package com.TestNGDemo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class D04BeforeAfterMethod {
	WebDriver driver;
	
	  @BeforeTest
	  public void launchBroweser()
	  {
		  System.out.println("Before Test");
		  driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  }
	  @AfterTest
	  public void closeBroweser()
	  {
		  System.out.println("After Test");
		  driver.close();
	  }
	  @BeforeMethod
	  public void beforeMethod()
	  {
		  System.out.println("BeforeMethod");
	  }
	  @AfterMethod()
	  public void printTitle()
	  {
		  System.out.println("Tital:"  +  driver.getTitle());
		  System.out.println("After Method");

	  }	  
	  @Test   (priority = 3)
		public void testMeesho()
		{
			  driver.get("https://www.meesho.com/");	 
		}
		@Test     (priority = 4)
		public void testAjio()
		{
			  driver.get("https://www.ajio.com/");
		}
		@Test  (priority = 1)
		public void testNykaa()
		{
			  driver.get("https://www.nykaafashion.com/");
		}
		@Test    (priority = 2)
		public void testBewakoof()
		{
			  driver.get("https://www.bewakoof.com/");	 
		}
}
