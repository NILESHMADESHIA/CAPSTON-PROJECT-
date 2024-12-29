//Write a WebDriver script to navigate to a website and click on a specific link.
package WebdriverAssignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentNo1 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.flipkart.com/");
		
		
		driver.findElement(By.partialLinkText("Grocery")).click();//clicking on Grocery link
		
		driver.close();		
	}

}
