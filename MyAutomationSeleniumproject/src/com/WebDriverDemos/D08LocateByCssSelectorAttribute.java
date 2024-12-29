package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D08LocateByCssSelectorAttribute {

	public static void main(String[] args) {
		

		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/login/");
		
		WebElement emailId = driver.findElement(By.cssSelector("input[type=\"text\"]"));
		emailId.sendKeys("nkmadeshia@gmail.com");
		
		WebElement pasword = driver.findElement(By.cssSelector("input[name=\"pass\"]"));
		pasword.sendKeys("nilesh@12345");
		WebElement logbtn = driver.findElement(By.cssSelector("button[name=\"login\"]"));
		logbtn.click();
		// TODO Auto-generated method stub

	}

}
