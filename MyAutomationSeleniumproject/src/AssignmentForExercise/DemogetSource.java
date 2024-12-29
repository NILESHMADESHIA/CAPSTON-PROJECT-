package AssignmentForExercise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemogetSource {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		String getsource = driver.getPageSource();
		System.out.println("PageSourec:" + getsource);
		

	}

}
