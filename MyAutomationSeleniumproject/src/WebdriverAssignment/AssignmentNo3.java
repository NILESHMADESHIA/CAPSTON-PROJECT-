package WebdriverAssignment;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AssignmentNo3 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
		driver.get("https://register.rediff.com/register/register.php?");		
		WebElement fullName = driver.findElement(By.cssSelector("input[name*=\"name\"]"));
		fullName.sendKeys("NILESH MADESHIA");	
		WebElement choseId = driver.findElement(By.cssSelector("input[name*=\"login\"]"));
		choseId.sendKeys("nileshmadeshia");
		WebElement psw = driver.findElement(By.cssSelector("input[name*=\"passwd\"]"));
		psw.sendKeys("nilesh@1234");
		WebElement repsw = driver.findElement(By.cssSelector("input[name*=\"confirm_passwd\"]"));
		repsw.sendKeys("nilesh@1234");
		WebElement altId = driver.findElement(By.cssSelector("input[name*=\"altemail\"]"));
		altId.sendKeys("nkmadeshia@gmail.com");
		WebElement mobilNo = driver.findElement(By.cssSelector("input[id=\"mobno\"]"));
		mobilNo.sendKeys("7985794217");
		WebElement droplst = driver.findElement(By.id("country"));
		// DROP DOWN LIST	
		Select countries = new Select(droplst);		
		System.out.println("Selected Country"     + countries.getFirstSelectedOption().getText());
		List<WebElement> countryList = countries.getOptions();		
		System.out.println("Total Countries: "   +countryList.size());  //SHOW THE COUNRTIES LIST
		for(WebElement c: countryList)
				System.out.println(c.getText());		 
		// USING SPECIFIC CRITERIA SELECT BY VISIBLE TEXT		
		countries.selectByVisibleText("Germany");
		System.out.println("Selected Country"     + countries.getFirstSelectedOption().getText()); //THIS LINE SHOW SELECTED COUNTRY)
		

	}

}
