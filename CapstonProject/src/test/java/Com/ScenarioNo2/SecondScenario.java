package Com.ScenarioNo2;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import ProjectSupportFile.Utility;

public class SecondScenario {
	public String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	public WebDriver driver ; 

	@BeforeTest
	public void setup()
	{
		System.out.println("Before Test executed");
		// TODO Auto-generated method stub
		driver=new ChromeDriver();

		//maximise windows
		driver.manage().window().maximize();

		//open url
		driver.get(baseUrl);

		//timer i kept as 60 you can keep 40
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60)); //60 seconds
	}
	@Test(priority = 1)
	public void loginTest()
	{
		//find username and enter username "Admin"
				driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");

				//find password and enter password admin123
				driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");

				//login button click
				driver.findElement(By.xpath("//button[@type='submit']")).submit();


				// Verify if the login was successful by checking the page title
				String pageTitle = driver.getTitle();

				/*	if (pageTitle.equals("OrangeHRM")) {
					System.out.println("Login successful!");
				} else {
					System.out.println("Login failed!");
				}*/
				//logOut();
				Assert.assertEquals("OrangeHRM", pageTitle);
	}
	@Test(priority = 2)
	public void headersReading()
	{

		List<WebElement>header =driver.findElements(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li"));
		
		for(WebElement hed : header)
			System.out.println(hed.getText());
	}
	@Test(priority = 3)
	public void empSearchByName()throws InterruptedException
	{
		//logIn();

		//find PIM Menu and click on PIM Menu
		driver.findElement(By.xpath("//span[text()='PIM']")).click();

		//Select Employee List
		driver.findElement(By.xpath("//a[normalize-space()='Employee List']")).click();

		driver.findElements(By.tagName("input")).get(1).sendKeys("manda akhil");

		//Click the search button.
		driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();

		//    //span[@class='oxd-text oxd-text--span']
		Thread.sleep(5000)	;
		List<WebElement> element=	driver.findElements(By.xpath("//span[@class='oxd-text oxd-text--span']"));

		String expected_message = "Record Found";
		String message_actual = element.get(0).getText();
		System.out.println(message_actual);
		Utility.getScreenshot(driver, message_actual);

		logOut();

		Assert.assertTrue(message_actual.contains(expected_message));


		
	}

	@Test(priority =4)
	public void searchEmployeeById() throws InterruptedException
	{

		String empId = "0389";
		String message_actual ="";
		logIn();


		//find PIM Menu and click on PIM Menu
		driver.findElement(By.xpath("//span[text()='PIM']")).click();

		//Select Employee List
		driver.findElement(By.xpath("//a[normalize-space()='Employee List']")).click();

		//enter empoyee id
		driver.findElements(By.tagName("input")).get(2).sendKeys(empId);

		//Click the search button.
		driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();

		Thread.sleep(2000)	;

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.scrollBy(0," + 500 + ")");

		Thread.sleep(2000)	;


		List<WebElement> rows = driver.findElements(By.xpath("(//div[@role='row'])"));


		if(rows.size()>1)
		{
			message_actual = driver.findElement(By.xpath("((//div[@role='row'])[2]/div[@role='cell'])[2]")).getText();

		}
		Utility.getScreenshot(driver, message_actual);

		logOut();
		Assert.assertEquals(empId, message_actual);

	}

	public void logIn()
	{
		//find username and enter username "Admin"
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");

		//find password and enter password admin123
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");

		//login button click
		driver.findElement(By.xpath("//button[@type='submit']")).submit();

	}

	public void logOut() 
	{
		driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).click();
		//driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();

		List <WebElement> elementlist = driver.findElements(By.xpath("//a[@class='oxd-userdropdown-link']"));

		/*for (int i=0; i<elementlist.size(); i++)
		{
			Thread.sleep(1000);
			System.out.println(i + ":" + elementlist.get(i).getText());

		}*/

		elementlist.get(3).click();//click on logout



	}
	@AfterTest
	public void closeOhrm() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.close();
		driver.quit();
	}

}
