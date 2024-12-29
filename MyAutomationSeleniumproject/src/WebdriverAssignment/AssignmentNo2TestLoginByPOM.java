package WebdriverAssignment;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentNo2TestLoginByPOM {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		AssignmentNo2_First_LoginPageofPOM Logpg =new AssignmentNo2_First_LoginPageofPOM(driver);
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		Logpg.enterusername("admin");
		Logpg.enterpassword("admin123");
		Logpg.clickbtn();
		// TODO Auto-generated method stub

	}

}
