package AssignmentForExercise;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoomayoblogspotExplicitlyWait {

	public static void main(String[] args) {
		
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.get("https://omayo.blogspot.com/");
		
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"dte\"]")));
		driver.findElement(By.xpath("//*[@id=\"HTML47\"]/div[1]/button")).click();
		WebDriverWait waiting = new WebDriverWait(driver,Duration.ofSeconds(10));
		//List<WebElement> clk = driver.findElements(By.xpath("//*[@id=\"dte\"]"));
		//wait.until(ExpectedConditions.visibilityOfElementLocated())
		
		// TODO Auto-generated method stub

	}

}
