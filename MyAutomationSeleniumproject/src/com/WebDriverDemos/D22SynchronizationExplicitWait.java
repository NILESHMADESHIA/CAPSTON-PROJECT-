package com.WebDriverDemos;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class D22SynchronizationExplicitWait {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in/");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		
		driver.findElement(By.id("src")).sendKeys("Deor");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\\\"autoSuggestContainer\\\"]/div/div/div[1]/div/div[1]/ul/li[1]/div/text"))).click();
		
		driver.findElement(By.xpath("//*[@id=\"autoSuggestContainer\"]/div/div/div[1]/div/div[1]/ul/li[1]/div/text")).click();
		
		driver.findElement(By.id("dest")).sendKeys("Luck");
		driver.findElement(By.xpath("//*[@id=\"autoSuggestContainer\"]/div/div/div[3]/div[1]/ul/li[1]/div/text")).click();
		
		driver.findElement(By.xpath("//*[@id=\"onwardCal\"]/div/i")).click();
		
		driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[2]/main[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/div[2]/div[1]/div[1]/div[3]/div[6]/span[1]/div[4]/span[1]")).click();
		
		driver.findElement(By.id("search_button")).click();
		
		//String bus = driver.findElement(By.xpath("//*[@id=\"17736633\"]/div/div[1]/div[1]/div[1]/div[1]")).getText();
		
		//System.out.println(bus);
		System.out.println(driver.findElement(By.xpath("//*[@id=\"17736633\"]/div/div[1]/div[1]/div[1]/div[1]")).getText());
		
		driver.close();
		
		// TODO Auto-generated method stub

	}

}
