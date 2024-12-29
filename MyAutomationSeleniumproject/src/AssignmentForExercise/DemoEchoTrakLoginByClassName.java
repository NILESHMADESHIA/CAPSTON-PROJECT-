package AssignmentForExercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class DemoEchoTrakLoginByClassName {

	public static void main(String[] args) {
		
			
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.echotrak.com/Login.aspx?ReturnUrl=%2f");
		
		WebElement emailId = driver.findElement(By.className("form-control"));
		emailId.sendKeys("nkmadeshia@gmail.com");
		
		WebElement pasword = driver.findElement(By.name("txtPassword"));
		pasword.sendKeys("nilesh@12345");
		
		WebElement logbtn = driver.findElement(By.className("btn"));
		logbtn.click();
		WebElement errMsg = driver.findElement(By.id("lblMsg"));
		String msg=errMsg.getText();
		System.out.println("Erroe Massage"   + msg);
		
		if (msg.contains("Invalid"))
			System.out.println("test case pass");
		else
			System.out.println("Test Case Failed");
		
		
			
		
		
		

	}

}
