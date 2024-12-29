package AssignmentForExercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class DemoEchoTrakLoginByName {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.echotrak.com/Login.aspx?ReturnUrl=%2f");
		
		WebElement emailId = driver.findElement(By.name("txtCustomerID"));
		emailId.sendKeys("nkmadeshia@gmail.com");
		
		WebElement pasword = driver.findElement(By.name("txtPassword"));
		pasword.sendKeys("nilesh@12345");
		
		WebElement logbtn = driver.findElement(By.name("Butsub"));
		logbtn.click();
		// TODO Auto-generated method stub

	}

}
