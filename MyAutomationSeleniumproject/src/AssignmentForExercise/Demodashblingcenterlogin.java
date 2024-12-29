package AssignmentForExercise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demodashblingcenterlogin {

	public static void main(String[] args) throws InterruptedException  {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://dash.bling-center.com/platform/signIn.html");
		
		driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[2]/div/div/div[5]/button/p")).click();
		driver.findElement(By.id("email1")).sendKeys("nileshmadeshia@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div/div[2]/button[2]/p")).click();
		Thread.sleep(5000);
		
		WebElement errMsg = driver.findElement(By.xpath("//*[@id=\"resetsuccess\"]"));
		
		String msg=errMsg.getText();
		
		System.out.println("Erroe Massage"   + msg);
		
		
		// TODO Auto-generated method stub

	}

}
