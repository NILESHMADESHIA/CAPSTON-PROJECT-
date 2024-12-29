package E_Commerce_demoblaze;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import ProjectSupportFile.Utility;

public class Demoblazelogin {
	
	public String baseUrl = "https://www.demoblaze.com/";
	public WebDriver driver ; 
	ExtentSparkReporter htmlReport;
	
	ExtentReports report;
	ExtentTest test1;
	
	@BeforeTest
	public void setup()
	{
		System.out.println("Before Test executed");
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60)); //60 seconds
		/*driver.findElement(By.xpath("//*[@id=\"signin2\"]")).click();

		
		driver.findElement(By.xpath("//*[@id=\"sign-username\"]")).sendKeys("nileshmadeshia");
		driver.findElement(By.xpath("//*[@id=\"sign-password\"]")).sendKeys("password");

		//login button click
		driver.findElement(By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]")).click();
		Alert alt;
		alt = driver.switchTo().alert();
		System.out.println(alt.getText());
		alt.accept();*/
		htmlReport =new ExtentSparkReporter("DemoblazeReport.html");
		  
	    report = new ExtentReports();
		
		report.attachReporter(htmlReport);
		
		report.setSystemInfo("User", "Nilesh Madeshia");
		report.setSystemInfo("Machine", "Dell");
		report.setSystemInfo("Operating System", "Window11");
		report.setSystemInfo("Browser", "Google Chrome");
		//report.setSystemInfo("User", "Nilesh Madeshia");
		report.setSystemInfo("Email", "nileshmadeshia@gmail.com");
		//report.setSystemInfo("Guidence By", "Ankush Vankore");
		
		htmlReport.config().setDocumentTitle("My Testng Report");
		htmlReport.config().setReportName("My Report");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setTimeStampFormat("EEEE MMMM dd yyyy ,hh:mm a'('zzz')'");
		
		
		
	}
	@Test(priority = 1)
	public void loginTest() throws InterruptedException 
	{
		
				driver.findElement(By.xpath("//*[@id=\"login2\"]")).click();

				
				driver.findElement(By.xpath("//*[@id=\"loginusername\"]")).sendKeys("nileshmadeshia");
				driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/form/div[2]/input")).sendKeys("password");

				//login button click
				driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")).click();
				Thread.sleep(2000);
				
				
				
				//
				


				// Verify if the login was successful by checking the page title
				//String pageTitle = driver.getTitle();

				/*	if (pageTitle.equals("OrangeHRM")) {
					System.out.println("Login successful!");
				} else {
					System.out.println("Login failed!");
				}*/
				//logOut();
				//Assert.assertEquals("OrangeHRM", pageTitle);
	}
	@Test(priority =2)
	public void addtoCartMobile() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id=\"cat\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[1]/div/div/h4/a")).click();
		driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a")).click();
		
		Thread.sleep(2000);
		Alert alt;
		alt = driver.switchTo().alert();
		System.out.println(alt.getText());
		alt.accept();
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//*[@id=\"cartur\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button")).click();
		/*driver.findElement(By.xpath("//*[@id=\"cartur\"]"));
		driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button"));*/
		driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("NILESH");
		driver.findElement(By.xpath("//*[@id=\"country\"]")).sendKeys("INDIA");
		driver.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys("LUCKNOW");
		driver.findElement(By.xpath("//*[@id=\"card\"]")).sendKeys("123654789");
		driver.findElement(By.xpath("//*[@id=\"month\"]")).sendKeys("DECEMBER");
		driver.findElement(By.xpath("//*[@id=\"year\"]")).sendKeys("2024");
		driver.findElement(By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]")).click();
		Utility.getScreenshot(driver, baseUrl);
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[10]/div[7]/div/button")).click();
		
	}
	@Test(priority =3)
	public void addtoCartLaptop() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id=\"itemc\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/div/h4/a")).click();
		driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a")).click();
		
		Thread.sleep(2000);
		Alert alt;
		alt = driver.switchTo().alert();
		System.out.println(alt.getText());
		alt.accept();
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//*[@id=\"cartur\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button")).click();
		/*driver.findElement(By.xpath("//*[@id=\"cartur\"]"));
		driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button"));*/
		driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("NILESH");
		driver.findElement(By.xpath("//*[@id=\"country\"]")).sendKeys("INDIA");
		driver.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys("LUCKNOW");
		driver.findElement(By.xpath("//*[@id=\"card\"]")).sendKeys("123654789");
		driver.findElement(By.xpath("//*[@id=\"month\"]")).sendKeys("DECEMBER");
		driver.findElement(By.xpath("//*[@id=\"year\"]")).sendKeys("2024");
		driver.findElement(By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]")).click();
		//Utility.getScreenshot(driver, baseUrl);
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[10]/div[7]/div/button")).click();
		
	
		
	}
	
	@AfterTest
	public void closeOhrm() throws InterruptedException
	{
		
		
		Thread.sleep(2000);
		report.flush();
		 
		driver.close();
		
	}

}
