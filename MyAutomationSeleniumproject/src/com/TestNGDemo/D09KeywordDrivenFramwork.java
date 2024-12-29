package com.TestNGDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class D09KeywordDrivenFramwork {
	String fPath = "D:\\Nilesh_SeleniumDemo\\MyAutomationSeleniumproject\\src\\com\\TestNGDemo\\MyLocaterEchoTrack.properties";
	File file;
	FileInputStream fis;
	Properties prop;
	WebDriver driver;
	  
	
	  @Test
	  public void login() {
		  driver.findElement(By.xpath(prop.getProperty("unTxBxXath"))).sendKeys("Nilesh");
		  driver.findElement(By.id(prop.getProperty("pstxBxId"))).sendKeys("nilesh123");
		  driver.findElement(By.cssSelector(prop.getProperty("lgBtnCss"))).click();
	  }
	  @AfterMethod
	  public void afterMethod() {
		  System.out.println(driver.findElement(By.className(prop.getProperty("errMsgClass"))).getText());
	  }
	
	  @BeforeTest
	  public void beforeTest() throws IOException {
		  file = new File(fPath);
		  fis = new FileInputStream(file);
		  prop = new Properties();
		  prop.load(fis);
		  
		  driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  driver.get(prop.getProperty("url"));
	  }
	
	  @AfterTest
	  public void afterTest() {
		  driver.close();
	  }

}
