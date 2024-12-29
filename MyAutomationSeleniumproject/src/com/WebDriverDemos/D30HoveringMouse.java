package com.WebDriverDemos;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class D30HoveringMouse {

	public static void main(String[] args) {
		

		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.istqb.in/");
		Actions act = new Actions(driver);
		WebElement spMenu = driver.findElement(By.linkText("SPECIALIST"));
		act.moveToElement(spMenu).perform();
		
		List<WebElement> menu =driver.findElements(By.xpath("//*[@id=\"sp-menu\"]/div/nav/ul/li[6]/div/div/ul/li"));
		
		for(WebElement m: menu)
			System.out.println(m.getText());
		
		
		// TODO Auto-generated method stub

	}

}
