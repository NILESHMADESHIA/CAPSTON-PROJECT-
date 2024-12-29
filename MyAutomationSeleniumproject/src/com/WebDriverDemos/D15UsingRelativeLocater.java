package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class D15UsingRelativeLocater {

	public static void main(String[] args) {
		
WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/login/");
		driver.findElement(RelativeLocator.with(By.tagName("input")).above(By.name("pass"))).sendKeys("nileshmadeshia@gmail.com");
		driver.findElement(RelativeLocator.with(By.tagName("input")).above(By.name("login"))).sendKeys("nileshmadeshia");
		driver.findElement(RelativeLocator.with(By.tagName("button")).below(By.id("pass"))).click();
		// TODO Auto-generated method stub

	}

}
