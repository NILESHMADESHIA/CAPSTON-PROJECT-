package com.TestNGDemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class D06DataDrivenTesting {
	
	  WebDriver driver;
	  @Test(dataProvider = "getLoginData")
	  public void loginToOHRM(String un,String ps) {
		  
		  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")).sendKeys(un);
		  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")).sendKeys(ps);
		  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).sendKeys(Keys.ENTER);
		  
		 
		  
	  }
	  
	  @DataProvider
	  public Object[][] getLoginData() {
	    return new Object[][] {
	      new Object[] { "swarna" ,"swarna123" },
	      new Object[] { "nilima","nilima123" },
	      new Object[] { "admin","admin123"},
	      new Object[] {"lekha", "lekha123"},
	      new Object[] {"nilesh", "nilesh123"},
	    };
	  }
	  @BeforeMethod
	  public void beforeMethod() {
		  
	  }
	
	  @AfterMethod
	  public void logout() {
		  
		  if(driver.getCurrentUrl().contains("dashboard"))
		  {
			  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/span/i")).click();
			  driver.findElement(By.partialLinkText("Log")).click();
			  System.out.println("Login Successful");
		  }
		  else
		  {
			  System.out.println("Invailed Credentials");
			 
		  }
	  }
	
	
	 
	  @BeforeTest
	  public void beforeTest() {
		  
		  driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  }
	
	  @AfterTest
	  public void afterTest() {
		  driver.close();
	  }

}
