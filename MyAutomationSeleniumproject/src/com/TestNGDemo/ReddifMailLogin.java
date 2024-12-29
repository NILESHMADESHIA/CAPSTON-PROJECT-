package com.TestNGDemo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReddifMailLogin {
	WebDriver driver;
	
	
	/*public ReddifMailLogin(WebDriver d)
	{
		driver = d;
	}*/
	
	
	public void clickOnSignLink()
	{
		driver.findElement(By.partialLinkText("Sign")).click();
	}
	public ReddifMailLogin(WebDriver driver) {
		
		this.driver = driver;
	}
	public void  enterUserName(String un)
	{
		driver.findElement(By.id("login1")).sendKeys(un);
		
	}
	public void submit()
	{
		driver.findElement(By.name("proceed")).click();		
	}
	public void handleAlert()
	{
		Alert alt =driver.switchTo().alert();
		System.out.println(alt.getText());
		alt.accept();
	}
	

}
