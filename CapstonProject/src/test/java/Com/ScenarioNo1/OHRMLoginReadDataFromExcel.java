package Com.ScenarioNo1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import ProjectSupportFile.Utility;



public class OHRMLoginReadDataFromExcel {

	String fpath = "ExcelFile\\LoginData.xlsx";
	File file;
	FileInputStream fis ;
	FileOutputStream fos;
	XSSFWorkbook wb ;
	XSSFSheet sheet;
	XSSFRow row ;
	XSSFCell cell;
	int index = 1;
	
	WebDriver driver;
	//for Extentreport
	ExtentSparkReporter htmlReport;
	
	ExtentReports report;
	ExtentTest test1;
	
	
	  @Test(dataProvider = "getLoginData")
	  public void login(String un,String ps) throws InterruptedException {
		  
		  test1 = report.createTest("OHRM_Login_Success");
		 // WebDriver driver = new ChromeDriver();
		//System.out.println(un);
		  //System.out.println(ps);
		  driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(un);
		  driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(ps);
		  driver.findElement(By.xpath("//button[@type='submit']")).click();
		  
		 
		 
		  Thread.sleep(2000);
		  Utility.getScreenshot(driver, ps);
		  Assert.assertTrue(driver.getCurrentUrl().contains("dash"));
		 
		  
	  }
	  @AfterMethod
	  public void logout() {
		//row = sheet.getRow(index);
		  //cell = row.getCell(2);
		  cell =sheet.getRow(index).getCell(2);
		  
		  if(driver.getCurrentUrl().contains("dashboard"))
		  {
			  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/span/i")).click();
			  driver.findElement(By.partialLinkText("Log")).click();
			  System.out.println("Login Successful");
			  cell.setCellValue("Pass");
		  }
		  else
		  {
			  System.out.println("Invailed Credentials");
			  cell.setCellValue("Fail");
			 
		  }
		  index++;
	  }
	
	
	  @DataProvider
	  public Object[][] getLoginData() {
		  int rows =sheet.getPhysicalNumberOfRows();
		  String[][] logindata = new String[rows-1][2];
		  
		  for( int i= 0;i<rows-1;i++)
		  {
			  row = sheet.getRow(i+1);
			  for(int j =0; j<2;j++)
			  {
				  cell= row.getCell(j);
				  logindata[i][j] =cell.getStringCellValue();
			  }
		  }
		  return logindata;
	  }
	  @BeforeTest
	  public void beforeTest() throws IOException {
		  file = new File(fpath);
		  fis = new FileInputStream(file);
		  wb = new XSSFWorkbook(fis);
		  sheet =wb.getSheetAt(0);
		  
		  fos = new FileOutputStream(file);
		  
		  driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		  
		  // OHRM report
		    htmlReport =new ExtentSparkReporter("OHRMLoginReport.html");
		  
		    report = new ExtentReports();
			
			report.attachReporter(htmlReport);
			
			report.setSystemInfo("User", "Nilesh Madeshia");
			report.setSystemInfo("Machine", "Dell");
			report.setSystemInfo("Operating System", "Window11");
			report.setSystemInfo("Browser", "Google Chrome");
			//report.setSystemInfo("User", "Nilesh Madeshia");
			report.setSystemInfo("Email", "nileshmadeshia@gmail.com");
			
			
			htmlReport.config().setDocumentTitle("My Testng Report");
			htmlReport.config().setReportName("My Report");
			htmlReport.config().setTheme(Theme.DARK);
			htmlReport.config().setTimeStampFormat("EEEE MMMM dd yyyy ,hh:mm a'('zzz')'");
			
			 driver = new ChromeDriver();
			 driver.manage().window().maximize();
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			 
			 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			 //for header
			
		  
	  }
	
	  @AfterTest
	  public void afterTest() throws IOException {
		  wb.write(fos);
		  wb.close();
		  fis.close();
		  report.flush();
		  
		  driver.close();
		  
	  }

}
