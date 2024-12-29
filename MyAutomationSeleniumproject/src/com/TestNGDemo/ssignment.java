package com.TestNGDemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ssignment {
	  WebDriver driver ;
	  JavascriptExecutor js;
	  
	  @Test(priority =1 , groups ="cellphone")
	  public void mobileTest() {
		 WebElement mobile = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div[1]/div/div/div/div[2]/div[1]/div/div[1]/div/div/div/div/div[1]/a[2]/div/div/div/div/img"));
		 js.executeScript("arguments[0].click()", mobile);
		 
		  
	  }
	  @Test(priority =2 ,groups ="cloths")
	  public void faishonTest() {
		 WebElement fashion = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div[1]/div/div/div/div[2]/div[1]/div/div[1]/div/div/div/div/div[1]/div[1]"));
		 js.executeScript("arguments[0].click()", fashion);
		  
	  }
	  @Test(priority =3,groups ="cellphone")
	  public void electronicTest() {
		 WebElement electronic = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div[1]/div/div/div/div[2]/div[1]/div/div[1]/div/div/div/div/div[1]/div[2]"));
		 js.executeScript("arguments[0].click()", electronic);
	  }
	  @Test(priority =4 ,groups ="cloths")
	  public void homeTest() {
		  WebElement home =driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div[1]/div/div/div/div[2]/div[1]/div/div[1]/div/div/div/div/div[1]/div[3]"));
		  js.executeScript("arguments[0].click()", home);
		  
	  }
	  
	  @BeforeMethod (alwaysRun = true)
	  public void launchingFlipkart() {
		  driver.get("https://www.flipkart.com/");
		  System.out.println("Tital : "  +  driver.getTitle());
	  }
	
	  @AfterMethod (alwaysRun = true)
	  public void printTitle() {
		  System.out.println("Tital : "  +  driver.getTitle());
		  
	  }
	
	  @BeforeTest (alwaysRun = true)
	  public void launchingBroweser() {
		  
		  driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  
		js = (JavascriptExecutor)driver;
		 
	  }
	
	  @AfterTest (alwaysRun = true)
	  public void closeBrowser() {
		  driver.close();
	  }

}
