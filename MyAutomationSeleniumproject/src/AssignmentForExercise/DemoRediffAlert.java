package AssignmentForExercise;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoRediffAlert {

	public static void main(String[] args) {
		

		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		Alert alt;
		
		
		driver.findElement(By.id("login1")).sendKeys("nileshkm");
		driver.findElement(By.name("proceed")).click();
		
		alt = driver.switchTo().alert();
		System.out.println(alt.getText());
		driver.close();
		
		
		
		
		
		
		// TODO Auto-generated method stub

	}

}
