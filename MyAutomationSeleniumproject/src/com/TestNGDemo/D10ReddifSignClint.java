package com.TestNGDemo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class D10ReddifSignClint {
	  public static WebDriver Rdriver;
	  ReddifMailLogin r1;
	  @Test
	  public void rediffSignIn() {
		  r1.clickOnSignLink();
		  r1.enterUserName("Nilesh");
		  r1.submit();
		  r1.handleAlert();
	  }
	  @BeforeTest
	  public void beforeTest() {
		  Rdriver = new ChromeDriver();
		  Rdriver.manage().window().maximize();
		  Rdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  Rdriver.get("https://www.rediff.com/");
		  
		  r1 =new ReddifMailLogin(Rdriver);
	  }
	  
	
	  @AfterTest
	  public void afterTest() {
		  Rdriver.close();
	  }

}
