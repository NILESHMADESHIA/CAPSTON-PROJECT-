package AssignmentForExercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoForrediffmailaccount {

	public static void main(String[] args) {
		
WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://register.rediff.com/register/register.php?");
		
		
		WebElement fullName = driver.findElement(By.cssSelector("input[name*=\"name\"]"));
		fullName.sendKeys("NILESH MADESHIA");
		
		
		WebElement choseId = driver.findElement(By.cssSelector("input[name*=\"login\"]"));
		choseId.sendKeys("nileshmadeshia");
		// Using *
		WebElement psw = driver.findElement(By.cssSelector("input[name*=\"passwd\"]"));
		psw.sendKeys("nilesh@1234");
		
		WebElement repsw = driver.findElement(By.cssSelector("input[name*=\"confirm_passwd\"]"));
		repsw.sendKeys("nilesh@1234");
		

		WebElement altId = driver.findElement(By.cssSelector("input[name*=\"altemail\"]"));
		altId.sendKeys("nkmadeshia@gmail.com");
		// TODO Auto-generated method stub
		
		WebElement mobilNo = driver.findElement(By.cssSelector("input[id=\"mobno\"]"));
		
		mobilNo.sendKeys("7985794217");

	}

}
