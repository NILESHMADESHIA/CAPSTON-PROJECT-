package com.WebDriverDemos;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class D25HendlingAlert {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoqa.com/alerts");
		
		Alert alt;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].click()",driver.findElement(By.id("alertButton")));
		
		alt = driver.switchTo().alert();
		System.out.println(alt.getText());
		alt.accept();
		
		

		js.executeScript("arguments[0].click()",driver.findElement(By.id("timerAlertButton")));
		Thread.sleep(5000);
		alt = driver.switchTo().alert();
		System.out.println(alt.getText());
		alt.accept();
		
		
		js.executeScript("window.scrollBy(0,450)", "");
		driver.findElement(By.id("confirmButton")).click();
		alt = driver.switchTo().alert();
		System.out.println(alt.getText());
		alt.dismiss();
		System.out.println(driver.findElement(By.id("confirmResult")).getText());
		
		driver.findElement(By.id("promtButton")).click();
		alt = driver.switchTo().alert();
		alt.sendKeys("Nilesh");
		alt.accept();
		System.out.println(driver.findElement(By.id("promptResult")).getText());
		
		driver.close();
		
		
		
		
		
		
		
		// TODO Auto-generated method stub

	}

}
