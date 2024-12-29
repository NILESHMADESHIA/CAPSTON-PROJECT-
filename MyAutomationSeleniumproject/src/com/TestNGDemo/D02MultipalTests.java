package com.TestNGDemo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class D02MultipalTests {
	@Test   (priority = 3)
	public void testMeesho()
	{
		WebDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  driver.get("https://www.meesho.com/");
		  System.out.println("Tital:"  +  driver.getTitle());
		  driver.close();
	}
	@Test     (priority = 4)
	public void testAjio()
	{
		WebDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  driver.get("https://www.ajio.com/");
		  System.out.println("Tital:"  +  driver.getTitle());
		  driver.close();
	}
	@Test  (priority = 1)
	public void testNykaa()
	{
		WebDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  driver.get("https://www.nykaafashion.com/");
		  System.out.println("Tital:"  +  driver.getTitle());
		  driver.close();
	}
	@Test    (priority = 2)
	public void testBewakoof()
	{
		WebDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  driver.get("https://www.bewakoof.com/");
		  System.out.println("Tital:"  +  driver.getTitle());
		  driver.close();
	}

}
