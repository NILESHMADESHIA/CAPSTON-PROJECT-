package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D09LocateByCssSelectorSpecalCharactor {

	public static void main(String[] args) {
		
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		//* for any word
		
		WebElement emailId = driver.findElement(By.cssSelector("input[placeholder*=\"address \"]"));
		emailId.sendKeys("nkmadeshia@gmail.com");
		//% for end
		
		WebElement pasword = driver.findElement(By.cssSelector("input[placeholder$=\"word\"]"));
		pasword.sendKeys("nilesh@12345");
		//^ for Start
		WebElement logbtn = driver.findElement(By.cssSelector("button[id^=\"u_0_5\"]"));
		logbtn.click();
		// TODO Auto-generated method stub

	}

}
