package com.MyTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class D06TestNg_ExtentReport {
	
	
	WebDriver driver;
	
	ExtentSparkReporter htmlReport;
	
	ExtentReports report;
	ExtentTest test1;
	
	
	  @Test(priority = 1)
	  public void logintoOHRM_Success() throws InterruptedException {
		  
		  test1 = report.createTest("OHRM_Login_Success");
		  
		  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")).sendKeys("admin");
		  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")).sendKeys("admin123");
		  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).sendKeys(Keys.ENTER);
		  
		  Assert.assertTrue(driver.getCurrentUrl().contains("desh"));
		  
		  Thread.sleep(2000);
		  
		  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/span/i")).click();
		  driver.findElement(By.partialLinkText("Log")).click();
		  
	  }
	  @Test(priority = 2)
	  public void logintoOHRM_Fail() {
		  
		  test1 = report.createTest("OHRM_Login_Fail");
		  
		  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")).sendKeys("Admin");
		  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")).sendKeys("admin123");
		  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).sendKeys(Keys.ENTER);
		  
		  Assert.assertTrue(driver.getTitle().contains("dash"));
		  
	  }
	  
	  @Test(priority = 3)
	  public void logintoOHRM_Skip() {
		  test1 = report.createTest("OHRM_Login_Skip");
		  
		  throw new SkipException("skipping the test for testing purpose");
		  		  
	  }
	  @AfterMethod
	  public void afterMethod(ITestResult result) {
		  
		  if (result.getStatus() == ITestResult.SUCCESS)
		  {
			  test1.log(Status.PASS,MarkupHelper.createLabel(result.getName(),ExtentColor.GREEN));
		  }
		  else if (result.getStatus()== ITestResult.FAILURE)
		  {
			  test1.log(Status.FAIL,MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
			  test1.fail(result.getThrowable());
			  
		  }
		  else if(result.getStatus()==ITestResult.SKIP)
		  {
			  test1.log(Status.SKIP,MarkupHelper.createLabel(result.getName(), ExtentColor.ORANGE));
			  test1.skip(result.getThrowable());
		  }
			  
	  }
	
	  @BeforeTest
	  public void beforeTest() {
		  htmlReport =new ExtentSparkReporter("MyDetailedReporthjk.html");
		  
		    report = new ExtentReports();
			
			report.attachReporter(htmlReport);
			
			report.setSystemInfo("User", "Nilesh Madeshia");
			report.setSystemInfo("Machine", "Dell");
			report.setSystemInfo("Operating System", "Window11");
			report.setSystemInfo("Browser", "Google Chrome");
			//report.setSystemInfo("User", "Nilesh Madeshia");
			//report.setSystemInfo("Email", "nileshmadeshia@gmail.com");
			//report.setSystemInfo("Guidence By", "Ankush Vankore");
			
			htmlReport.config().setDocumentTitle("My Testng Report");
			htmlReport.config().setReportName("My Report");
			htmlReport.config().setTheme(Theme.DARK);
			htmlReport.config().setTimeStampFormat("EEEE MMMM dd yyyy ,hh:mm a'('zzz')'");
			
			 driver = new ChromeDriver();
			 driver.manage().window().maximize();
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			 
			 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  }
	
	  @AfterTest
	  public void afterTest() {
		 // driver.close();
		  report.flush();
	  }

}
