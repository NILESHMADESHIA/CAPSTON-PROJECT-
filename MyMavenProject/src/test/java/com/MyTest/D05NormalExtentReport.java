package com.MyTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class D05NormalExtentReport {

	public static void main(String[] args) {
		ExtentSparkReporter htmlReport = new ExtentSparkReporter("MyFirstReport.html");
		ExtentReports report = new ExtentReports();
		
		report.attachReporter(htmlReport);
		
		ExtentTest test ;
		
		
		report.setSystemInfo("User", "Nilesh Madeshia");
		report.setSystemInfo("Machine", "Dell");
		report.setSystemInfo("Operating System", "Window11");
		report.setSystemInfo("Browser", "Google Chrome");
		report.setSystemInfo("User", "Nilesh Madeshia");
		report.setSystemInfo("Email", "nileshmadeshia@gmail.com");
		report.setSystemInfo("Guidence By", "Ankush Vankore");
		
		htmlReport.config().setDocumentTitle("Rediff Test");
		htmlReport.config().setReportName("Report for Rediff Page");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setTimeStampFormat("dd-MMM-yyy");
		
		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.get("https://www.rediff.com/");
		 
		 System.out.println("Title:  "  + driver.getTitle());
		 
		 driver.close();
		 
		 test = report.createTest("Rediff Title");
		 test.log(Status.PASS, MarkupHelper.createLabel("Rediff Title Test : Pass", ExtentColor.GREEN));
		 
		 report.flush();
		 
		
		

	}

}
