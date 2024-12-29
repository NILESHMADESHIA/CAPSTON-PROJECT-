package WebdriverAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AssignmentNo2_First_LoginPageofPOM {
	
	WebDriver driver;
	
	AssignmentNo2_First_LoginPageofPOM(WebDriver d)
	{
		driver = d;
	}
	
	By username = By.xpath("//input[@placeholder='Username']");
	By password = By.xpath("//input[@placeholder='Password']");
	By loginBtn = By.xpath("//button[@type='submit']");
	
	public void enterusername(String un)
	{
		driver.findElement(username).sendKeys(un);
	}
	public void enterpassword(String ps)
	{
		driver.findElement(password).sendKeys(ps);
	}
	public void clickbtn()
	{
		driver.findElement(loginBtn).click();
	}
	
	
}
