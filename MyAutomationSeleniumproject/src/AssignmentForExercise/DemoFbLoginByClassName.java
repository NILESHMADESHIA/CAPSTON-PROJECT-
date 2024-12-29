package AssignmentForExercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class DemoFbLoginByClassName {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/login/");
		
		WebElement emailId = driver.findElement(By.className("inputtext"));
		emailId.sendKeys("nkmadeshia@gmail.com");
		
		WebElement pasword = driver.findElement(By.name("pass"));
		pasword.sendKeys("nilesh@12345");
		
		WebElement logbtn = driver.findElement(By.className("_42ft"));
		logbtn.click();
		


		// TODO Auto-generated method stub

	}

}
